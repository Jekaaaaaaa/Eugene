package semester1.practice03kh;

import java.util.Scanner;

public class Practice03_37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Спосіб доставки (1 — Самовивіз, 2 — Кур'єр, 3 — Поштомат): ");
        int delivery = scanner.nextInt();
        double weight = 0;
        if (delivery == 2) {
            System.out.print("Вага товару (кг): ");
            weight = scanner.nextDouble();
        }
        final double itemWeight = weight;
        int cost = switch (delivery) {
            case 1 -> 0;
            case 2 -> {
                if (itemWeight > 5) {
                    yield 150;
                } else {
                    yield 90;
                }
            }
            case 3 -> 60;
            default -> -1;
        };
        if (cost < 0) {
            System.out.println("Некоректний вибір доставки.");
        } else {
            System.out.println("Вартість доставки: " + cost + " грн");
        }
    }
}