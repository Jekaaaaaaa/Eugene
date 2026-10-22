package semester1.practice05;

import java.util.Arrays;

public class Practice05_1 {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        numbers[0] = 10;
        numbers[2] = 30;
        numbers[4] = 50;
        System.out.println(Arrays.toString(numbers));
    }
}
