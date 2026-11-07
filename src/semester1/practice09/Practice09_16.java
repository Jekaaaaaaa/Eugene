package semester1.practice09;

public class Practice09_16 {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor(20.0);
        HeatingUnit heating = new HeatingUnit(1.5);
        ClimateController controller = new ClimateController(sensor, heating, 22.0);
        controller.regulate();
        System.out.println(controller);
        sensor.setCurrentTemp(22.0);
        controller.regulate();
        System.out.println(controller);
    }

    static class TemperatureSensor {
        private double currentTemp;

        public TemperatureSensor(double currentTemp) {
            this.currentTemp = currentTemp;
        }

        public double getCurrentTemp() {
            return currentTemp;
        }

        public void setCurrentTemp(double currentTemp) {
            this.currentTemp = currentTemp;
        }
    }

    static class HeatingUnit {
        private double powerKw;

        public HeatingUnit(double powerKw) {
            this.powerKw = powerKw;
        }

        private boolean heatingOn;

        public void setHeatingOn(boolean heatingOn) {
            this.heatingOn = heatingOn;
        }

        @Override
        public String toString() {
            return powerKw + " кВт, " + (heatingOn ? "працює" : "вимкнено");
        }
    }

    static class ClimateController {
        private final TemperatureSensor sensor;
        private final HeatingUnit heatingUnit;
        private double targetTemp;

        public ClimateController(TemperatureSensor sensor, HeatingUnit heatingUnit, double targetTemp) {
            this.sensor = sensor;
            this.heatingUnit = heatingUnit;
            this.targetTemp = targetTemp;
        }

        public void regulate() {
            double currentTemp = sensor.getCurrentTemp();
            if (currentTemp < targetTemp - 0.5) {
                heatingUnit.setHeatingOn(true);
            } else if (currentTemp >= targetTemp) {
                heatingUnit.setHeatingOn(false);
            }
        }

        @Override
        public String toString() {
            return "Зараз " + sensor.getCurrentTemp() + " °C, ціль " + targetTemp + " °C, обігрівач: " + heatingUnit;
        }
    }
}
