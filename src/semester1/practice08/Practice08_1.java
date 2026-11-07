package semester1.practice08;

public class Practice08_1 {
    public static void main(String[] args) {
        Student student = new Student("Олена", 3, 91.5);
        System.out.println(student);
        student.setCourse(9);
        student.setGpa(-5.0);
        System.out.println(student);
    }

    static class Student {
        private String name;
        private int course;
        private double gpa;

        public Student(String name, int course, double gpa) {
            setName(name);
            setCourse(course);
            setGpa(gpa);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course >= 1 && course <= 6 ? course : 1;
        }

        public double getGpa() {
            return gpa;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa >= 0.0 && gpa <= 100.0 ? gpa : 60.0;
        }

        @Override
        public String toString() {
            return "Student{name='" + name + "', course=" + course + ", gpa=" + gpa + "}";
        }
    }
}
