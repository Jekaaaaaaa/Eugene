package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            int count = 10;
            while (count >= 1) {
                System.out.println(count);
                count--;
            }
            System.out.println("Поїхали! Ракета запущена!");
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
