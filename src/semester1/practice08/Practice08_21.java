package semester1.practice08;

public class Practice08_21 {
    public static void main(String[] args) {
        System.out.println(new FragileParcel("UA112", 3.0, true, 2000.0));
    }

    static class Parcel {
        private String trackingCode;
        private double weightKg;

        public Parcel(String trackingCode, double weightKg) {
            this.trackingCode = trackingCode;
            this.weightKg = weightKg;
        }

        public double calculateShippingCost() {
            return 50.0 + weightKg * 12.0;
        }

        @Override
        public String toString() {
            return trackingCode + ", вага: " + weightKg + " кг, доставка: " + calculateShippingCost() + " грн";
        }
    }

    static class FragileParcel extends Parcel {
        private boolean requiresWoodenBox;
        private double insuranceValue;

        public FragileParcel(String trackingCode, double weightKg, boolean requiresWoodenBox, double insuranceValue) {
            super(trackingCode, weightKg);
            this.requiresWoodenBox = requiresWoodenBox;
            this.insuranceValue = insuranceValue;
        }

        @Override
        public double calculateShippingCost() {
            return super.calculateShippingCost() + insuranceValue * 0.015 + (requiresWoodenBox ? 120.0 : 0.0);
        }

        @Override
        public String toString() {
            return "Крихка посилка " + super.toString() + ", обрешітка: " + requiresWoodenBox
                    + ", страхова вартість: " + insuranceValue;
        }
    }
}
