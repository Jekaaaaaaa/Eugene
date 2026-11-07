package semester1.practice08;

import java.util.Arrays;

public class Practice08_33 {
    public static void main(String[] args) {
        System.out.println(new ArithmeticProgression(2.0, 3.0));
        System.out.println(new GeometricProgression(2.0, 3.0));
    }

    static abstract class Progression {
        protected double firstTerm;
        protected double step;

        public Progression(double firstTerm, double step) {
            this.firstTerm = firstTerm;
            this.step = step;
        }

        public abstract double getTerm(int index);

        public double[] generateFirstN(int n) {
            double[] terms = new double[n];
            for (int i = 0; i < n; i++) {
                terms[i] = getTerm(i + 1);
            }
            return terms;
        }
    }

    static class ArithmeticProgression extends Progression {
        public ArithmeticProgression(double firstTerm, double step) {
            super(firstTerm, step);
        }

        @Override
        public double getTerm(int n) {
            return firstTerm + (n - 1) * step;
        }

        @Override
        public String toString() {
            return "a(n) = " + firstTerm + " + (n - 1) × " + step + ": " + Arrays.toString(generateFirstN(5));
        }
    }

    static class GeometricProgression extends Progression {
        public GeometricProgression(double firstTerm, double step) {
            super(firstTerm, step);
        }

        @Override
        public double getTerm(int n) {
            return firstTerm * Math.pow(step, n - 1);
        }

        @Override
        public String toString() {
            return "b(n) = " + firstTerm + " × " + step + "^(n - 1): " + Arrays.toString(generateFirstN(5));
        }
    }
}
