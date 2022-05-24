public class Main {
    public static void main (String[] args){
        Spring springs[] = new Spring[6];
        springs[0] = new Spring(6);
        springs[1] = new Spring(0.5);
        springs[2] = new Spring(2);
        springs[3] = new Spring(4);
        springs[4] = new Spring(0.8);
        springs[5] = new Spring(3);
        Spring spring = SpringArray.equivalentSpring("[{{[{[]}]}}]", springs);
        System.out.println(spring.getK());
    }
}
