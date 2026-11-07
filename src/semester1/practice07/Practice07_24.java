package semester1.practice07;

import java.util.Arrays;

public class Practice07_24 {
    public static void main(String[] args) {
        ArrayFilter filter = new ArrayFilter();
        int[] numbers = {12, 5, 8, 19, 24, 3, 16};
        System.out.println("Більші за 10: " + Arrays.toString(filter.filter(numbers, 10)));
        System.out.println("Від 8 до 19: " + Arrays.toString(filter.filter(numbers, 8, 19)));
        System.out.println("Парні: " + Arrays.toString(filter.filter(numbers, true)));
        System.out.println("Непарні: " + Arrays.toString(filter.filter(numbers, false)));
    }

    static class ArrayFilter {
        public int[] filter(int[] arr, int threshold) {
            int[] result = new int[arr.length];
            int size = 0;
            for (int number : arr) {
                if (number > threshold) {
                    result[size++] = number;
                }
            }
            return Arrays.copyOf(result, size);
        }

        public int[] filter(int[] arr, int min, int max) {
            int[] result = new int[arr.length];
            int size = 0;
            for (int number : arr) {
                if (number >= min && number <= max) {
                    result[size++] = number;
                }
            }
            return Arrays.copyOf(result, size);
        }

        public int[] filter(int[] arr, boolean keepEvens) {
            int[] result = new int[arr.length];
            int size = 0;
            for (int number : arr) {
                if ((number % 2 == 0) == keepEvens) {
                    result[size++] = number;
                }
            }
            return Arrays.copyOf(result, size);
        }
    }
}
