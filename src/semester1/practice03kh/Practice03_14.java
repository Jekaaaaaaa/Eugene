package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть X: ");
        double x = scanner.nextDouble();
        System.out.print("Введыть Y: ");
        double y = scanner.nextDouble();
        if (x == 0 && y == 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться в початку координат.");
        }else if (x == 0) {
            System.out.println("Точка (" + x + "; " + y + ") лежить на осі Y.");
        }else if (y == 0) {
            System.out.println("Точка (" + x + "; " + y + ") лежить на осі X.");
        }else if (x > 0 && y > 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у I чверті.");
        }else if (x < 0 && y > 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у II чверті.");
        }else if (x < 0 && y < 0) {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у III чверті.");
        }else {
            System.out.println("Точка (" + x + "; " + y + ") знаходиться у IV чверті.");
        }
    }
}
