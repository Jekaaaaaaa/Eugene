package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            for (int i = 100; i <= 200; i++) {
                if (i % 13 == 0 && i % 7 == 0) {
                    System.out.println("Перше число: " + i);
                    break;
                }
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
