package semester1.practice05;

public class Practice05_14 {
    public static void main(String[] args) {
        int[] salaries = {18000, 25000, 32000, 15000, 41000, 29000};
        int sum = 0;
        for (int salary : salaries) {
            sum += salary;
        }
        double average = (double) sum / salaries.length;
        System.out.println("Середня зарплата: " + average);
        for (int salary : salaries) {
            if (salary > average) {
                System.out.println(salary);
            }
        }
    }
}
