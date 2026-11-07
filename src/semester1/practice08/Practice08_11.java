package semester1.practice08;

public class Practice08_11 {
    public static void main(String[] args) {
        PassengerCar car = new PassengerCar("Toyota", 200, 55.0, 5);
        CargoTruck truck = new CargoTruck("MAN", 100, 400.0, 18.0);
        System.out.println(car);
        System.out.println(truck);
        System.out.println("Витрата з вантажем: " + truck.getFullLoadFuelConsumption(24.0) + " л/100 км");
    }

    static class Vehicle {
        protected String brand;
        protected int maxSpeed;
        protected double fuelTankCapacity;

        public Vehicle(String brand, int maxSpeed, double fuelTankCapacity) {
            this.brand = brand;
            this.maxSpeed = maxSpeed;
            this.fuelTankCapacity = fuelTankCapacity;
        }

        @Override
        public String toString() {
            return brand + ", швидкість: " + maxSpeed + " км/год, бак: " + fuelTankCapacity + " л";
        }
    }

    static class PassengerCar extends Vehicle {
        private int passengerSeats;

        public PassengerCar(String brand, int maxSpeed, double fuelTankCapacity, int passengerSeats) {
            super(brand, maxSpeed, fuelTankCapacity);
            this.passengerSeats = passengerSeats;
        }

        @Override
        public String toString() {
            return super.toString() + ", місць: " + passengerSeats;
        }
    }

    static class CargoTruck extends Vehicle {
        private double maxLoadTons;

        public CargoTruck(String brand, int maxSpeed, double fuelTankCapacity, double maxLoadTons) {
            super(brand, maxSpeed, fuelTankCapacity);
            this.maxLoadTons = maxLoadTons;
        }

        // У цій моделі тонна вантажу додає 0.5 л на 100 км.
        public double getFullLoadFuelConsumption(double emptyConsumption) {
            return emptyConsumption + 0.5 * maxLoadTons;
        }

        @Override
        public String toString() {
            return super.toString() + ", вантажопідйомність: " + maxLoadTons + " т";
        }
    }
}
