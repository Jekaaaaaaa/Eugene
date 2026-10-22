package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Ціле число N > 1: ");
            int n = scanner.nextInt();
            if (n <= 1) {
                System.out.println("N має бути більшим за 1.");
                return;
            }
            int divisor = 2;
            while (divisor <= n / divisor && n % divisor != 0) {
                divisor++;
            }
            if (divisor > n / divisor) {
                divisor = n; // Якщо менших дільників немає, число просте.
            }
            System.out.println("Найменший дільник: " + divisor);
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
