package semester1.practice08;

public class Practice08_20 {
    public static void main(String[] args) {
        System.out.println(new EnchantedSword("Клинок", 40, "вогонь", 12, 3));
    }

    static class Weapon {
        private String title;
        private int baseDamage;

        public Weapon(String title, int baseDamage) {
            this.title = title;
            this.baseDamage = baseDamage;
        }

        public int calculateDamage() {
            return baseDamage;
        }

        public String getTitle() {
            return title;
        }
    }

    static class EnchantedSword extends Weapon {
        private String element;
        private int magicPower;
        private int enchantmentLevel;

        public EnchantedSword(String title, int baseDamage, String element, int magicPower, int enchantmentLevel) {
            super(title, baseDamage);
            this.element = element;
            this.magicPower = magicPower;
            this.enchantmentLevel = enchantmentLevel;
        }

        @Override
        public int calculateDamage() {
            return super.calculateDamage() + magicPower * enchantmentLevel;
        }

        @Override
        public String toString() {
            return getTitle() + ", стихія: " + element + ", фізична шкода: " + super.calculateDamage()
                    + ", магічна: " + magicPower * enchantmentLevel + ", разом: " + calculateDamage();
        }
    }
}
