package semester1.practice05;

import java.util.Arrays;

public class Practice05_6 {
    public static void main(String[] args) {
        int[] powers = new int[10];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }
        System.out.println(Arrays.toString(powers));
    }
}
