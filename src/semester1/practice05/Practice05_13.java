package semester1.practice05;

import java.util.Scanner;

public class Practice05_13 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};
            System.out.print("Введіть число від 1 до 6: ");
            int target = scanner.nextInt();
            if (target < 1 || target > 6) {
                System.out.println("Число має бути від 1 до 6.");
                return;
            }
            int count = 0;
            for (int roll : rolls) {
                if (roll == target) {
                    count++;
                }
            }
            System.out.println("Кількість входжень: " + count);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Потрібно ввести ціле число.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Введення завершилося раніше, ніж очікувалося.");
        }
    }
}
