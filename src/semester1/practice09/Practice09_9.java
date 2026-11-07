package semester1.practice09;

public class Practice09_9 {
    public static void main(String[] args) {
        CompositeCircle circle = new CompositeCircle(2.0, 1.0, 5.0);
        System.out.println(circle);
        System.out.println("Точка всередині: " + circle.containsPoint(new Point2D(5.0, 5.0)));
        System.out.println("Точка поза колом: " + !circle.containsPoint(new Point2D(8.0, 1.0)));
    }

    static class Point2D {
        private double x;
        private double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double distanceTo(Point2D other) {
            return Math.hypot(x - other.x, y - other.y);
        }

        @Override
        public String toString() {
            return "(" + x + "; " + y + ")";
        }
    }

    static class CompositeCircle {
        private double radius;
        private final Point2D center;

        public CompositeCircle(double centerX, double centerY, double radius) {
            this.radius = radius;
            this.center = new Point2D(centerX, centerY);
        }

        public boolean containsPoint(Point2D p) {
            return center.distanceTo(p) <= radius;
        }

        @Override
        public String toString() {
            return "Центр: " + center + ", радіус: " + radius;
        }
    }
}
