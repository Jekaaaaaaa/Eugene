package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер квитка: ");
        int ticket = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть повне ім'я студента: ");
        String fullName = scanner.nextLine();
        System.out.print("Введіть спеціальність: ");
        String spec = scanner.nextLine();
        System.out.print("Студент: " + fullName + ", квиток №" + ticket + ", спеціальність: " + spec);
    }
}
