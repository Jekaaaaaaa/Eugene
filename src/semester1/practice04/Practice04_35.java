package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.println("Накопичення похибки double:");
            for (double d = 0.0; d <= 1.0; d += 0.1) {
                System.out.println(d);
            }
            System.out.println("Цілочисельний лічильник (11 кроків):");
            for (int i = 0; i <= 10; i++) {
                double val = i / 10.0;
                System.out.println(val);
            }
            System.out.println("0.1 не має точного двійкового представлення; додавання накопичує похибку.");
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
