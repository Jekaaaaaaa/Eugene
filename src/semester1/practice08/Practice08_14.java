package semester1.practice08;

public class Practice08_14 {
    public static void main(String[] args) {
        System.out.println(new Smartphone("Samsung", 18000.0, 256, true));
        System.out.println(new Smartphone("Motorola", 12000.0, 128));
        System.out.println(new Smartphone("Nokia"));
    }

    static class Gadget {
        private String brand;
        private double price;

        public Gadget(String brand, double price) {
            this.brand = brand;
            this.price = price;
        }

        @Override
        public String toString() {
            return brand + ", ціна: " + price + " грн";
        }
    }

    static class Smartphone extends Gadget {
        private int memoryGb;
        private boolean has5G;

        public Smartphone(String brand, double price, int memoryGb, boolean has5G) {
            super(brand, price);
            this.memoryGb = memoryGb;
            this.has5G = has5G;
        }

        public Smartphone(String brand, double price, int memoryGb) {
            this(brand, price, memoryGb, true);
        }

        public Smartphone(String brand) {
            this(brand, 9999.0, 128, false);
        }

        @Override
        public String toString() {
            return super.toString() + ", пам'ять: " + memoryGb + " ГБ, 5G: " + has5G;
        }
    }
}
