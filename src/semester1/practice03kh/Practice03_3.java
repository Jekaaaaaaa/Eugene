package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть суму в гривнях (UAH): ");
        double grn = scanner.nextDouble();
        System.out.print("Ввеіть курс USD: ");
        double dollar = scanner.nextDouble();
        double result = grn / dollar;
        double rounded = Math.round(result * 100) / 100.0;
        System.out.println("Сума до видачі: " + rounded + "USD");
    }
}
