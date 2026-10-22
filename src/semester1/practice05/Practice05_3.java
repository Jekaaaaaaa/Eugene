package semester1.practice05;

import java.util.Arrays;

public class Practice05_3 {
    public static void main(String[] args) {
        double[] prices = {120.50, 45.00, 890.99, 15.30, 420.00};
        System.out.println(Arrays.toString(prices));
        prices[2] = prices[2] * 0.8;
        System.out.println(Arrays.toString(prices));
    }
}
