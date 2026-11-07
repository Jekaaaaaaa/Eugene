package semester1.practice08;

public class Practice08_12 {
    public static void main(String[] args) {
        System.out.println(new Rectangle(3.0, 4.0));
        System.out.println(new Box3D(3.0, 4.0, 5.0));
    }

    static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public double getArea() {
            return width * height;
        }

        @Override
        public String toString() {
            return getWidth() + " × " + getHeight() + ", площа основи: " + getArea();
        }
    }

    static class Box3D extends Rectangle {
        private double depth;

        public Box3D(double width, double height, double depth) {
            super(width, height);
            this.depth = depth;
        }

        public double getVolume() {
            return super.getArea() * depth;
        }

        @Override
        public String toString() {
            return super.toString() + ", глибина: " + depth + ", об'єм: " + getVolume();
        }
    }
}
