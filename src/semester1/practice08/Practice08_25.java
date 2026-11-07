package semester1.practice08;

public class Practice08_25 {
    public static void main(String[] args) {
        AlchemistHero hero = new AlchemistHero("Alchemist", 200, 25, 12);
        System.out.println(new DotaHero("Invoker", "Інтелект", 200));
        System.out.println(new StrengthHero("Axe", 200, 27));
        System.out.println(hero);
        System.out.println(hero.chemicalRage());
    }

    static class DotaHero {
        private String name;
        private String primaryAttribute;
        private int baseHp;

        public DotaHero(String name, String primaryAttribute, int baseHp) {
            this.name = name;
            this.primaryAttribute = primaryAttribute;
            this.baseHp = baseHp;
        }

        public int getMaxHp() {
            return baseHp;
        }

        @Override
        public String toString() {
            return name + ", атрибут: " + primaryAttribute + ", HP: " + getMaxHp();
        }
    }

    static class StrengthHero extends DotaHero {
        private int strength;

        public StrengthHero(String name, int baseHp, int strength) {
            super(name, "Сила", baseHp);
            this.strength = strength;
        }

        @Override
        public int getMaxHp() {
            return super.getMaxHp() + strength * 22;
        }

        @Override
        public String toString() {
            return super.toString() + ", сила: " + strength;
        }
    }

    static class AlchemistHero extends StrengthHero {
        private int greevilsGreedBonusGold;

        public AlchemistHero(String name, int baseHp, int strength, int greevilsGreedBonusGold) {
            super(name, baseHp, strength);
            this.greevilsGreedBonusGold = greevilsGreedBonusGold;
        }

        public String chemicalRage() {
            return "Chemical Rage активовано";
        }

        @Override
        public String toString() {
            return super.toString() + ", бонус золота: " + greevilsGreedBonusGold;
        }
    }
}
