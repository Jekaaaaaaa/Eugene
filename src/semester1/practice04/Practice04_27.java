package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Кількість доданків N (> 0): ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("N має бути додатним.");
                return;
            }
            long sum = 0;
            for (long i = 1; i <= n; i++) {
                sum += i % 2 == 0 ? -i : i;
            }
            System.out.println("Сума ряду: " + sum);
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
