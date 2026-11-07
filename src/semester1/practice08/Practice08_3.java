package semester1.practice08;

public class Practice08_3 {
    public static void main(String[] args) {
        Circle circle = new Circle(-3.0);
        System.out.println(circle);
        circle.setRadius(4.0);
        System.out.println(circle);
        circle.setRadius(-2.0);
        System.out.println(circle);
    }

    static class Circle {
        private double radius;

        public Circle(double radius) {
            setRadius(radius);
        }

        public void setRadius(double radius) {
            this.radius = radius > 0.0 && Double.isFinite(radius) ? radius : 1.0;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2.0 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return "Радіус: " + radius + ", площа: " + getArea() + ", довжина кола: " + getCircumference();
        }
    }
}
