package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            byte b = 125;
            System.out.println("Початкове значення: " + b);
            for (int i = 1; i <= 6; i++) {
                b = (byte) (b + 1);
                System.out.println("Крок " + i + ": " + b);
            }
            System.out.println("byte має діапазон -128..127. Після 127 значення 128 при звуженні стає -128.");
            System.out.println("Зберігаються лише молодші 8 бітів, тому виникає переповнення.");
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
