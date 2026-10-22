package semester1.practice06;

import java.util.Locale;

public class Practice06_24 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.a = 3;
        triangle.b = 4;
        triangle.c = 5;
        System.out.println("Валідний: " + triangle.isValid() + "; периметр: " + triangle.getPerimeter()
                + "; площа: " + triangle.getArea());
    }

    static class Triangle {
        public double a;
        public double b;
        public double c;
    
        public boolean isValid() {
            return Double.isFinite(a) && Double.isFinite(b) && Double.isFinite(c)
                    && a > 0 && b > 0 && c > 0
                    && a + b > c && a + c > b && b + c > a;
        }
    
        public double getPerimeter() {
            return a + b + c;
        }
    
        public double getArea() {
            if (!isValid()) {
                return 0.0;
            }
            double p = getPerimeter() / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }
}
