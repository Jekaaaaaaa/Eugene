package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ділення а: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть дільник b: ");
        double b = scanner.nextDouble();
        System.out.println(b != 0 ? "Результат ділення: " + (a / b) : "Помилка: ділення на нуль неможливе!");
    }
}
