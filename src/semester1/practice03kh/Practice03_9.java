package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число: ");
        int number = scanner.nextInt();
        if (number > 0) {
            System.out.print("Число додатне.");
        }else if (number < 0) {
            System.out.print("Чичло відємне.");
        }else {
            System.out.print("Число дорівнює нулю.");
        }
    }
}
