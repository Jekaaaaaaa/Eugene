package semester1.practice07;

public class Practice07_17 {
    public static void main(String[] args) {
        MathOperations operations = new MathOperations();
        System.out.println(operations.add(2, 3));
        System.out.println(operations.add(2.5, 3.4));
        System.out.println(operations.add(2, 3, 4));
        System.out.println(operations.add("Привіт,", "світе!"));
        System.out.println(operations.multiply(3, 4));
        System.out.println(operations.multiply(2.5, 4.0));
        System.out.println(operations.multiply("Java ", 3));
    }

    static class MathOperations {
        public int add(int a, int b) {
            return a + b;
        }

        public double add(double a, double b) {
            return a + b;
        }

        public int add(int a, int b, int c) {
            return a + b + c;
        }

        public String add(String a, String b) {
            return a + " " + b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public double multiply(double a, double b) {
            return a * b;
        }

        public String multiply(String text, int times) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < times; i++) {
                result.append(text);
            }
            return result.toString();
        }
    }
}
