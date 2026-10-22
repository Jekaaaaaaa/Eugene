package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть сторону а: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть сторону b: ");
        double b = scanner.nextDouble();
        System.out.print("Введіть сторону c: ");
        double c = scanner.nextDouble();
        boolean isTriangle = (a + b > c)
                && (a + c > b)
                && (b + c > a);
        System.out.println("Трикутник існує: " + isTriangle);
    }
}
