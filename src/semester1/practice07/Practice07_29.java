package semester1.practice07;

public class Practice07_29 {
    public static void main(String[] args) {
        FleetCar first = new FleetCar("VIN001", 10000.0);
        FleetCar second = new FleetCar("VIN002", 8000.0);
        FleetCar third = new FleetCar("VIN003", 12000.0);
        first.addTrip(120.0);
        second.addTrip(80.0);
        third.addTrip(150.0);
        FleetCar.printFleetSummary();
    }

    static class FleetCar {
        private static int totalCars = 0;
        private static double totalCompanyMileage = 0.0;
        private String vinCode;
        private double currentMileage;

        public FleetCar(String vinCode, double initialMileage) {
            this.vinCode = vinCode;
            this.currentMileage = initialMileage;
            totalCars++;
            totalCompanyMileage += initialMileage;
        }

        public void addTrip(double km) {
            if (km > 0.0 && Double.isFinite(km)) {
                currentMileage += km;
                totalCompanyMileage += km;
            }
        }

        public static void printFleetSummary() {
            System.out.println("Автомобілів: " + totalCars + ", загальний пробіг: " + totalCompanyMileage + " км");
        }
    }
}
