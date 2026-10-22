package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Ширина рамки W (> 0): ");
            int width = scanner.nextInt();
            if (width <= 0) {
                System.out.println("Ширина має бути додатною.");
                return;
            }
            for (int i = 0; i < width; i++) {
                System.out.print("=");
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
