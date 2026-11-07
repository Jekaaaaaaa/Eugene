package semester1.practice09;

public class Practice09_37 {
    public static void main(String[] args) {
        RaidParty party = new RaidParty("Світанок", 3);
        party.addMember(new ArcaneMage("Маг", 60, 80, 60));
        System.out.println("Без танка: " + party.isReady(200));
        party.addMember(new TankWarrior("Вартовий", 200, 40));
        System.out.println(party);
        System.out.println("Із танком: " + party.isReady(200));
    }

    static abstract class AbstractHeroUnit {
        private final String name;
        protected int hp;

        public AbstractHeroUnit(String name, int hp) {
            this.name = name;
            this.hp = hp;
        }

        public abstract int getCombatPower();

        public abstract String getRole();
    }

    static class TankWarrior extends AbstractHeroUnit {
        private int armor;

        public TankWarrior(String name, int hp, int armor) {
            super(name, hp);
            this.armor = armor;
        }

        @Override
        public int getCombatPower() {
            return hp + 2 * armor;
        }

        @Override
        public String getRole() {
            return "Tank";
        }
    }

    static class ArcaneMage extends AbstractHeroUnit {
        private int intelligence;
        private int spellPower;

        public ArcaneMage(String name, int hp, int intelligence, int spellPower) {
            super(name, hp);
            this.intelligence = intelligence;
            this.spellPower = spellPower;
        }

        @Override
        public int getCombatPower() {
            return intelligence + 2 * spellPower;
        }

        @Override
        public String getRole() {
            return "Mage";
        }
    }

    static class RaidParty {
        private final String guildName;
        private final AbstractHeroUnit[] members;
        private int memberCount;

        public RaidParty(String guildName, int capacity) {
            this.guildName = guildName;
            this.members = new AbstractHeroUnit[capacity];
        }

        public void addMember(AbstractHeroUnit member) {
            if (member != null && memberCount < members.length) {
                members[memberCount++] = member;
            }
        }

        public boolean isReady(int dungeonDifficulty) {
            boolean hasTank = false;
            long power = 0;
            for (int i = 0; i < memberCount; i++) {
                hasTank |= "Tank".equals(members[i].getRole());
                power += members[i].getCombatPower();
            }
            return hasTank && power > dungeonDifficulty;
        }

        @Override
        public String toString() {
            return guildName + ", учасників: " + memberCount;
        }
    }
}
