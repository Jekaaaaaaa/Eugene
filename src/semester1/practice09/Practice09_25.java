package semester1.practice09;

public class Practice09_25 {
    public static void main(String[] args) {
        AbstractShape circle = new CircleShape("Синій", 3.0);
        AbstractShape rectangle = new RectangleShape("Зелений", 4.0, 5.0);
        System.out.println(circle);
        System.out.println(rectangle);
    }

    static abstract class AbstractShape {
        private String color;

        public AbstractShape(String color) {
            this.color = color;
        }

        public abstract double getArea();

        public abstract double getPerimeter();

        @Override
        public String toString() {
            return color + ", площа: " + getArea() + ", периметр: " + getPerimeter();
        }
    }

    static class CircleShape extends AbstractShape {
        private double radius;

        public CircleShape(String color, double radius) {
            super(color);
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2.0 * Math.PI * radius;
        }
    }

    static class RectangleShape extends AbstractShape {
        private double width;
        private double height;

        public RectangleShape(String color, double width, double height) {
            super(color);
            this.width = width;
            this.height = height;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public double getPerimeter() {
            return 2.0 * (width + height);
        }
    }
}
