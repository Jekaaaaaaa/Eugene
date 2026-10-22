package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            String answer;
            do {
                System.out.print("Перше число: ");
                double a = scanner.nextDouble();
                System.out.print("Друге число: ");
                double b = scanner.nextDouble();
                System.out.println("Сума: " + (a + b));
                System.out.print("Бажаєте продовжити? (y/n): ");
                answer = scanner.next();
            } while (answer.equalsIgnoreCase("y"));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Некоректний формат введення. Дробові числа вводьте через крапку.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Введення завершилося раніше, ніж очікувалося.");
        } catch (ArithmeticException e) {
            System.out.println("Результат не вміщується у вибраний числовий тип.");
        } finally {
            scanner.close();
        }
    }

}
