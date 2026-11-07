package semester1.practice07;

public class Practice07_7 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        Rectangle square = new Rectangle(4.0);
        System.out.println("Прямокутник: площа " + rectangle.getArea() + ", периметр " + rectangle.getPerimeter());
        System.out.println("Квадрат: площа " + square.getArea() + ", периметр " + square.getPerimeter());
        System.out.println("Одинична фігура є квадратом: " + new Rectangle().isSquare());
    }

    static class Rectangle {
        private double width;
        private double height;

        public Rectangle() {
            this(1.0);
        }

        public Rectangle(double size) {
            this(size, size);
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return width * height;
        }

        public double getPerimeter() {
            return 2.0 * (width + height);
        }

        public boolean isSquare() {
            return width == height;
        }
    }
}
