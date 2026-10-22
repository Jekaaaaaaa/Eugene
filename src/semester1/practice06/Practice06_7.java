package semester1.practice06;

import java.util.Locale;

public class Practice06_7 {
    public static void main(String[] args) {
        Point2D pointA = new Point2D();
        pointA.x = 0;
        pointA.y = 0;
        Point2D pointB = new Point2D();
        pointB.x = 3;
        pointB.y = 4;
        double distance = Math.sqrt(Math.pow(pointB.x - pointA.x, 2) + Math.pow(pointB.y - pointA.y, 2));
        System.out.println("Відстань: " + distance);
    }

    static class Point2D {
        public double x;
        public double y;
    }
}
