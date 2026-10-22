package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Розмір шахівниці N: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Розмір має бути додатним.");
                return;
            }
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    System.out.print((row % 2 == col % 2) ? '#' : '_');
                    if (col < n - 1) {
                        System.out.print(' ');
                    }
                }
                System.out.println();
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
