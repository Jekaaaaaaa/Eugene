package semester1.practice09;

import semester1.practice09.Practice09_9.Point2D;

public class Practice09_12 {
    public static void main(String[] args) {
        LineSegment line = new LineSegment(new Point2D(1.0, 2.0), new Point2D(7.0, 10.0));
        System.out.println(line);
        System.out.println("Довжина: " + line.getLength() + ", середина: " + line.getMidpoint());
    }

    static class LineSegment {
        private final Point2D start;
        private final Point2D end;

        public LineSegment(Point2D start, Point2D end) {
            this.start = new Point2D(start.getX(), start.getY());
            this.end = new Point2D(end.getX(), end.getY());
        }

        public double getLength() {
            return start.distanceTo(end);
        }

        public Point2D getMidpoint() {
            return new Point2D(start.getX() / 2.0 + end.getX() / 2.0, start.getY() / 2.0 + end.getY() / 2.0);
        }

        @Override
        public String toString() {
            return start + " — " + end;
        }
    }
}
