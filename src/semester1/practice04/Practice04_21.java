package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("A: ");
            int a = scanner.nextInt();
            System.out.print("B: ");
            int b = scanner.nextInt();
            if (a > b) {
                System.out.println("Потрібно A <= B.");
                return;
            }
            for (long i = a; i <= b; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
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
