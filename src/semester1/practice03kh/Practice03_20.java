package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть бал: ");
        int score = scanner.nextInt();
        System.out.println("Результат: " + (score >= 60 ? "Зараховано" : "Незараховано"));
    }
}