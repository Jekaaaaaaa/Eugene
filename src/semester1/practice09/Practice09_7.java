package semester1.practice09;

public class Practice09_7 {
    public static void main(String[] args) {
        double[] coeffs = {-3.0, 2.0, -1.0, 0.0};
        EncapsulatedPolynomial polynomial = new EncapsulatedPolynomial(coeffs);
        coeffs[0] = 100.0;
        System.out.println(polynomial);
        System.out.println("Степінь: " + polynomial.getDegree() + ", P(2) = " + polynomial.evaluate(2.0));
    }

    static class EncapsulatedPolynomial {
        private final double[] coeffs;

        public EncapsulatedPolynomial(double[] coeffs) {
            this.coeffs = coeffs.clone();
        }

        public int getDegree() {
            int degree = coeffs.length - 1;
            while (degree > 0 && coeffs[degree] == 0.0) {
                degree--;
            }
            return Math.max(0, degree);
        }

        public double getCoefficient(int power) {
            return power >= 0 && power < coeffs.length ? coeffs[power] : 0.0;
        }

        public double evaluate(double x) {
            double value = 0.0;
            for (int i = coeffs.length - 1; i >= 0; i--) {
                value = value * x + coeffs[i];
            }
            return value;
        }

        @Override
        public String toString() {
            StringBuilder polynomial = new StringBuilder();
            for (int i = getDegree(); i >= 0; i--) {
                double coefficient = getCoefficient(i);
                if (coefficient == 0.0) {
                    continue;
                }
                if (polynomial.length() > 0) {
                    polynomial.append(coefficient < 0.0 ? " - " : " + ");
                } else if (coefficient < 0.0) {
                    polynomial.append('-');
                }
                polynomial.append(Math.abs(coefficient));
                if (i > 0) {
                    polynomial.append('x');
                }
                if (i > 1) {
                    polynomial.append('^').append(i);
                }
            }
            return "P(x) = " + (polynomial.length() == 0 ? "0" : polynomial.toString());
        }
    }
}
