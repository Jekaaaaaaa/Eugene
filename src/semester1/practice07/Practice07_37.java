package semester1.practice07;

public class Practice07_37 {
    public static void main(String[] args) {
        Hero knight = new Hero("Лицар", 80, 23, 8);
        Hero orc = new Hero("Орк", 95, 20, 6);
        while (knight.isAlive() && orc.isAlive()) {
            knight.attack(orc);
            if (orc.isAlive()) {
                orc.attack(knight);
            }
        }
        Hero winner = knight.isAlive() ? knight : orc;
        System.out.println("Переможець: " + winner.getName());
    }

    static class Hero {
        private String name;
        private int health;
        private int attackPower;
        private int defense;

        public Hero(String name, int health, int attackPower, int defense) {
            this.name = name;
            this.health = health;
            this.attackPower = attackPower;
            this.defense = defense;
        }

        public void attack(Hero target) {
            int damage = Math.max(1, this.attackPower - target.defense);
            target.health = Math.max(0, target.health - damage);
            System.out.println(name + " вдарив героя " + target.name + " на " + damage
                    + ". Залишилося HP: " + target.health);
        }

        public boolean isAlive() {
            return this.health > 0;
        }

        public String getName() {
            return name;
        }
    }
}
