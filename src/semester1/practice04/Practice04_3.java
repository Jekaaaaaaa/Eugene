package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            int balance = 0;
            for (int month = 1; month <= 12; month++) {
                balance += 500;
                System.out.println("Місяць " + month + ": " + balance + " грн");
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
