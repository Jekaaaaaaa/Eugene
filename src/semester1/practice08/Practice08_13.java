package semester1.practice08;

public class Practice08_13 {
    public static void main(String[] args) {
        UniversityStudent student = new UniversityStudent("Олена Коваль", 2006, "S-11", "ІПЗ", 2000);
        Professor professor = new Professor("Іван Бойко", 1982, "Доцент", 24);
        System.out.println(student + ", вік у 2026 році: " + student.getAge(2026));
        System.out.println(professor + ", вік у 2026 році: " + professor.getAge(2026));
    }

    static class Person {
        private String fullName;
        private int birthYear;

        public Person(String fullName, int birthYear) {
            this.fullName = fullName;
            this.birthYear = birthYear;
        }

        public int getAge(int currentYear) {
            return currentYear - birthYear;
        }

        @Override
        public String toString() {
            return fullName;
        }
    }

    static class UniversityStudent extends Person {
        private String studentId;
        private String major;
        private int scholarship;

        public UniversityStudent(String fullName, int birthYear, String studentId, String major, int scholarship) {
            super(fullName, birthYear);
            this.studentId = studentId;
            this.major = major;
            this.scholarship = scholarship;
        }

        @Override
        public String toString() {
            return super.toString() + ", " + studentId + ", " + major + ", стипендія: " + scholarship;
        }
    }

    static class Professor extends Person {
        private String academicTitle;
        private int publicationsCount;

        public Professor(String fullName, int birthYear, String academicTitle, int publicationsCount) {
            super(fullName, birthYear);
            this.academicTitle = academicTitle;
            this.publicationsCount = publicationsCount;
        }

        @Override
        public String toString() {
            return super.toString() + ", " + academicTitle + ", публікацій: " + publicationsCount;
        }
    }
}
