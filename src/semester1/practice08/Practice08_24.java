package semester1.practice08;

public class Practice08_24 {
    public static void main(String[] args) {
        System.out.println(new Coffee("Середнє обсмаження", 250, 45.0));
        System.out.println(new LatteWithAddons("Світле обсмаження", 300, 65.0, "вівсяне", 2));
    }

    static class Coffee {
        private String roastType;
        private int volumeMl;
        private double basePrice;

        public Coffee(String roastType, int volumeMl, double basePrice) {
            this.roastType = roastType;
            this.volumeMl = volumeMl;
            this.basePrice = basePrice;
        }

        // У прикладі чорна кава має 2 ккал на 100 мл.
        public double calculateCalories() {
            return volumeMl * 0.02;
        }

        public double calculatePrice() {
            return basePrice;
        }

        @Override
        public String toString() {
            return roastType + ", " + volumeMl + " мл, " + calculateCalories() + " ккал, " + calculatePrice() + " грн";
        }
    }

    static class LatteWithAddons extends Coffee {
        private String milkType;
        private int syrupPumps;

        public LatteWithAddons(String roastType, int volumeMl, double basePrice, String milkType, int syrupPumps) {
            super(roastType, volumeMl, basePrice);
            this.milkType = milkType;
            this.syrupPumps = syrupPumps;
        }

        // Для прикладу порція молока має 80 ккал, порція сиропу — 20 ккал.
        @Override
        public double calculateCalories() {
            return super.calculateCalories() + 80.0 + 20.0 * syrupPumps;
        }

        @Override
        public double calculatePrice() {
            double milkSurcharge = "коров'яче".equalsIgnoreCase(milkType) ? 0.0 : 20.0;
            return super.calculatePrice() + milkSurcharge + 12.0 * syrupPumps;
        }

        @Override
        public String toString() {
            return "Лате, молоко: " + milkType + ", порцій сиропу: " + syrupPumps + " | " + super.toString();
        }
    }
}
