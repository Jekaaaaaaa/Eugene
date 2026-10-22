package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Додатне ціле число N (тип int): ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("N має бути додатним.");
                return;
            }
            long reversed = 0; // Реверс int може не вміститися в int.
            while (n > 0) {
                reversed = reversed * 10 + n % 10;
                n /= 10;
            }
            System.out.println("Реверс: " + reversed);
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
