package semester1.practice09;

public class Practice09_10 {
    public static void main(String[] args) {
        Engine engine = new Engine("Бензин", 1600);
        Automobile car = new Automobile("Toyota", engine);
        car.accelerate(20.0);
        System.out.println(car);
        engine.start();
        car.accelerate(35.0);
        System.out.println(car);
        engine.stop();
    }

    static class Engine {
        private final String fuelType;
        private final int volumeCc;

        public Engine(String fuelType, int volumeCc) {
            this.fuelType = fuelType;
            this.volumeCc = volumeCc;
        }

        private int rpm;
        private boolean started;

        public void start() {
            if (!started) {
                started = true;
                rpm = 800;
            }
        }

        public void stop() {
            started = false;
            rpm = 0;
        }

        public void setRpm(int rpm) {
            if (started) {
                this.rpm = Math.max(800, rpm);
            }
        }

        public boolean isStarted() {
            return started;
        }

        public int getRpm() {
            return rpm;
        }

        @Override
        public String toString() {
            return fuelType + ", " + volumeCc + " см³, " + rpm + " об/хв";
        }
    }

    static class Automobile {
        private final String model;
        private final Engine engine;

        public Automobile(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        private double speed;

        public void accelerate(double deltaSpeed) {
            if (engine.isStarted() && deltaSpeed > 0.0 && Double.isFinite(deltaSpeed)) {
                speed += deltaSpeed;
                engine.setRpm((int) Math.min(Integer.MAX_VALUE, engine.getRpm() + 30.0 * deltaSpeed));
            }
        }

        @Override
        public String toString() {
            return model + ", " + speed + " км/год, двигун: " + engine;
        }
    }
}
