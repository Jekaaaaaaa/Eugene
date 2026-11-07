package semester1.practice08;

public class Practice08_35 {
    public static void main(String[] args) {
        LinearFunction linear = new LinearFunction(-4.0, 3.0);
        QuadraticFunction quadratic = new QuadraticFunction(-4.0, 3.0, 2.0);
        System.out.println(linear + ", f(2) = " + linear.evaluate(2.0));
        System.out.println(quadratic + ", f(2) = " + quadratic.evaluate(2.0));
        System.out.println("Вершина при x = " + quadratic.getVertexX());
    }

    static class LinearFunction {
        protected double k;
        protected double b;

        public LinearFunction(double k, double b) {
            this.k = k;
            this.b = b;
        }

        public double evaluate(double x) {
            return k * x + b;
        }

        @Override
        public String toString() {
            return "f(x) = " + k + "x + " + b;
        }
    }

    static class QuadraticFunction extends LinearFunction {
        private double a;

        public QuadraticFunction(double k, double b, double a) {
            super(k, b);
            this.a = a;
        }

        @Override
        public double evaluate(double x) {
            return a * x * x + super.evaluate(x);
        }

        public double getVertexX() {
            return -k / (2.0 * a);
        }

        @Override
        public String toString() {
            return "f(x) = " + a + "x² + " + k + "x + " + b;
        }
    }
}
