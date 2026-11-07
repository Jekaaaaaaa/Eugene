package semester1.practice09;

public class Practice09_26 {
    public static void main(String[] args) {
        AbstractPowerPlant solar = new SolarPowerPlant("Сонячна", 10.0, 0.6);
        AbstractPowerPlant wind = new WindPowerPlant("Вітрова", 12.0, 14.0);
        AbstractPowerPlant stopped = new WindPowerPlant("Шторм", 12.0, 26.0);
        System.out.println(solar + ", добовий дохід: " + solar.calculateDailyProfit(1500.0));
        System.out.println(wind + ", добовий дохід: " + wind.calculateDailyProfit(1500.0));
        System.out.println(stopped);
    }

    static abstract class AbstractPowerPlant {
        private final String stationName;
        protected double baseCapacityMw;

        public AbstractPowerPlant(String stationName, double baseCapacityMw) {
            this.stationName = stationName;
            this.baseCapacityMw = baseCapacityMw;
        }

        public abstract double generateMegawatts();

        public double calculateDailyProfit(double tariffPerMwh) {
            return generateMegawatts() * 24.0 * tariffPerMwh;
        }

        @Override
        public String toString() {
            return stationName + ": " + generateMegawatts() + " МВт";
        }
    }

    static class SolarPowerPlant extends AbstractPowerPlant {
        private double sunIntensityFactor;

        public SolarPowerPlant(String stationName, double baseCapacityMw, double sunIntensityFactor) {
            super(stationName, baseCapacityMw);
            this.sunIntensityFactor = Math.max(0.0, Math.min(1.0, sunIntensityFactor));
        }

        @Override
        public double generateMegawatts() {
            return baseCapacityMw * sunIntensityFactor;
        }
    }

    static class WindPowerPlant extends AbstractPowerPlant {
        private double windSpeedMs;

        public WindPowerPlant(String stationName, double baseCapacityMw, double windSpeedMs) {
            super(stationName, baseCapacityMw);
            this.windSpeedMs = windSpeedMs;
        }

        @Override
        public double generateMegawatts() {
            if (windSpeedMs < 3.0 || windSpeedMs > 25.0) {
                return 0.0;
            }
            // У робочому діапазоні потужність зростає до номіналу при 12 м/с.
            return baseCapacityMw * Math.min(1.0, windSpeedMs / 12.0);
        }
    }
}
