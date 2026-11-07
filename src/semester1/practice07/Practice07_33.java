package semester1.practice07;

public class Practice07_33 {
    public static void main(String[] args) {
        Point start = new Point(0.0, 0.0);
        Point end = new Point(6.0, 8.0);
        LineSegment segment = new LineSegment(start, end);
        segment.printSegment();
        System.out.println("Довжина: " + segment.getLength());
        Point middle = segment.getMidPoint();
        System.out.println("Середина: (" + middle.getX() + "; " + middle.getY() + ")");
    }

    static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

    static class LineSegment {
        private Point start;
        private Point end;

        public LineSegment(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public LineSegment(double x1, double y1, double x2, double y2) {
            this(new Point(x1, y1), new Point(x2, y2));
        }

        public double getLength() {
            return Math.hypot(end.getX() - start.getX(), end.getY() - start.getY());
        }

        public Point getMidPoint() {
            return new Point((start.getX() + end.getX()) / 2.0, (start.getY() + end.getY()) / 2.0);
        }

        public void printSegment() {
            System.out.println("Відрізок: (" + start.getX() + "; " + start.getY() + ") — ("
                    + end.getX() + "; " + end.getY() + ")");
        }
    }
}
