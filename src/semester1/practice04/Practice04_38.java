package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Висота трикутника N: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("Висота має бути додатною.");
                return;
            }
            for (long row = 1; row <= n; row++) {
                for (long col = 1; col <= row; col++) {
                    System.out.print('*');
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
