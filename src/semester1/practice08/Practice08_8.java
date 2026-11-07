package semester1.practice08;

public class Practice08_8 {
    public static void main(String[] args) {
        InvoiceItem item = new InvoiceItem("Зошит", 3, 50.0, 20.0);
        System.out.println("Позиція чека: " + item);
    }

    static class InvoiceItem {
        private String description;
        private int quantity;
        private double unitPrice;
        private double discountPercent;

        public InvoiceItem(String description, int quantity, double unitPrice, double discountPercent) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.discountPercent = discountPercent >= 0.0 && discountPercent <= 50.0 ? discountPercent : 0.0;
        }

        public double getFinalAmount() {
            return quantity * unitPrice * (1.0 - discountPercent / 100.0);
        }

        @Override
        public String toString() {
            return String.format("%s × %d по %.2f грн, знижка %.0f%%, разом %.2f грн",
                    description, quantity, unitPrice, discountPercent, getFinalAmount());
        }
    }
}
