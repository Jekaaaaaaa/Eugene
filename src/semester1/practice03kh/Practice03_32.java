package semester1.practice03kh;

import java.util.Scanner;

public class Practice03_32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("PIN правильний? true / false: ");
        boolean isPinCorrect = scanner.nextBoolean();
        System.out.print("Картка активна? true / false: ");
        boolean isCardActive = scanner.nextBoolean();
        System.out.print("Баланс, грн: ");
        double balance = scanner.nextDouble();
        System.out.print("Сума зняття, грн: ");
        double amount = scanner.nextDouble();
        System.out.print("Добовий ліміт перевищено? true / false: ");
        boolean isDailyLimitExceeded = scanner.nextBoolean();
        boolean hasSufficientBalance = balance >= amount;
        boolean allowed = isPinCorrect && isCardActive && hasSufficientBalance
                && !isDailyLimitExceeded;
        System.out.println("Транзакція дозволена: " + allowed);
        scanner.close();
    }
}
