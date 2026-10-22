package semester1.practice02kh;

import java.sql.SQLOutput;

public class Practice02_40 {
    public static void main(String[] args) {
        double principal = 10000.0;
        double rate = 12.0;
        int year = 3;
        double finalAmount = principal * Math.pow(1 + rate / 100, year);
        double profit = finalAmount - principal;
        System.out.println("+------------------------------------+");
        System.out.println("|     ДЕПОЗИТНИЙ КАЛЬКУЛЬАТОР        |");
        System.out.println("+------------------------------------+");
        System.out.println("Початкова сума: " + principal + " грн");
        System.out.println("Термін: " + year + " роки " + "під " + rate + "% річних");
        System.out.println("Підсумкова сума: " + finalAmount + " грн");
        System.out.println("Чистий прибуток: " + profit + " грн");
        System.out.println("+------------------------------------+");
    }
}
