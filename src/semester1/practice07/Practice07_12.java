package semester1.practice07;

public class Practice07_12 {
    public static void main(String[] args) {
        new SmartBulb().printStatus();
        new SmartBulb(75).printStatus();
        new SmartBulb(110, 2500, false).printStatus();
    }

    static class SmartBulb {
        private int brightness;
        private int colorTemp;
        private boolean isOn;

        public SmartBulb(int brightness, int colorTemp, boolean isOn) {
            this.brightness = Math.max(0, Math.min(100, brightness));
            this.colorTemp = Math.max(2700, Math.min(6500, colorTemp));
            this.isOn = isOn;
        }

        public SmartBulb(int brightness) {
            this(brightness, 4000, true);
        }

        public SmartBulb() {
            this(50);
        }

        public void printStatus() {
            String state = isOn ? "увімкнено" : "вимкнено";
            System.out.println(state + ", яскравість: " + brightness + "%, температура: " + colorTemp + " K");
        }
    }
}
