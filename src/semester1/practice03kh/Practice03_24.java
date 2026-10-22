package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість помилок: ");
        int count = scanner.nextInt();
        String result = (count == 1) ? "Знайдено 1 помилку" : "Знайдено " + count + " помилок";
        System.out.println(result);
    }
}
