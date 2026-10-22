package semester1.practice06;

import java.util.Locale;

public class Practice06_8 {
    public static void main(String[] args) {
        Student first = new Student();
        first.name = "Іван";
        Student second = first;
        second.name = "Петро";
        // first і second посилаються на один об'єкт, тому зміна через second видима через first.
        System.out.println(first.name);
    }

    static class Student {
        public String name;
        public int age;
        public double gpa;
    }
}
