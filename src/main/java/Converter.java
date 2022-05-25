public class Converter {
    private Spring crateSpringSystem(String bits){
        if(bits.length() != 8){
            throw new RuntimeException("Invalid Args");
        }
        Spring spring = new Spring();
        for(int i = 0; i < 8; i++){
            if(bits.charAt(i) == '1'){
                spring = spring.inSeries(new Spring());
            }
            else if(bits.charAt(i) == '0'){
                spring = spring.inParallel(new Spring());
            }
            else throw new RuntimeException("Invalid Args");
        }
        return spring;
    }

    private double[] computeOscillations(Spring spring){
        return spring.move(8, 1, 1, 1);
    }

    private FFT.Complex[] computeFFT(double[] osc){
        FFT.Complex complex[] = new FFT.Complex[8];
        for(int i = 0; i < 8; i++){
            complex[i] = new FFT.Complex(osc[i], 0);
        }
        return FFT.Complex.fft(complex);
    }

    private int computeDecimal(FFT.Complex[] fft){
        double t[] = new double[8];
        for(int i = 0; i < fft.length; i++){
            t[i] = Math.sqrt(Math.pow(fft[i].re(), 2) + Math.pow(fft[i].im(), 2));
        }
        return 0;
    }

    public int compute(String bits){
        Spring spring = crateSpringSystem(bits);
        double osc[] = computeOscillations(spring);
        FFT.Complex complex[] = computeFFT(osc);
        return computeDecimal(complex);
    }

}
