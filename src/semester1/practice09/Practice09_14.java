package semester1.practice09;

public class Practice09_14 {
    public static void main(String[] args) {
        HeroCharacter hero = new HeroCharacter("Лицар", 20);
        hero.equip(new WeaponItem("Меч", 15, 20));
        for (int hit = 0; hit < 3; hit++) {
            System.out.println("Шкода: " + hero.attack());
        }
        hero.unequip();
    }

    static class WeaponItem {
        private final String name;
        private final int bonusDamage;
        private int durability;

        public WeaponItem(String name, int bonusDamage, int durability) {
            this.name = name;
            this.bonusDamage = bonusDamage;
            this.durability = Math.max(0, Math.min(100, durability));
        }

        public int useWeapon() {
            if (durability == 0) {
                return 0;
            }
            durability = Math.max(0, durability - 10);
            return bonusDamage;
        }

        @Override
        public String toString() {
            return name + ", міцність: " + durability;
        }
    }

    static class HeroCharacter {
        private final String nickname;
        private int baseStrength;

        public HeroCharacter(String nickname, int baseStrength) {
            this.nickname = nickname;
            this.baseStrength = baseStrength;
        }

        private WeaponItem equippedWeapon;

        public void equip(WeaponItem newWeapon) {
            equippedWeapon = newWeapon;
            System.out.println(nickname + " екіпірує: " + newWeapon);
        }

        public void unequip() {
            equippedWeapon = null;
        }

        public int attack() {
            return baseStrength + (equippedWeapon == null ? 0 : equippedWeapon.useWeapon());
        }
    }
}
