package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Введіть слово: ");
            String word = scanner.next();
            System.out.print("Зашифровано: ");
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                System.out.print((char) (ch + 1));
            }
            System.out.println(); // За умовою зсуваємо код на 1, без циклічного переходу Z -> A.
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
