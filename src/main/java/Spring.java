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
        int i = 0;
        double A = v0;
        double B = x0;
        double omega = Math.sqrt(k);
        double coor[] = new double[(int)t / (int)dt];
        for(double tx = 0; tx < t; tx+= dt){
            coor[i++] = A * Math.sin(omega*tx) + B * Math.cos(omega*tx);
        }
        return coor;
    }
    public double[] move(double t, double dt, double x0){
        int k = 0;
        double B = x0;
        double omega = Math.sqrt(k);
        double coor[] = new double[(int)t / (int)dt];
        for(double tx = 0; tx <= t; tx+= dt){
            coor[k++] = B * Math.cos(omega*tx);
        }
        return coor;

    }
    public double[] move(double t0, double t1, double dt, double x0, double v0){
        int k = 0;
        double omega = Math.sqrt(k);
        double a = Math.sin(t0*omega);
        double b = Math.cos(t0*omega);
        double c = x0;
        double d = omega*Math.cos(t0*omega);
        double e = -omega*Math.sin(t0*omega);
        double f = v0;
        double coef[] = solveEquation(a, b, c, d, e, f);
        double A = coef[0];
        double B = coef[1];
        double coor[] = new double[(int)t1- (int)t0 / (int)dt];
        for(double tx = t0; tx <= t1; tx+= dt){
            coor[k++] = A * Math.sin(omega*tx) + B * Math.cos(omega*tx);
        }
        return coor;
    }
    public double[] move(double t0, double t1, double dt, double x0, double v0, double m){
        int k = 0;
        double omega = Math.sqrt(k/m);
        double a = Math.sin(t0*omega);
        double b = Math.cos(t0*omega);
        double c = x0;
        double d = omega*Math.cos(t0*omega);
        double e = -omega*Math.sin(t0*omega);
        double f = v0;
        double coef[] = solveEquation(a, b, c, d, e, f);
        double A = coef[0];
        double B = coef[1];
        double coor[] = new double[(int)t1- (int)t0 / (int)dt];
        for(double tx = t0; tx <= t1; tx+= dt){
            coor[k++] = A * Math.sin(omega*tx) + B * Math.cos(omega*tx);
        }
        return coor;
    }

    public Spring inSeries(Spring that){
        return new Spring((this.k * that.k) / (this.k + that.k));
    }
    public Spring inParallel(Spring that){
        return new Spring(this.k + that.k);
    }

    private double[] solveEquation(double a, double b, double c, double d, double e, double f){
        double det = a*d - b*c;
        double x = (d*e - b*f)/det;
        double y = (a*f - c*e)/det;
        double ans[] = new double[2];
        ans[0] = x;
        ans[1] = y;
        return ans;
    }


}
