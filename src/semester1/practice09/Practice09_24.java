package semester1.practice09;

public class Practice09_24 {
    public static void main(String[] args) {
        EquationSystem system = new EquationSystem(2);
        system.addEquation(new LinearEquation(1.0, 1.0, 5.0));
        system.addEquation(new LinearEquation(2.0, -1.0, 1.0));
        System.out.println("(2; 3) є розв'язком: " + system.checkSolution(2.0, 3.0));
        System.out.println("(1; 4) є розв'язком: " + system.checkSolution(1.0, 4.0));
    }

    static class LinearEquation {
        private final double a;
        private final double b;
        private final double c;

        public LinearEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public boolean isSatisfiedBy(double x, double y) {
            return Math.abs(a * x + b * y - c) <= 1e-6;
        }
    }

    static class EquationSystem {
        private final LinearEquation[] equations;
        private int count;

        public EquationSystem(int capacity) {
            this.equations = new LinearEquation[capacity];
        }

        public void addEquation(LinearEquation equation) {
            if (equation != null && count < equations.length) {
                equations[count++] = equation;
            }
        }

        public boolean checkSolution(double x, double y) {
            for (int i = 0; i < count; i++) {
                if (!equations[i].isSatisfiedBy(x, y)) {
                    return false;
                }
            }
            return true;
        }
    }
}
