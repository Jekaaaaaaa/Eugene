package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            long sum = 0;
            int count = 0;
            int grade;
            do {
                System.out.print("Бал 0–100 (від'ємне число — завершити): ");
                if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("Потрібно ввести ціле число.");
                    grade = 101;
                    continue;
                }
                grade = scanner.nextInt();
                if (grade > 100) {
                    System.out.println("Некоректний бал. Повторіть введення.");
                } else if (grade >= 0) {
                    sum += grade;
                    count++;
                }
            } while (grade >= 0);
            if (count == 0) {
                System.out.println("Не введено жодної оцінки.");
            } else {
                System.out.printf(Locale.US, "Середній бал: %.2f%n", (double) sum / count);
            }
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
