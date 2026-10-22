package semester1.practice06;

import java.util.Locale;

public class Practice06_13 {
    public static void main(String[] args) {
        Player player = new Player();
        player.nickname = "Лицар";
        player.takeDamage(40);
        System.out.println("Після шкоди: " + player.health);
        player.heal(20);
        System.out.println("Після лікування: " + player.health);
        player.heal(100);
        System.out.println("Ліміт здоров'я: " + player.health);
        player.takeDamage(150);
        System.out.println("Здоров'я після смертельної шкоди: " + player.health);
    }

    static class Player {
        public String nickname;
        public int health = 100;
    
        public void takeDamage(int damage) {
            if (damage < 0) {
                System.out.println("Шкода не може бути від'ємною.");
                return;
            }
            health = Math.max(0, health - damage);
            if (health == 0) {
                System.out.println(nickname + " загинув!");
            }
        }
    
        public void heal(int amount) {
            if (amount < 0) {
                System.out.println("Лікування не може бути від'ємним.");
                return;
            }
            health = (int) Math.min(100L, (long) health + amount);
        }
    }
}
