package semester1.practice05;

public class Practice05_5 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 15, 16, 23, 42};
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
