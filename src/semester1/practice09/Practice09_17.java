package semester1.practice09;

import semester1.practice09.Practice09_9.Point2D;

public class Practice09_17 {
    public static void main(String[] args) {
        Polyline line = new Polyline(3);
        line.addVertex(0.0, 0.0);
        line.addVertex(3.0, 0.0);
        line.addVertex(3.0, 4.0);
        System.out.println("Ламана: " + line.getTotalLength());
        System.out.println("Замкнений периметр: " + line.getClosedPerimeter());
    }

    static class Polyline {
        private final Point2D[] vertices;
        private int count;

        public Polyline(int capacity) {
            this.vertices = new Point2D[capacity];
        }

        public void addVertex(double x, double y) {
            if (count < vertices.length) {
                vertices[count++] = new Point2D(x, y);
            }
        }

        public double getTotalLength() {
            double length = 0.0;
            for (int i = 1; i < count; i++) {
                length += vertices[i - 1].distanceTo(vertices[i]);
            }
            return length;
        }

        public double getClosedPerimeter() {
            return count < 2 ? 0.0 : getTotalLength() + vertices[count - 1].distanceTo(vertices[0]);
        }
    }
}
