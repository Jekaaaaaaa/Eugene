package semester1.practice07;

public class Practice07_5 {
    public static void main(String[] args) {
        Product product = new Product("Миша", 500.0, 10, "Електроніка");
        product.printProduct();
        System.out.println("Вартість партії: " + product.getTotalValue() + " грн");
        product.applyDiscount(20.0);
        System.out.println("Після знижки: " + product.getTotalValue() + " грн");
    }

    static class Product {
        private String name;
        private double price;
        private int quantity;
        private String category;

        public Product(String name, double price, int quantity, String category) {
            this.name = name;
            this.price = price >= 0.0 ? price : 0.0;
            this.quantity = Math.max(0, quantity);
            this.category = category;
        }

        public double getTotalValue() {
            return price * quantity;
        }

        public void applyDiscount(double percent) {
            if (percent >= 0.0 && percent <= 100.0) {
                price *= 1.0 - percent / 100.0;
            }
        }

        public void printProduct() {
            System.out.println(name + " (" + category + "), ціна: " + price + " грн, кількість: " + quantity);
        }
    }
}
