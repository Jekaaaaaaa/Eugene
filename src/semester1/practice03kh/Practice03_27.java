package semester1.practice03kh;

public class Practice03_27 {
    public static void main(String[] args) {
        int number = 5;
        if (number > 0 || (10 / 0 == 0)){
            System.out.println("Умова виконана, аварійне ділення не викликалося!");
        }
    }// Ліва частина false тому права частина не обчислюється
}
