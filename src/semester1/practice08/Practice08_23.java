package semester1.practice08;

public class Practice08_23 {
    public static void main(String[] args) {
        Point2D point = new Point2D(3.0, 4.0);
        Point3D spatialPoint = new Point3D(3.0, 4.0, 12.0);
        System.out.println(point + ", відстань: " + point.distanceToOrigin());
        System.out.println(spatialPoint + ", відстань: " + spatialPoint.distanceToOrigin());
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

        public double distanceToOrigin() {
            return Math.hypot(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + "; " + y + ")";
        }
    }

    static class Point3D extends Point2D {
        private double z;

        public Point3D(double x, double y, double z) {
            super(x, y);
            this.z = z;
        }

        @Override
        public double distanceToOrigin() {
            return Math.hypot(super.distanceToOrigin(), z);
        }

        @Override
        public String toString() {
            return "(" + getX() + "; " + getY() + "; " + z + ")";
        }
    }
}
