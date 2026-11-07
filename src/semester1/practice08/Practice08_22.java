package semester1.practice08;

public class Practice08_22 {
    public static void main(String[] args) {
        EcoHeater heater = new EcoHeater("Тепло-1500", 1500.0, true);
        System.out.println(heater);
        System.out.println("Споживання за 4 години: " + heater.getDailyConsumptionKWh(4) + " кВт·год");
    }

    static class Appliance {
        private String model;
        private double powerWatts;

        public Appliance(String model, double powerWatts) {
            this.model = model;
            this.powerWatts = powerWatts;
        }

        public double getDailyConsumptionKWh(int hours) {
            return powerWatts * hours / 1000.0;
        }

        @Override
        public String toString() {
            return model + ", потужність: " + powerWatts + " Вт";
        }
    }

    static class EcoHeater extends Appliance {
        private boolean ecoModeActive;

        public EcoHeater(String model, double powerWatts, boolean ecoModeActive) {
            super(model, powerWatts);
            this.ecoModeActive = ecoModeActive;
        }

        @Override
        public double getDailyConsumptionKWh(int hours) {
            double consumption = super.getDailyConsumptionKWh(hours);
            return ecoModeActive ? consumption * 0.75 : consumption;
        }

        @Override
        public String toString() {
            return super.toString() + ", економія: " + (ecoModeActive ? "увімкнена" : "вимкнена");
        }
    }
}
