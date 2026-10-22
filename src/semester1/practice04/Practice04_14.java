package semester1.practice04;

import java.util.Locale;
import java.util.Scanner;

public class Practice04_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            int choice;
            do {
                System.out.println("1. Розпочати нову гру\n2. Завантажити збереження\n3. Налаштування\n0. Вихід");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("Нову гру розпочато.");
                    case 2 -> System.out.println("Обрано завантаження збереження.");
                    case 3 -> System.out.println("Відкрито налаштування.");
                    case 0 -> System.out.println("До побачення!");
                    default -> System.out.println("Невідомий пункт меню.");
                }
            } while (choice != 0);
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
