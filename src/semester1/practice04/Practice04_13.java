package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            int secret = (int) (Math.random() * 100) + 1;
            int attempts = 0;
            int guess = 0;
            System.out.println("Вгадайте число від 1 до 100.");
            while (guess != secret) {
                System.out.print("Ваша спроба: ");
                guess = scanner.nextInt();
                attempts++;
                if (guess < secret) {
                    System.out.println("Більше!");
                } else if (guess > secret) {
                    System.out.println("Менше!");
                }
            }
            System.out.println("Вгадали! Кількість спроб: " + attempts);
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
