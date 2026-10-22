package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Спожито: ");
        double electricity = scanner.nextDouble();
        double total;
        if (electricity <= 100) {
            total = electricity * 2.64;
        }else {
            total = 100 * 2.64 + (electricity - 100) * 4.32;
        }
        System.out.println("Сума до сплати: " + total + " грн");
    }
}
