package semester1.practice09;

public class Practice09_5 {
    public static void main(String[] args) {
        RgbColor color = new RgbColor(300, 120, -10);
        System.out.println(color);
        System.out.println("Інверсія: " + color.invert());
        System.out.println("Суміш із синім: " + color.mixWith(new RgbColor(0, 0, 255)));
    }

    static final class RgbColor {
        private final int red;
        private final int green;
        private final int blue;

        public RgbColor(int red, int green, int blue) {
            this.red = clamp(red);
            this.green = clamp(green);
            this.blue = clamp(blue);
        }

        private static int clamp(int val) {
            return Math.max(0, Math.min(255, val));
        }

        public String toHex() {
            return String.format("#%02X%02X%02X", red, green, blue);
        }

        public RgbColor invert() {
            return new RgbColor(255 - red, 255 - green, 255 - blue);
        }

        public RgbColor mixWith(RgbColor other) {
            return new RgbColor((red + other.red) / 2, (green + other.green) / 2, (blue + other.blue) / 2);
        }

        @Override
        public String toString() {
            return "RGB(" + red + ", " + green + ", " + blue + ") " + toHex();
        }
    }
}
