public class Spring {
    private double k;

    public Spring() {
        k = 1;
    }

    public Spring(double k) {
        this.k = k;
    }

    public double getK() {
        return k;
    }

    private void setK(double k){
        this.k = k;
    }

    public double[] move(double t, double dt, double x0, double v0){

    }
    public double[] move(double t, double dt, double x0){

    }
    public double[] move(double t0, double t1, double dt, double x0, double v0){

    }
    public double[] move(double t0, double t1, double dt, double x0, double v0, double m){

    }

    public Spring inSeries(Spring that){

    }
    public Spring inParallel(Spring that){

    }


}
