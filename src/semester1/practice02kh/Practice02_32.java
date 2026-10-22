package semester1.practice02kh;

public class Practice02_32 {
    public static void main(String[] args) {
        int year = 2024;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeapYear);
    }
}
