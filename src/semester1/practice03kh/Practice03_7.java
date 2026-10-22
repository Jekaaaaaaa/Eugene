package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Катет A: ");
        double a = scanner.nextDouble();
        System.out.print("Катет B: ");
        double b = scanner.nextDouble();
        double hypotenuse = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        double perimeter = a + b + hypotenuse;
        double area = (a * b) / 2;
        System.out.println("Гіпотенуза: " + hypotenuse);
        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа: " + area);
    }
}
