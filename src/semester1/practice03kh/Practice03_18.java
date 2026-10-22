package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        int n = scanner.nextInt();
        int abs = (n < 0) ? -n : n;
        System.out.println("Абсолютне значення: " + abs);
    }
}
