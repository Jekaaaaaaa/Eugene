package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            long bigNumber = 3_000_000_000L;
            int smallNumber = (int) bigNumber;
            System.out.println("long: " + bigNumber);
            System.out.println("Після приведення до int: " + smallNumber);
            System.out.println("3 000 000 000 перевищує Integer.MAX_VALUE (2 147 483 647).");
            System.out.println("Зберігаються молодші 32 біти: результат -1 294 967 296, знак змінюється.");
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
