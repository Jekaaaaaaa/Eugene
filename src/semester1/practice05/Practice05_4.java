package semester1.practice05;

import java.util.Arrays;

import java.util.Scanner;

public class Practice05_4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введіть N > 0: ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("N має бути додатним.");
                return;
            }
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i + 1;
            }
            System.out.println(Arrays.toString(arr));
        } catch (java.util.InputMismatchException e) {
            System.out.println("Потрібно ввести ціле число.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Введення завершилося раніше, ніж очікувалося.");
        }
    }
}
