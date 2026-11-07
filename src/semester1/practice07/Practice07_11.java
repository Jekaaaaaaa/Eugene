package semester1.practice07;

public class Practice07_11 {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2024);
        car.drive(150.0);
        car.startEngine();
        car.drive(150.0);
        car.stopEngine();
        car.printInfo();
    }

    static class Car {
        private String brand;
        private String model;
        private int year;
        private double mileage;
        private boolean engineStarted;

        public Car(String brand, String model, int year, double mileage) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.mileage = mileage;
        }

        public Car(String brand, String model, int year) {
            this(brand, model, year, 0.0);
        }

        public Car() {
            this("Unknown", "Standard", 2024);
        }

        public void startEngine() {
            engineStarted = true;
        }

        public void stopEngine() {
            engineStarted = false;
        }

        public void drive(double distance) {
            if (!engineStarted) {
                System.out.println("Спершу заведіть двигун!");
                return;
            }
            if (distance > 0.0 && Double.isFinite(distance)) {
                mileage += distance;
            }
        }

        public void printInfo() {
            System.out.println(brand + " " + model + ", " + year + ", пробіг: " + mileage + " км");
        }
    }
}
