package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть бал: ");
        int score = scanner.nextInt();
        if (score < 0 || score > 100) {
            System.out.print("Помилка: некоректний бал!");
        }else if (score >= 90) {
            System.out.print("Відмінно");
        }else if (score >= 82) {
            System.out.print("Дуже добре");
        }else if (score >= 74) {
            System.out.print("Добре");
        }else if (score >= 64) {
            System.out.print("Достатньо");
        }else {
            System.out.println("Незадовільно");

        }
    }
}
