package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Чисельник: ");
            double numerator = scanner.nextDouble();
            double denominator;
            do {
                System.out.print("Знаменник (не 0): ");
                denominator = scanner.nextDouble();
                if (denominator == 0) {
                    System.out.println("Ділення на нуль неможливе. Повторіть введення.");
                }
            } while (denominator == 0);
            System.out.println("Результат: " + numerator / denominator);
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
