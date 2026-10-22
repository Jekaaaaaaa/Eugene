package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        int number = scanner.nextInt();
        if (number == 0) {
            System.out.println("Число є нулем: ");
        }else if (number % 2 == 0) {
            System.out.println("Число " + number + " є парним.");
        }else {
            System.out.println("Число " + number + " є непарним");
        }
    }
}
