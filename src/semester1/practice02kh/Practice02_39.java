package semester1.practice02kh;

public class Practice02_39 {
    public static void main(String[] args) {
        int min = -10;
        int max = 35;
        int randomTemp = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Погода на завтра: " + randomTemp + "°C");
    }
}
