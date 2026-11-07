package semester1.practice07;

public class Practice07_19 {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();
        System.out.println("Квадрат: " + calculator.calculateArea(4.0));
        System.out.println("Прямокутник: " + calculator.calculateArea(4.0, 5.0));
        System.out.println("Круг: " + calculator.calculateArea(2.0, true));
        System.out.println("Трикутник: " + calculator.calculateArea(3.0, 4.0, 5.0));
        System.out.println("Трапеція: " + calculator.calculateArea(4.0, 6.0, 3.0, true));
    }

    static class AreaCalculator {
        public double calculateArea(double side) {
            return calculateArea(side, side);
        }

        public double calculateArea(double width, double height) {
            return width * height;
        }

        public double calculateArea(double radius, boolean isCircle) {
            return isCircle ? Math.PI * radius * radius : calculateArea(radius);
        }

        public double calculateArea(double a, double b, double c) {
            double halfPerimeter = (a + b + c) / 2.0;
            return Math.sqrt(halfPerimeter * (halfPerimeter - a)
                    * (halfPerimeter - b) * (halfPerimeter - c));
        }

        // Четвертий параметр розрізняє трапецію і трикутник.
        public double calculateArea(double a, double b, double c, boolean isTrapezoid) {
            if (isTrapezoid) {
                return (a + b) / 2.0 * c;
            }
            return calculateArea(a, b, c);
        }
    }
}
