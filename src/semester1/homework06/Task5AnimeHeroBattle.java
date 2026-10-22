package semester1.homework06;

import java.util.Scanner;

public class Task5AnimeHeroBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Asta asta = new Asta();
        int bossHp = 1200;
        int round = 1;
        System.out.println("=== АРЕНА КОРОЛІВСТВА КОНЮШИНИ ===");
        System.out.println("Супротивник: Патри, Маг Світла (1200 HP)");

        while (asta.isAlive() && bossHp > 0) {
            System.out.println("\n--- Раунд " + round + " ---");
            asta.showStatus();
            System.out.println("Патри: HP " + bossHp + "/1200");
            System.out.println("1 - Удар мечем (+20 антимагії)");
            System.out.println("2 - Застосувати суперздібність");
            System.out.println("3 - Захисна стійка (шкода боса зменшується вдвічі)");
            System.out.println("4 - Переглянути статус");
            System.out.println("0 - Завершити гру");
            System.out.print("Ваш вибір: ");
            if (!scanner.hasNext()) break;
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Введіть номер дії!");
                continue;
            }
            int choice = scanner.nextInt();
            if (choice == 0) break;
            int damage = 0;
            boolean defending = false;
            switch (choice) {
                case 1:
                    damage = asta.basicSwordAttack();
                    break;
                case 2:
                    System.out.println("1 - Удар Демоноборця (25 енергії, 220 шкоди)");
                    System.out.println("2 - Чорний Ураган (50 енергії, 380 шкоди)");
                    System.out.println("3 - Метеорит Демона (75 енергії, 550 шкоди)");
                    System.out.println("4 - Форма Чорного Демона (100 енергії, +300 HP)");
                    System.out.print("Оберіть навичку: ");
                    if (!scanner.hasNext()) { scanner.close(); return; }
                    if (!scanner.hasNextInt()) {
                        scanner.next();
                        System.out.println("Введіть номер навички!");
                        continue;
                    }
                    int skill = scanner.nextInt() - 1;
                    int energyBefore = asta.getAntiMagicEnergy();
                    damage = asta.useSkill(skill);
                    if (energyBefore == asta.getAntiMagicEnergy()) continue;
                    break;
                case 3:
                    defending = true;
                    System.out.println("Аста прикривається мечем!");
                    break;
                case 4:
                    asta.showStatus();
                    continue;
                default:
                    System.out.println("Такої дії немає!");
                    continue;
            }
            bossHp = Math.max(0, bossHp - damage);
            if (bossHp == 0) break;
            int bossDamage = 120;
            if (defending) bossDamage /= 2;
            System.out.println("Патри атакує Променями Покарання Світла!");
            asta.takeDamage(bossDamage);
            asta.pushLimits();
            round++;
        }
        System.out.println();
        if (bossHp == 0) {
            System.out.println("Перемога! Аста здолав Патри!");
        } else if (!asta.isAlive()) {
            System.out.println("Поразка. Патри переміг цього разу.");
        } else {
            System.out.println("Гру завершено.");
        }
        asta.showStatus();
        System.out.println("Патри: HP " + bossHp + "/1200");
        scanner.close();
    }
}
