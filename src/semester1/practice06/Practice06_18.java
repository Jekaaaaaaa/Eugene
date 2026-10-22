package semester1.practice06;

import java.util.Locale;

public class Practice06_18 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.radius = 5.0;
        System.out.println("Площа: " + circle.getArea() + "; довжина: " + circle.getCircumference());
    }

    static class Circle {
        public double radius;
    
        public double getArea() {
            return Math.PI * radius * radius;
        }
    
        public double getCircumference() {
            return 2 * Math.PI * radius;
        }
    }
}
