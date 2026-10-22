package semester1.practice02kh;

public class Practice02_35 {
    public static void main(String[] args) {
        double dayTemp = 18.5;
        double nightTemp = -3.2;
        double differcence = Math.abs(dayTemp - nightTemp);
        double maxTemp = Math.max(dayTemp, nightTemp);
        double minTemp = Math.min(dayTemp, nightTemp);
        System.out.println("Перепад температури: " + differcence);
        System.out.println("Максимальна температура: " + dayTemp);
        System.out.println("Мінімальна температура: " + nightTemp);
    }
}
