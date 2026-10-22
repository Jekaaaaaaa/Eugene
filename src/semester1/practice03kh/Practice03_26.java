package semester1.practice03kh;

public class Practice03_26 {
    public static void main(String[] args) {
        int counter1 = 0;
        int counter2 = 0;
        boolean b1 = false && (++counter1 > 0);
        boolean b2 = false & (++counter2 > 0);
        System.out.println("counter1 = " + counter1);
        System.out.println("counter2 = " + counter2);
    }
}
