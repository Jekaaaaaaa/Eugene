package semester1.practice08;

import java.util.Locale;

public class Practice08_2 {
    public static void main(String[] args) {
        Product monitor = new Product("A-101", "Монітор", 6499.5, 4);
        Product mouse = new Product("A-102", "Миша", 650.0, 7);
        mouse.setStock(6);
        System.out.println(monitor);
        System.out.println(mouse);
    }

    static class Product {
        private String sku;
        private String title;
        private double price;
        private int stock;

        public Product(String sku, String title, double price, int stock) {
            this.sku = sku;
            this.title = title;
            setPrice(price);
            setStock(stock);
        }

        public void setPrice(double price) {
            this.price = Double.isFinite(price) && price >= 0.0 ? price : 0.0;
        }

        public void setStock(int stock) {
            this.stock = Math.max(0, stock);
        }

        public double getTotalCost() {
            return price * stock;
        }

        @Override
        public String toString() {
            return String.format(Locale.ROOT, "[SKU: %s] %s | Ціна: %.2f грн | Залишок: %d шт. | Разом: %.2f грн",
                    sku, title, price, stock, getTotalCost());
        }
    }
}
