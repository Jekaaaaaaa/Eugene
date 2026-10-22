package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            int attempts = 0;
            boolean authorized;
            do {
                System.out.print("Введіть PIN (спроба " + (attempts + 1) + "/3): ");
                authorized = scanner.next().equals("1234");
                attempts++;
                if (authorized) {
                    System.out.println("Доступ надано");
                    break;
                }
                System.out.println("Невірний PIN.");
            } while (attempts < 3);
            if (!authorized) {
                System.out.println("Карту заблоковано!");
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
