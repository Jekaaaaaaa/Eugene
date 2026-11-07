package semester1.practice09;

public class Practice09_18 {
    public static void main(String[] args) {
        ShoppingOrder order = new ShoppingOrder(10);
        order.addItem("Зошит", 45.0, 2);
        order.addItem("Ручка", 30.0, 1);
        order.addItem("Зошит", 45.0, 1);
        System.out.println(order);
    }

    static class OrderItem {
        private final String productName;
        private final double unitPrice;
        private int quantity;

        public OrderItem(String productName, double unitPrice, int quantity) {
            this.productName = productName;
            this.unitPrice = unitPrice;
            this.quantity = quantity;
        }

        public double getItemTotal() {
            return unitPrice * quantity;
        }

        public void increaseQuantity(int quantity) {
            this.quantity = Math.addExact(this.quantity, quantity);
        }

        public String getProductName() {
            return productName;
        }

        @Override
        public String toString() {
            return String.format("%s × %d по %.2f грн = %.2f грн", productName, quantity, unitPrice, getItemTotal());
        }
    }

    static class ShoppingOrder {
        private final OrderItem[] items;
        private int itemCount;

        public ShoppingOrder(int capacity) {
            this.items = new OrderItem[capacity];
        }

        public void addItem(String name, double price, int qty) {
            if (qty <= 0 || !(price >= 0.0) || !Double.isFinite(price)) {
                return;
            }
            for (int i = 0; i < itemCount; i++) {
                if (items[i].getProductName().equals(name)) {
                    items[i].increaseQuantity(qty);
                    return;
                }
            }
            if (itemCount < items.length) {
                items[itemCount++] = new OrderItem(name, price, qty);
            }
        }

        public double calculateGrandTotal() {
            double total = 0.0;
            for (int i = 0; i < itemCount; i++) {
                total += items[i].getItemTotal();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder receipt = new StringBuilder("=== Чек ===");
            for (int i = 0; i < itemCount; i++) {
                receipt.append(System.lineSeparator()).append(items[i]);
            }
            return receipt.append(String.format("%nРазом: %.2f грн", calculateGrandTotal())).toString();
        }
    }
}
