package semester1.practice07;

public class Practice07_2 {
    public static void main(String[] args) {
        Student first = new Student("Олена", 19, 4.8);
        Student second = new Student("Андрій", 10, 7.0);
        first.printStudent();
        second.printStudent();
    }

    static class Student {
        private String name;
        private int age;
        private double gpa;

        public Student(String name, int age, double gpa) {
            this.name = name;
            this.age = age >= 15 && age <= 80 ? age : 18;
            this.gpa = gpa >= 0.0 && gpa <= 5.0 ? gpa : 0.0;
        }

        public boolean isHonorStudent() {
            return gpa >= 4.5;
        }

        public void printStudent() {
            String status = isHonorStudent() ? "Відмінник" : "Звичайний студент";
            System.out.println(name + ", вік: " + age + ", середній бал: " + gpa + ", " + status);
        }
    }
}
