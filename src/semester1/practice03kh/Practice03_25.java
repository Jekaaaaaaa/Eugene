package semester1.practice03kh;
public class Practice03_25 {
    public static void main(String[] args) {
        int x = 10;
        int divisor = 2;
        if (divisor != 0 && (x / divisor > 1)) {
            System.out.println("Успішне ділення");
        }else {
            System.out.println("Ділення безпечного пропущено завдяки short-circuit!");
        }
    }
}
