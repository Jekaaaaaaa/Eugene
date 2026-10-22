package semester1.practice05;

public class Practice05_11 {
    public static void main(String[] args) {
        int[] numbers = {4, 7, -3, 12, 0, 9, 6, 15, -2, 8};
        int evenCount = 0;
        int oddSum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddSum += number;
            }
        }
        System.out.println("Парних: " + evenCount + ", сума непарних: " + oddSum);
    }
}
