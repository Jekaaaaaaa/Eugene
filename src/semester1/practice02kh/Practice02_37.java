package semester1.practice02kh;

public class Practice02_37 {
    public static void main(String[] args) {
        double a = 1.0;
        double b = -7.0;
        double c = 10.0;
        double d = Math.pow(b, 2) - 4 * a * c;
        double x1 = (-b + Math.sqrt(d)) / (2 * a);
        double x2 = (-b - Math.sqrt(d)) / (2 * a);
        System.out.println("Дискримінант D = " + d);
        System.out.println("Корінь x1 = " + x1);
        System.out.println("Корінь X2 = " + x2);
    }
}
