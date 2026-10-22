package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Введіть текст: ");
            String text = scanner.nextLine();
            System.out.print("Кількість копій N (>= 1): ");
            int n = scanner.nextInt();
            if (n < 1) {
                System.out.println("N має бути не меншим за 1.");
                return;
            }
            for (long i = 1; i <= n; i++) {
                System.out.println("[" + i + "] " + text);
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
