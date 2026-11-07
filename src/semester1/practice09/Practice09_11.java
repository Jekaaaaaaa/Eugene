package semester1.practice09;

public class Practice09_11 {
    public static void main(String[] args) {
        SmartDevice device = new SmartDevice(new Battery(5000, 7), new Display(6.5, 85));
        device.watchVideo(20);
        System.out.println(device);
        device.watchVideo(20);
        System.out.println(device);
    }

    static class Battery {
        private int capacityMah;
        private int chargePercent;

        public Battery(int capacityMah, int chargePercent) {
            this.capacityMah = capacityMah;
            this.chargePercent = Math.max(0, Math.min(100, chargePercent));
        }

        public void drain(int percent) {
            if (percent > 0) {
                chargePercent = Math.max(0, chargePercent - percent);
            }
        }

        public void charge(int percent) {
            if (percent > 0) {
                chargePercent += Math.min(percent, 100 - chargePercent);
            }
        }

        public int getChargePercent() {
            return chargePercent;
        }

        @Override
        public String toString() {
            return capacityMah + " мА·год, заряд " + chargePercent + "%";
        }
    }

    static class Display {
        private double diagonalInches;
        private int brightnessPercent;

        public Display(double diagonalInches, int brightnessPercent) {
            this.diagonalInches = diagonalInches;
            this.brightnessPercent = Math.max(10, Math.min(100, brightnessPercent));
        }

        public int getBrightnessPercent() {
            return brightnessPercent;
        }

        @Override
        public String toString() {
            return diagonalInches + "″, яскравість " + brightnessPercent + "%";
        }
    }

    static class SmartDevice {
        private final Battery battery;
        private final Display display;

        public SmartDevice(Battery battery, Display display) {
            this.battery = battery;
            this.display = display;
        }

        private int remainingVideoMinutes;

        public void watchVideo(int minutes) {
            if (minutes <= 0 || battery.getChargePercent() == 0) {
                return;
            }
            long totalMinutes = (long) remainingVideoMinutes + minutes;
            int rate = display.getBrightnessPercent() > 70 ? 2 : 1;
            int before = battery.getChargePercent();
            battery.drain((int) (totalMinutes / 10) * rate);
            remainingVideoMinutes = battery.getChargePercent() == 0 ? 0 : (int) (totalMinutes % 10);
            if (before > 0 && battery.getChargePercent() == 0) {
                System.out.println("Батарея розряджена. Пристрій вимкнувся.");
            }
        }

        @Override
        public String toString() {
            return (battery.getChargePercent() > 0 ? "Увімкнено" : "Вимкнено") + ", " + battery + ", " + display;
        }
    }
}
