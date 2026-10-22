package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть x: ");
        int x = scanner.nextInt();
        System.out.print("Введіть y: ");
        int y = scanner.nextInt();
        int max = (x > y) ? x : y;
        System.out.println("Більше число: " + max);
    }
}
