package semester1.practice06;

import java.util.Locale;

public class Practice06_5 {
    public static void main(String[] args) {
        Product product = new Product();
        product.name = "Монітор";
        product.price = 6500.0;
        product.quantity = 8;
        System.out.printf(Locale.US, "%s: %d шт., загальна вартість: %.2f грн%n",
                product.name, product.quantity, product.price * product.quantity);
    }

    static class Product {
        public String name;
        public double price;
        public int quantity;
    }
}
