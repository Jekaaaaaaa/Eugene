package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            int age;
            do {
                System.out.print("Введіть вік (1–120): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Потрібно ввести ціле число.");
                    scanner.next();
                    age = 0;
                    continue;
                }
                age = scanner.nextInt();
                if (age < 1 || age > 120) {
                    System.out.println("Вік поза допустимими межами.");
                }
            } while (age < 1 || age > 120);
            System.out.println("Вік підтверджено: " + age);
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
