package semester1.practice07;

public class Practice07_32 {
    public static void main(String[] args) {
        System.out.printf("Енергія спокою 1 г: %.3e Дж%n", PhysicsEngine.restEnergy(0.001));
        System.out.printf("Відстань падіння за 5 с: %.2f м%n", PhysicsEngine.freeFallDistance(5.0));
        System.out.println("Кінетична енергія: " + PhysicsEngine.kineticEnergy(2.0, 10.0) + " Дж");
    }

    static class PhysicsEngine {
        public static final double G = 9.80665;
        public static final double SPEED_OF_LIGHT = 299792458.0;

        private PhysicsEngine() {
        }

        public static double freeFallDistance(double seconds) {
            return G * seconds * seconds / 2.0;
        }

        public static double kineticEnergy(double massKg, double velocityMs) {
            return massKg * velocityMs * velocityMs / 2.0;
        }

        public static double restEnergy(double massKg) {
            return massKg * SPEED_OF_LIGHT * SPEED_OF_LIGHT;
        }
    }
}
