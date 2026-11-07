package semester1.practice08;

public class Practice08_9 {
    public static void main(String[] args) {
        System.out.println(new Employee("Олена", 20000.0));
        System.out.println(new Developer("Іван", 35000.0, "Java"));
    }

    static class Employee {
        private String name;
        protected double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name + ", зарплата: " + salary + " грн";
        }
    }

    static class Developer extends Employee {
        private String programmingLanguage;

        public Developer(String name, double salary, String programmingLanguage) {
            super(name, salary);
            this.programmingLanguage = programmingLanguage;
        }

        @Override
        public String toString() {
            return super.toString() + ", мова: " + programmingLanguage;
        }
    }
}
