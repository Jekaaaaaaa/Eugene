package semester1.practice07;

import java.util.Objects;

public class Practice07_21 {
    public static void main(String[] args) {
        ArraySearcher searcher = new ArraySearcher();
        int[] numbers = {5, 8, 2, 8};
        String[] words = {"Java", "Масив", "Клас"};
        System.out.println(searcher.find(numbers, 8));
        System.out.println(searcher.find(numbers, 8, 2));
        System.out.println(searcher.find(words, "java"));
        System.out.println(searcher.find(words, "java", true));
    }

    static class ArraySearcher {
        public int find(int[] arr, int target) {
            return find(arr, target, 0);
        }

        public int find(int[] arr, int target, int startIndex) {
            for (int i = Math.max(0, startIndex); i < arr.length; i++) {
                if (arr[i] == target) {
                    return i;
                }
            }
            return -1;
        }

        public int find(String[] arr, String target) {
            return find(arr, target, false);
        }

        public int find(String[] arr, String target, boolean ignoreCase) {
            for (int i = 0; i < arr.length; i++) {
                boolean matches = ignoreCase && target != null
                        ? target.equalsIgnoreCase(arr[i]) : Objects.equals(target, arr[i]);
                if (matches) {
                    return i;
                }
            }
            return -1;
        }
    }
}
