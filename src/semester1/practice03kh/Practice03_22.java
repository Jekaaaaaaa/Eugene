package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть суму: ");
        double price = scanner.nextDouble();
        double finalePrice = price > 1000
                ? price * 0.90
                : price * 0.98;
        System.out.println("Сума покупки: " + price + " грн");
        System.out.println("До сплати зі знижеою: " + finalePrice + " грн");
    }
}
