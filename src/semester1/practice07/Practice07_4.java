package semester1.practice07;

public class Practice07_4 {
    public static void main(String[] args) {
        Point2D a = new Point2D();
        Point2D b = new Point2D(3.0, 4.0);
        Point2D c = new Point2D(-2.0, 4.0);
        a.printPoint();
        b.printPoint();
        c.printPoint();
        System.out.println("Відстань від B до початку координат: " + b.distanceToOrigin());
        System.out.println("Відстань між A і B: " + a.distanceTo(b.x, b.y));
        System.out.println("Відстань між B і C: " + b.distanceTo(c.x, c.y));
    }

    static class Point2D {
        private double x;
        private double y;

        public Point2D() {
            this(0.0, 0.0);
        }

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceToOrigin() {
            return distanceTo(0.0, 0.0);
        }

        public double distanceTo(double targetX, double targetY) {
            return Math.hypot(targetX - x, targetY - y);
        }

        public void printPoint() {
            System.out.println("Point(" + x + "; " + y + ")");
        }
    }
}
