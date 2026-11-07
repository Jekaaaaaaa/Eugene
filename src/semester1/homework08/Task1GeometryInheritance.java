package semester1.homework08;

import java.util.Locale;

public class Task1GeometryInheritance {
    public static void main(String[] args) {
        System.out.println("=== ГЕОМЕТРІЯ ТІЛ ОБЕРТАННЯ ===");
        System.out.println(new Circle(5.0));
        System.out.println(new Cylinder(5.0, 10.0));
        System.out.println(new Cone(3.0, 4.0));
    }

    static class Circle {
        private double radius;

        public Circle(double radius) {
            setRadius(radius);
        }

        public void setRadius(double radius) {
            if (!(radius > 0.0) || !Double.isFinite(radius)) {
                System.out.println("Некоректний радіус. Встановлено 1.0.");
                this.radius = 1.0;
                return;
            }
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2.0 * Math.PI * radius;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "Circle[r=%.2f, S=%.2f, C=%.2f]", radius, getArea(), getCircumference());
        }
    }

    static class Cylinder extends Circle {
        private double height;

        public Cylinder(double radius, double height) {
            super(radius);
            this.height = height > 0.0 && Double.isFinite(height) ? height : 1.0;
        }

        public double getVolume() {
            return super.getArea() * height;
        }

        public double getTotalSurfaceArea() {
            return 2.0 * super.getArea() + super.getCircumference() * height;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "Cylinder[base=%s, h=%.2f, V=%.2f, TotalArea=%.2f]",
                    super.toString(), height, getVolume(), getTotalSurfaceArea());
        }
    }

    static class Cone extends Circle {
        private double height;

        public Cone(double radius, double height) {
            super(radius);
            this.height = height > 0.0 && Double.isFinite(height) ? height : 1.0;
        }

        public double getSlantHeight() {
            return Math.hypot(getRadius(), height);
        }

        public double getVolume() {
            return super.getArea() * height / 3.0;
        }

        public double getTotalSurfaceArea() {
            return super.getArea() + super.getCircumference() * getSlantHeight() / 2.0;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "Cone[base=%s, h=%.2f, l=%.2f, V=%.2f, TotalArea=%.2f]",
                    super.toString(), height, getSlantHeight(), getVolume(), getTotalSurfaceArea());
        }
    }
}
