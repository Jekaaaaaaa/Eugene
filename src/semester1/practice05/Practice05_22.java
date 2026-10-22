package semester1.practice05;

import java.util.Arrays;

public class Practice05_22 {
    public static void main(String[] args) {
        int[] test = {45, 12, 89, 3, 27};
        System.out.println(Arrays.toString(test));
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
        Arrays.fill(test, -1);
        System.out.println(Arrays.toString(test));
    }
}
