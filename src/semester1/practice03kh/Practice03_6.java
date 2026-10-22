package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть символ: ");
        char ch = scanner.nextLine().charAt(0);
        System.out.println("Символ: " + ch + "| Код символу: " + (int) ch);
    }
}
