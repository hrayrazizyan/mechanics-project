import java.util.Stack;

public class SpringArray {
    public static Spring equivalentSpring(String springExpr){
        if(!validateSpringExpr(springExpr)){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < springExpr.length()/2; i++){
            if(springExpr.charAt(i) == '['){
                stack.push(0);
            }
            else {
                stack.push(1);
            }
        }
        Spring spring = new Spring();
        stack.pop();
        while (!stack.isEmpty()){
            Spring newSpring = new Spring();
            if(stack.peek() == 1){
                spring = spring.inSeries(newSpring);
            }
            else {
                spring = spring.inParallel(newSpring);
            }
            stack.pop();
        }
        return spring;
    }

    public static Spring equivalentSpring(String springExpr, Spring[] springs){
        if(!validateSpringExpr(springExpr) || springExpr.length()/2 != springs.length){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < springExpr.length()/2; i++){
            if(springExpr.charAt(i) == '['){
                stack.push(0);
            }
            else {
                stack.push(1);
            }
        }
        Spring spring = new Spring(springs[0].getK());
        stack.pop();
        int i  = 1;
        while (!stack.isEmpty()){
            if(stack.peek() == 1){
                spring = spring.inSeries(springs[i]);
            }
            else {
                spring = spring.inParallel(springs[i]);
            }
            i++;
            stack.pop();
        }
        return spring;
    }

    public static boolean validateSpringExpr(String springExpr){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < springExpr.length()/2; i++){
            if(springExpr.charAt(i) == '['){
                stack.push(0);
            }
            else if(springExpr.charAt(i) == '{'){
                stack.push(1);
            }
            else return false;
        }
        int i = springExpr.length()/2;
        while (!stack.isEmpty() || i < springExpr.length()){
            if(springExpr.charAt(i) == ']' && stack.peek() == 0){
                stack.pop();
                i++;
            }
            else if(springExpr.charAt(i) == '}' && stack.peek() == 1){
                stack.pop();
                i++;
            }
            else return false;
            }
        if(stack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
