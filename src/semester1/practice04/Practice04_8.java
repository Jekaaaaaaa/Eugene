package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Введіть M: ");
            long m = scanner.nextLong();
            if (m < 1) {
                System.out.println("Немає степенів двійки, менших або рівних M.");
                return;
            }
            long power = 1;
            while (power <= m) {
                System.out.print(power + " ");
                if (power > m / 2) {
                    break; // Наступний степінь перевищить M; також захист від переповнення.
                }
                power *= 2;
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
