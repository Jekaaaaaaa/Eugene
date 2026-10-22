package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Курс євро до гривні: ");
            double rate = scanner.nextDouble();
            if (!Double.isFinite(rate) || rate <= 0) {
                System.out.println("Курс має бути додатним скінченним числом.");
                return;
            }
            for (int euro = 10; euro <= 100; euro += 10) {
                System.out.printf(Locale.US, "%3d EUR = %.2f грн%n", euro, euro * rate);
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
