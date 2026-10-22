package semester1.practice03kh;

import java.util.Scanner;

public class Practice03_39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    System.out.print("Введіть команду (start/pause/stop/exit): ");
    String command = scanner.nextLine().trim();
    // == порівнює посилання, а не вміст рядків; для тексту використовуйте equals().
        System.out.println("command == \"start\": "+(command =="start"));
        if(command.equalsIgnoreCase("start"))
    {
        System.out.println("Система успішно запущена! (перевірка equalsIgnoreCase)");
    }
        switch(command.toLowerCase())
    {
        case "start" -> System.out.println("Обробка команди start.");
        case "pause" -> System.out.println("Систему призупинено.");
        case "stop" -> System.out.println("Систему зупинено.");
        case "exit" -> System.out.println("Вихід із програми.");
        default -> System.out.println("Невідома команда.");
    }
}
}
