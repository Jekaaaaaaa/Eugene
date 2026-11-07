package semester1.practice08;

public class Practice08_36 {
    public static void main(String[] args) {
        double[] prices = {950.0, 1000.0, 1050.0};
        System.out.println(new WarehouseItem("Стілець", 5, prices));
        System.out.println(new DiscountedWarehouseItem("Стілець", 5, prices, "Подряпина", 20.0));
    }

    static class WarehouseItem {
        private String name;
        private int quantity;
        private double[] priceHistory;

        public WarehouseItem(String name, int quantity, double[] priceHistory) {
            this.name = name;
            this.quantity = quantity;
            this.priceHistory = priceHistory.clone();
        }

        public int getQuantity() {
            return quantity;
        }

        public double getAveragePurchasePrice() {
            double sum = 0.0;
            for (double price : priceHistory) {
                sum += price;
            }
            return priceHistory.length == 0 ? 0.0 : sum / priceHistory.length;
        }

        @Override
        public String toString() {
            return name + ", кількість: " + quantity + ", середня закупівельна ціна: " + getAveragePurchasePrice() + " грн";
        }
    }

    static class DiscountedWarehouseItem extends WarehouseItem {
        private String markdownReason;
        private double discountPercent;

        public DiscountedWarehouseItem(String name, int quantity, double[] priceHistory, String markdownReason, double discountPercent) {
            super(name, quantity, priceHistory);
            this.markdownReason = markdownReason;
            this.discountPercent = discountPercent;
        }

        public double getSaleTotal() {
            return getQuantity() * getAveragePurchasePrice() * (1.0 - discountPercent / 100.0);
        }

        @Override
        public String toString() {
            return super.toString() + ", причина уцінки: " + markdownReason + ", розпродаж партії: " + getSaleTotal() + " грн";
        }
    }
}
