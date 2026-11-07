package semester1.homework09;

import java.util.Locale;

public class Task1CompositeShapesCanvas {
    public static void main(String[] args) {
        Point2D center = new Point2D(0.0, 0.0);
        Circle2D circle = new Circle2D("Коло-А", center, 5.0);
        GeometryCanvas canvas = new GeometryCanvas("Інженерне креслення №1", 5);
        canvas.addShape(circle);
        canvas.addShape(new Rectangle2D("Плита-Б", new Point2D(10.0, 5.0), 4.0, 6.0));
        canvas.addShape(new RightTriangle2D("Клин-В", new Point2D(-3.0, 2.0), 3.0, 4.0));

        center.translate(100.0, 100.0);
        Point2D centerCopy = circle.getAnchorPoint();
        centerCopy.translate(-50.0, -50.0);
        System.out.println("Центр після зміни зовнішніх точок: " + circle.getAnchorPoint());
        System.out.println(canvas);
        System.out.printf(Locale.ROOT, "Найбільша фігура: %s (S = %.2f)%n",
                canvas.findLargestShape().getName(), canvas.findLargestShape().getArea());
        canvas.moveAllShapes(5.0, -2.0);
        System.out.println("Після зміщення на (5.0; -2.0):");
        System.out.println(canvas);
    }

    static class Point2D {
        private double x;
        private double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point2D(Point2D other) {
            this(other.x, other.y);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public void translate(double dx, double dy) {
            x += dx;
            y += dy;
        }

        public double distanceTo(Point2D other) {
            return Math.hypot(x - other.x, y - other.y);
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "(%.2f; %.2f)", x, y);
        }
    }

    static abstract class AbstractShape2D {
        private final String name;
        private final Point2D anchorPoint;

        public AbstractShape2D(String name, Point2D anchorPoint) {
            this.name = name;
            this.anchorPoint = anchorPoint == null ? new Point2D(0.0, 0.0) : new Point2D(anchorPoint);
        }

        public String getName() {
            return name;
        }

        public Point2D getAnchorPoint() {
            return new Point2D(anchorPoint);
        }

        public void moveBy(double dx, double dy) {
            anchorPoint.translate(dx, dy);
        }

        public abstract double getArea();

        public abstract double getPerimeter();

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "%s '%s', центр: %s | S=%.2f, P=%.2f",
                    getClass().getSimpleName(), name, anchorPoint, getArea(), getPerimeter());
        }
    }

    static class Circle2D extends AbstractShape2D {
        private double radius;

        public Circle2D(String name, Point2D anchorPoint, double radius) {
            super(name, anchorPoint);
            this.radius = positiveDimension(radius);
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2.0 * Math.PI * radius;
        }
    }

    static class Rectangle2D extends AbstractShape2D {
        private double width;
        private double height;

        public Rectangle2D(String name, Point2D anchorPoint, double width, double height) {
            super(name, anchorPoint);
            this.width = positiveDimension(width);
            this.height = positiveDimension(height);
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public double getPerimeter() {
            return 2.0 * (width + height);
        }
    }

    static class RightTriangle2D extends AbstractShape2D {
        private double legA;
        private double legB;

        public RightTriangle2D(String name, Point2D anchorPoint, double legA, double legB) {
            super(name, anchorPoint);
            this.legA = positiveDimension(legA);
            this.legB = positiveDimension(legB);
        }

        public double getHypotenuse() {
            return Math.hypot(legA, legB);
        }

        @Override
        public double getArea() {
            return 0.5 * legA * legB;
        }

        @Override
        public double getPerimeter() {
            return legA + legB + getHypotenuse();
        }
    }

    static class GeometryCanvas {
        private final String title;
        private final AbstractShape2D[] shapes;
        private int count;

        public GeometryCanvas(String title, int capacity) {
            this.title = title;
            this.shapes = new AbstractShape2D[capacity];
        }

        public boolean addShape(AbstractShape2D shape) {
            if (shape == null || count == shapes.length) {
                return false;
            }
            shapes[count++] = shape;
            return true;
        }

        public double getTotalArea() {
            double area = 0.0;
            for (int i = 0; i < count; i++) {
                area += shapes[i].getArea();
            }
            return area;
        }

        public double getTotalPerimeter() {
            double perimeter = 0.0;
            for (int i = 0; i < count; i++) {
                perimeter += shapes[i].getPerimeter();
            }
            return perimeter;
        }

        public AbstractShape2D findLargestShape() {
            AbstractShape2D largest = null;
            for (int i = 0; i < count; i++) {
                if (largest == null || shapes[i].getArea() > largest.getArea()) {
                    largest = shapes[i];
                }
            }
            return largest;
        }

        public void moveAllShapes(double dx, double dy) {
            for (int i = 0; i < count; i++) {
                shapes[i].moveBy(dx, dy);
            }
        }

        @Override
        public String toString() {
            StringBuilder report = new StringBuilder(String.format("Полотно: '%s' (фігур: %d/%d)",
                    title, count, shapes.length));
            for (int i = 0; i < count; i++) {
                report.append(String.format("%n%d. %s", i + 1, shapes[i]));
            }
            return report.append(String.format(Locale.ROOT, "%nСумарна площа: %.2f%nСумарний периметр: %.2f",
                    getTotalArea(), getTotalPerimeter())).toString();
        }
    }

    private static double positiveDimension(double value) {
        if (!(value > 0.0) || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Розмір фігури має бути додатним і скінченним");
        }
        return value;
    }
}
