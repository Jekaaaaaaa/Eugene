package semester1.homework02;

public class Task5RpgHero {
    public static void main(String[] args) {
        String heroName = "Артур Світлоносний";
        String heroClass = "Лицар";

        int strength = (int) (Math.random() * (18 - 8 + 1)) + 8;
        int agility = (int) (Math.random() * (18 - 8 + 1)) + 8;
        int intelligence = (int) (Math.random() * (18 - 8 + 1)) + 8;

        int maxHp = strength * 10 + agility * 2;
        int mana = intelligence * 15;
        int armor = agility / 2;

        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;
        int playerAttack = dice1 + dice2 + strength;
        final int MONSTER_ATTACK = 22;
        boolean isPlayerVictory = playerAttack > MONSTER_ATTACK;

        System.out.println("/**************************************************\\");
        System.out.println("|                 ПАСПОРТ ГЕРОЯ RPG                |");
        System.out.println("\\**************************************************/");
        System.out.println("Ім'я персонажа:          " + heroName);
        System.out.println("Клас:                    " + heroClass);

        System.out.println("\n[ХАРАКТЕРИСТИКИ]");
        System.out.println("Сила (STR):              " + strength);
        System.out.println("Спритність (AGI):        " + agility);
        System.out.println("Інтелект (INT):          " + intelligence);

        System.out.println("\n[ПОХІДНІ АТРИБУТИ]");
        System.out.println("Очки здоров'я (HP):      " + maxHp);
        System.out.println("Очки мани (MP):          " + mana);
        System.out.println("Клас броні (Armor):      " + armor);

        System.out.println("\n[СИМУЛЯЦІЯ БОЮ]");
        System.out.println("Кидок кубиків гравця:    " + dice1 + " + " + dice2
                + " (бонус сили: +" + strength + ")");
        System.out.println("Загальна атака гравця:   " + playerAttack);
        System.out.println("Сила удару монстра:      " + MONSTER_ATTACK);
        System.out.println("Чи переміг гравець?      " + isPlayerVictory);
        System.out.println("\\**************************************************/");
    }
}
