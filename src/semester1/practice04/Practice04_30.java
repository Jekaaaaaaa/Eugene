package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Кількість чисел N (> 0): ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("N має бути додатним.");
                return;
            }
            int sum = 0;
            System.out.println("Введіть " + n + " цілих чисел:");
            for (int i = 0; i < n; i++) {
                sum = Math.addExact(sum, scanner.nextInt());
            }
            double average = (double) sum / n;
            System.out.println("Із приведенням до double: " + average);
            System.out.println("Без приведення (цілочисельне ділення): " + sum / n);
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
