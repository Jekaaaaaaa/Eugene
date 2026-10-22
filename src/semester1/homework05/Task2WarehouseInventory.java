package semester1.homework05;

import java.util.Locale;

public class Task2WarehouseInventory {
    public static void main(String[] args) {
        String[] items = {"Ноутбук", "Смартфон", "Бездротові навушники", "Механічна клавіатура", "Монітор 27\""};
        int[] quantities = {8, 3, 25, 4, 12};
        double[] prices = {28500.0, 19200.0, 1850.0, 3100.0, 9400.0};
        double[] totalValues = new double[items.length];
        double total = 0;
        int maxIndex = 0;
        System.out.println("=== ЗВІТ СКЛАДУ ЕЛЕКТРОНІКИ ===");
        System.out.println("№ | Назва товару | Кількість | Ціна за шт. | Сумарна вартість");
        for (int i = 0; i < items.length; i++) {
            totalValues[i] = quantities[i] * prices[i];
            total += totalValues[i];
            if (totalValues[i] > totalValues[maxIndex]) maxIndex = i;
            System.out.printf(Locale.US, "%d | %-22s | %3d | %10.2f | %12.2f грн%n",
                    i + 1, items[i], quantities[i], prices[i], totalValues[i]);
        }
        System.out.printf(Locale.US, "Загальна вартість складу: %.2f грн%n", total);
        System.out.printf(Locale.US, "Найбільший капітал у товарі: %s (%.2f грн)%n", items[maxIndex], totalValues[maxIndex]);
        System.out.println("ДЕФІЦИТНІ ПОЗИЦІЇ (менше 5 шт.):");
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] < 5) {
                System.out.println("- " + items[i] + " (залишилось: " + quantities[i] + ") -> Терміново замовити постачальнику!");
            }
        }
    }
}
