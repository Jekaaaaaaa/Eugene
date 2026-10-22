package semester1.practice03kh;

import java.util.Scanner;

public class Practice03_31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число n: ");
        int n = scanner.nextInt();
        boolean isEvenBitwise = (n & 1) == 0;
        boolean isEvenModule = n % 2 == 0;
        System.out.println("Перевірка через &: " + isEvenBitwise);
        System.out.println("Перевірка через %: " + isEvenModule);
        System.out.println("Якщо останній біт 0 - число парне");
        System.out.println("Якщо останній біт 1 - число непарне");
        System.out.println("Результат n & 1 = " + (n & 1));
        scanner.close();
        //***(n & 1) == 0 перевіряє парність через біти
        //n % 2 == 0 перевіряє остачу від ділення
    }
}
