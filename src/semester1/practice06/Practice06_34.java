package semester1.practice06;

import java.util.Locale;

public class Practice06_34 {
    public static void main(String[] args) {
        ArrayStats stats = new ArrayStats();
        stats.setNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println("Парних: " + stats.countEvens() + "; непарних: " + stats.countOdds()
                + "; сума: " + stats.calculateSum());
    }

    static class ArrayStats {
        private int[] numbers = new int[0];
    
        public void setNumbers(int[] nums) {
            this.numbers = nums == null ? new int[0] : nums.clone();
        }
    
        public int countEvens() {
            int count = 0;
            for (int number : numbers) {
                if (number % 2 == 0) {
                    count++;
                }
            }
            return count;
        }
    
        public int countOdds() {
            return numbers.length - countEvens();
        }
    
        public int calculateSum() {
            int sum = 0;
            for (int number : numbers) {
                sum = Math.addExact(sum, number);
            }
            return sum;
        }
    }
}
