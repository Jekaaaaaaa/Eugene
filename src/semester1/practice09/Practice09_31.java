package semester1.practice09;

public class Practice09_31 {
    public static void main(String[] args) {
        AbstractSensor pressure = new PressureSensor("Резервуар", 1.0, 5.0, 4.0, 1.1);
        AbstractSensor radiation = new RadiationSensor("Лабораторія", 0.0, 0.3, 0.7);
        System.out.println(pressure + ", тривога: " + pressure.isAlarmTriggered());
        System.out.println(radiation + ", тривога: " + radiation.isAlarmTriggered());
    }

    static abstract class AbstractSensor {
        private final String location;
        private final double minSafe;
        private final double maxSafe;

        public AbstractSensor(String location, double minSafe, double maxSafe) {
            this.location = location;
            this.minSafe = minSafe;
            this.maxSafe = maxSafe;
        }

        public abstract double readValue();

        public abstract String getUnit();

        public final boolean isAlarmTriggered() {
            double value = readValue();
            return !(value >= minSafe && value <= maxSafe);
        }

        @Override
        public String toString() {
            return location + ": " + readValue() + " " + getUnit();
        }
    }

    static class PressureSensor extends AbstractSensor {
        private double rawPressure;
        private double calibrationFactor;

        public PressureSensor(String location, double minSafe, double maxSafe, double rawPressure, double calibrationFactor) {
            super(location, minSafe, maxSafe);
            this.rawPressure = rawPressure;
            this.calibrationFactor = calibrationFactor;
        }

        @Override
        public double readValue() {
            return rawPressure * calibrationFactor;
        }

        @Override
        public String getUnit() {
            return "бар";
        }
    }

    static class RadiationSensor extends AbstractSensor {
        private double radiation;

        public RadiationSensor(String location, double minSafe, double maxSafe, double radiation) {
            super(location, minSafe, maxSafe);
            this.radiation = radiation;
        }

        @Override
        public double readValue() {
            return radiation;
        }

        @Override
        public String getUnit() {
            return "мкЗв/год";
        }
    }
}
