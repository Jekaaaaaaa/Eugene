package semester1.practice08;

public class Practice08_39 {
    public static void main(String[] args) {
        ShieldedPaladin paladin = new ShieldedPaladin("Паладин", 100, 5, 30);
        System.out.println(paladin);
        paladin.takeDamage(20);
        System.out.println(paladin);
        paladin.takeDamage(40);
        System.out.println(paladin);
    }

    static class CharacterUnit {
        private String name;
        protected int hp;
        protected int maxHp;
        protected int armor;

        public CharacterUnit(String name, int maxHp, int armor) {
            this.name = name;
            this.maxHp = maxHp;
            this.hp = maxHp;
            this.armor = armor;
        }

        public void takeDamage(int rawDamage) {
            hp = Math.max(0, hp - Math.max(1, rawDamage - armor));
        }

        @Override
        public String toString() {
            int filled = maxHp > 0 ? (int) (10L * hp / maxHp) : 0;
            StringBuilder bar = new StringBuilder("[");
            for (int i = 0; i < 10; i++) {
                bar.append(i < filled ? '█' : '░');
            }
            return name + " " + bar.append(']') + " " + hp + "/" + maxHp + " HP";
        }
    }

    static class ShieldedPaladin extends CharacterUnit {
        private int shieldPoints;

        public ShieldedPaladin(String name, int maxHp, int armor, int shieldPoints) {
            super(name, maxHp, armor);
            this.shieldPoints = shieldPoints;
        }

        @Override
        public void takeDamage(int rawDamage) {
            if (rawDamage <= 0) {
                return;
            }
            int absorbed = Math.min(rawDamage, shieldPoints);
            shieldPoints -= absorbed;
            int remainingDamage = rawDamage - absorbed;
            if (remainingDamage > 0) {
                super.takeDamage(remainingDamage);
            }
        }

        @Override
        public String toString() {
            return super.toString() + ", щит: " + shieldPoints;
        }
    }
}
