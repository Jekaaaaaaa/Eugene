package semester1.practice05;

public class Practice05_10 {
    public static void main(String[] args) {
        int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int value : data) {
            if (value > 0) {
                positive++;
            } else if (value < 0) {
                negative++;
            } else {
                zero++;
            }
        }
        System.out.println("Додатних: " + positive + ", від'ємних: " + negative + ", нулів: " + zero);
    }
}
