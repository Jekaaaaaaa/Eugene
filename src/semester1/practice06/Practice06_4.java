package semester1.practice06;

import java.util.Locale;

public class Practice06_4 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.width = 7.5;
        rectangle.height = 4.0;
        double rectangleArea = rectangle.width * rectangle.height;
        double rectanglePerimeter = 2 * (rectangle.width + rectangle.height);
        System.out.println("Площа: " + rectangleArea + "; периметр: " + rectanglePerimeter);
    }

    static class Rectangle {
        public double width;
        public double height;
    }
}
