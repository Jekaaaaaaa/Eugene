package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            for (int row = 1; row <= 10; row++) {
                for (int col = 1; col <= 10; col++) {
                    System.out.printf("%4d", row * col);
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
