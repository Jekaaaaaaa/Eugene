package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Висота H: ");
            int height = scanner.nextInt();
            System.out.print("Ширина W: ");
            int width = scanner.nextInt();
            if (height <= 0 || width <= 0) {
                System.out.println("Розміри мають бути додатними.");
                return;
            }
            for (int row = 0; row < height; row++) {
                for (int col = 0; col < width; col++) {
                    boolean border = row == 0 || row == height - 1 || col == 0 || col == width - 1;
                    System.out.print(border ? '*' : ' ');
                }
                System.out.println();
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
