package semester1.practice03kh;
import java.util.Scanner;
public class Practice03_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваш зрість (м): ");
        double height = scanner.nextDouble();
        System.out.print("Ваша вага (кг): ");
        double weight = scanner.nextDouble();
        double bmi = weight / (height * height);
        double roundedBmi = Math.round(bmi * 100.0) / 100.0;
        System.out.print("розрахований BMI: " + roundedBmi);

    }
}
