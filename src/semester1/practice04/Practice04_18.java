package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            int first;
            int second;
            int attempts = 0;
            do {
                first = (int) (Math.random() * 6) + 1;
                second = (int) (Math.random() * 6) + 1;
                attempts++;
                System.out.println("Кидок " + attempts + ": " + first + " і " + second);
            } while (first != second);
            System.out.println("Дубль! Кількість спроб: " + attempts);
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
