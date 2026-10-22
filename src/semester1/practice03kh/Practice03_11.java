package semester1.practice03kh;

import java.util.Scanner;

public class Practice03_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть вік");
        int age = scanner.nextInt();
        if (age < 0 || age > 120) {
            System.out.println("Некоректний вік");
        }else if (age <= 12) {
            System.out.println("Дитина");
        }else if (age <= 17) {
            System.out.println("Підліток");
        }else if (age <= 64) {
            System.out.println("Дорослий");
        }else {
            System.out.println("Пенісонер");
        }
    }
}
