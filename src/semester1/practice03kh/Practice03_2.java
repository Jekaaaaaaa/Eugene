package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть перше число: ");
        int a = scanner.nextInt();
        System.out.print("Введіть друге число: ");
        int b = scanner.nextInt();
        System.out.println("Сума: " + ( a + b));
        System.out.println("Різниця: " + ( a - b));
        System.out.println("Добуток: " + ( a * b ));
        System.out.println("Остача від ділення: " + ( a / b ));
    }
}
