package semester1.practice06;

import java.util.Locale;

public class Practice06_31 {
    public static void main(String[] args) {
        DiscountCard card = new DiscountCard();
        card.setOwnerName("Денис");
        card.addPurchase(3000);
        card.printCardInfo();
        card.addPurchase(4000);
        card.printCardInfo();
        card.addPurchase(3000);
        card.printCardInfo();
    }

    static class DiscountCard {
        private String ownerName;
        private double totalSpent;
        private int discountPercent = 1;
    
        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }
    
        public void addPurchase(double cost) {
            if (!Double.isFinite(cost) || cost <= 0 || !Double.isFinite(totalSpent + cost)) {
                System.out.println("Некоректна вартість покупки.");
                return;
            }
            totalSpent += cost;
            if (totalSpent >= 10000) {
                discountPercent = 10;
            } else if (totalSpent >= 5000) {
                discountPercent = 5;
            } else {
                discountPercent = 1;
            }
        }
    
        public void printCardInfo() {
            System.out.printf(java.util.Locale.US, "Власник: %s; покупки: %.2f грн; знижка: %d%%%n",
                    ownerName, totalSpent, discountPercent);
        }
    }
}
