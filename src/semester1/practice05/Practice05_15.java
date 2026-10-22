package semester1.practice05;

public class Practice05_15 {
    public static void main(String[] args) {
        double[] prices = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};
        double min = prices[0];
        double max = prices[0];
        for (double price : prices) {
            if (price < min) {
                min = price;
            }
            if (price > max) {
                max = price;
            }
        }
        System.out.printf(java.util.Locale.US, "Розмах: %.2f%n", max - min);
    }
}
