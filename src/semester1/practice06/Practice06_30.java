package semester1.practice06;

import java.util.Locale;

public class Practice06_30 {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Денис");
        person1.setAge(19);
        Person person2 = new Person();
        person2.setName("Олена");
        person2.setAge(25);
        person2.setAge(150);
        person1.printSummary();
        person2.printSummary();
    }

    static class Person {
        private String name;
        private int age;
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void setAge(int age) {
            if (age >= 0 && age <= 120) {
                this.age = age;
            } else {
                System.out.println("Некоректний вік: " + age);
            }
        }
    
        public void printSummary() {
            System.out.println("Ім'я: " + name + "; вік: " + age);
        }
    }
}
