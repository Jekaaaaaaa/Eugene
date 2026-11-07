package semester1.practice08;

public class Practice08_30 {
    public static void main(String[] args) {
        System.out.println(new Segment1D(3.0));
        System.out.println(new Square2D(3.0));
        System.out.println(new Cube3D(3.0));
    }

    static class Segment1D {
        protected double length;

        public Segment1D(double length) {
            this.length = length;
        }

        @Override
        public String toString() {
            return "Відрізок, довжина: " + length;
        }
    }

    static class Square2D extends Segment1D {
        public Square2D(double side) {
            super(side);
        }

        public double getPerimeter() {
            return 4.0 * length;
        }

        public double getArea() {
            return length * length;
        }

        @Override
        public String toString() {
            return "Квадрат, сторона: " + length + ", периметр: " + getPerimeter() + ", площа: " + getArea();
        }
    }

    static class Cube3D extends Square2D {
        public Cube3D(double side) {
            super(side);
        }

        @Override
        public double getArea() {
            return 6.0 * super.getArea();
        }

        public double getVolume() {
            return length * super.getArea();
        }

        @Override
        public String toString() {
            return "Куб, ребро: " + length + ", площа поверхні: " + getArea() + ", об'єм: " + getVolume();
        }
    }
}
