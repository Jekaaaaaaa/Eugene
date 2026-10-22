package semester1.practice05;

import java.util.Arrays;

public class Practice05_2 {
    public static void main(String[] args) {
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        System.out.println("Кількість: " + days.length);
        System.out.println(days[0] + ", " + days[days.length - 1]);
        days[5] = "Вихідний (Сб)";
        days[6] = "Вихідний (Нд)";
        System.out.println(Arrays.toString(days));
    }
}
