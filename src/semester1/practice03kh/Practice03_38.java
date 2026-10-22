package semester1.practice03kh;

import java.util.Scanner;

public class Practice03_38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Число 1: ");
        double a = scanner.nextDouble();
        System.out.print("Оберіть операцію (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.print("Число 2: ");
        double b = scanner.nextDouble();
        switch (op) {
            case '+':
                System.out.println("Результат: " + (a + b));
                break;
            case '-':
                System.out.println("Результат: " + (a - b));
                break;
            case '*':
                System.out.println("Результат: " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Помилка: ділення на нуль!");
                } else {
                    System.out.println("Результат: " + (a / b));
                }
                break;
            default:
                System.out.println("Невідома операція.");
        }
    }
}
