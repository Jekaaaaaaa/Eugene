package semester1.practice08;

public class Practice08_26 {
    public static void main(String[] args) {
        System.out.println(new ElectricCar("Hyundai", 2025, 229, 5, 77.4, 500));
    }

    static class BaseVehicle {
        private String brand;
        private int year;

        public BaseVehicle(String brand, int year) {
            this.brand = brand;
            this.year = year;
        }

        @Override
        public String toString() {
            return brand + ", рік: " + year;
        }
    }

    static class MotorCar extends BaseVehicle {
        private int horsePower;
        private int doorsCount;

        public MotorCar(String brand, int year, int horsePower, int doorsCount) {
            super(brand, year);
            this.horsePower = horsePower;
            this.doorsCount = doorsCount;
        }

        @Override
        public String toString() {
            return super.toString() + ", " + horsePower + " к.с., дверей: " + doorsCount;
        }
    }

    static class ElectricCar extends MotorCar {
        private double batteryCapacityKWh;
        private int rangeKm;

        public ElectricCar(String brand, int year, int horsePower, int doorsCount, double batteryCapacityKWh, int rangeKm) {
            super(brand, year, horsePower, doorsCount);
            this.batteryCapacityKWh = batteryCapacityKWh;
            this.rangeKm = rangeKm;
        }

        @Override
        public String toString() {
            return super.toString() + ", батарея: " + batteryCapacityKWh + " кВт·год, запас ходу: " + rangeKm + " км";
        }
    }
}
