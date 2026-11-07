package semester1.practice07;

public class Practice07_14 {
    public static void main(String[] args) {
        new CoffeeOrder("Еспресо").printReceipt();
        new CoffeeOrder("Капучино", "Small").printReceipt();
        new CoffeeOrder("Лате", "Large", 2, true).printReceipt();
    }

    static class CoffeeOrder {
        private String type;
        private String size;
        private int sugarCount;
        private boolean withSyrup;
        private double finalPrice;

        public CoffeeOrder(String type, String size, int sugarCount, boolean withSyrup) {
            this.type = type;
            this.size = size;
            this.sugarCount = sugarCount;
            this.withSyrup = withSyrup;
            this.finalPrice = calculatePrice();
        }

        public CoffeeOrder(String type, String size) {
            this(type, size, 0, false);
        }

        public CoffeeOrder(String type) {
            this(type, "Medium");
        }

        private double calculatePrice() {
            double basePrice;
            switch (type) {
                case "Еспресо": basePrice = 40.0; break;
                case "Капучино": basePrice = 55.0; break;
                case "Лате": basePrice = 60.0; break;
                default: throw new IllegalArgumentException("Невідомий вид кави: " + type);
            }
            double multiplier;
            switch (size) {
                case "Small": multiplier = 1.0; break;
                case "Medium": multiplier = 1.3; break;
                case "Large": multiplier = 1.6; break;
                default: throw new IllegalArgumentException("Невідомий розмір: " + size);
            }
            return basePrice * multiplier + (withSyrup ? 15.0 : 0.0);
        }

        public void printReceipt() {
            System.out.printf("%s (%s), цукор: %d, сироп: %s, до сплати: %.2f грн%n",
                    type, size, sugarCount, withSyrup ? "так" : "ні", finalPrice);
        }
    }
}
