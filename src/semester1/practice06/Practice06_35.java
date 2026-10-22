package semester1.practice06;

import java.util.Locale;

public class Practice06_35 {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(100);
        cart.addItem(200);
        cart.addItem(50);
        cart.printReceipt();
        cart.applyDiscount(15);
        cart.printReceipt();
    }

    static class ShoppingCart {
        private double[] itemPrices = new double[10];
        private int count;
    
        public void addItem(double price) {
            if (!Double.isFinite(price) || price < 0) {
                System.out.println("Некоректна ціна.");
            } else if (count == itemPrices.length) {
                System.out.println("Кошик заповнений.");
            } else {
                itemPrices[count] = price;
                count++;
            }
        }
    
        public double getTotalCost() {
            double sum = 0;
            for (int i = 0; i < count; i++) {
                sum += itemPrices[i];
            }
            return sum;
        }
    
        public void applyDiscount(double percent) {
            if (!Double.isFinite(percent) || percent < 0 || percent > 100) {
                System.out.println("Знижка має бути від 0 до 100%.");
                return;
            }
            for (int i = 0; i < count; i++) {
                itemPrices[i] *= 1 - percent / 100;
            }
        }
    
        public void printReceipt() {
            System.out.println("--- ЧЕК ---");
            for (int i = 0; i < count; i++) {
                System.out.printf(java.util.Locale.US, "%d. %.2f грн%n", i + 1, itemPrices[i]);
            }
            System.out.printf(java.util.Locale.US, "Разом: %.2f грн%n", getTotalCost());
        }
    }
}
