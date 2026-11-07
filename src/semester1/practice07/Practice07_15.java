package semester1.practice07;

public class Practice07_15 {
    public static void main(String[] args) {
        Box original = new Box(3.0, "Картон");
        Box copy = new Box(original);
        original.printBox();
        copy.printBox();
        System.out.println("Об'єми однакові: " + (original.getVolume() == copy.getVolume()));
    }

    static class Box {
        private double width;
        private double height;
        private double depth;
        private String material;

        public Box(double width, double height, double depth, String material) {
            this.width = width;
            this.height = height;
            this.depth = depth;
            this.material = material;
        }

        public Box(double size, String material) {
            this(size, size, size, material);
        }

        public Box(Box other) {
            this(other.width, other.height, other.depth, other.material);
        }

        public double getVolume() {
            return width * height * depth;
        }

        public double getSurfaceArea() {
            return 2.0 * (width * height + width * depth + height * depth);
        }

        public void printBox() {
            System.out.println(material + ", " + width + " × " + height + " × " + depth
                    + ", об'єм: " + getVolume() + ", площа поверхні: " + getSurfaceArea());
        }
    }
}
