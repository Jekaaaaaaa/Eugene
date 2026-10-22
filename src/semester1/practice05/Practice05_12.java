package semester1.practice05;

import java.util.Scanner;

public class Practice05_12 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] students = {1042, 2031, 3055, 4018, 5099};
            System.out.print("Введіть номер залікової книжки: ");
            int target = scanner.nextInt();
            int foundIndex = -1;
            for (int i = 0; i < students.length; i++) {
                if (students[i] == target) {
                    foundIndex = i;
                    break;
                }
            }
            if (foundIndex == -1) {
                System.out.println("Студента з таким номером не знайдено");
            } else {
                System.out.println("Індекс студента: " + foundIndex);
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Потрібно ввести ціле число.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Введення завершилося раніше, ніж очікувалося.");
        }
    }
}
