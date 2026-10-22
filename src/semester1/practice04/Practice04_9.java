package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Додатне ціле число N: ");
            long n = scanner.nextLong();
            if (n <= 0) {
                System.out.println("N має бути додатним.");
                return;
            }
            int digits = 0;
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                digits++;
                n /= 10;
            }
            System.out.println("Кількість цифр: " + digits);
            System.out.println("Сума цифр: " + sum);
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
