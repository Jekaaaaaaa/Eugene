package semester1.homework06;

public class Asta {
    private String name = "Аста";
    private int hp = 1000;
    private int maxHp = 1000;
    private int antiMagicEnergy = 0;
    private int baseAttack = 120;
    private int defense = 35;
    private boolean isBlackFormActive = false;
    private boolean limitsUsed = false;
    private String[] skills = {"Удар Демоноборця", "Чорний Ураган", "Метеорит Демона", "Форма Чорного Демона"};

    public void showStatus() {
        System.out.print(name + " HP: [");
        for (int i = 0; i < 10; i++) {
            System.out.print(i < hp * 10 / maxHp ? "#" : ".");
        }
        System.out.println("] " + hp + "/" + maxHp + " (" + hp * 100 / maxHp + "%)");
        System.out.println("Антимагія: " + antiMagicEnergy + "/100");
        System.out.println("Чорна форма: " + (isBlackFormActive ? "активна" : "неактивна"));
    }

    public int basicSwordAttack() {
        if (!isAlive()) return 0;
        antiMagicEnergy = Math.min(100, antiMagicEnergy + 20);
        int damage = isBlackFormActive ? baseAttack * 2 : baseAttack;
        System.out.println("Удар мечем Демоноборця! Шкода: " + damage);
        return damage;
    }

    public int useSkill(int skillIndex) {
        if (!isAlive()) return 0;
        if (skillIndex < 0 || skillIndex >= skills.length) {
            System.out.println("Такої навички немає!");
            return 0;
        }
        if (skillIndex == 3 && isBlackFormActive) {
            System.out.println("Чорна форма вже активна!");
            return 0;
        }
        int[] costs = {25, 50, 75, 100};
        int[] damages = {220, 380, 550, 0};
        if (antiMagicEnergy < costs[skillIndex]) {
            System.out.println("Недостатньо енергії антимагії!");
            return 0;
        }
        antiMagicEnergy -= costs[skillIndex];
        System.out.println("Аста застосовує: " + skills[skillIndex]);
        if (skillIndex == 3) {
            isBlackFormActive = true;
            hp = Math.min(maxHp, hp + 300);
            System.out.println("Чорна форма активована! Відновлено до 300 HP, силу атак подвоєно.");
            return 0;
        }
        int damage = isBlackFormActive ? damages[skillIndex] * 2 : damages[skillIndex];
        System.out.println("Завдано шкоди: " + damage);
        return damage;
    }

    public void takeDamage(int incomingDmg) {
        if (!isAlive()) return;
        int damage = Math.max(15, incomingDmg - defense);
        hp = Math.max(0, hp - damage);
        System.out.println("Аста отримує " + damage + " шкоди.");
    }

    public void pushLimits() {
        if (isAlive() && hp < maxHp / 4 && !limitsUsed) {
            limitsUsed = true;
            hp = Math.min(maxHp, hp + 150);
            antiMagicEnergy = Math.min(100, antiMagicEnergy + 50);
            System.out.println("Моя магія — ніколи не здаватися! +150 HP та до +50 антимагії!");
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getHp() { return hp; }
    public int getAntiMagicEnergy() { return antiMagicEnergy; }
    public boolean isBlackFormActive() { return isBlackFormActive; }
}
