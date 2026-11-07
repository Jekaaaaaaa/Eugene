package semester1.practice08;

public class Practice08_31 {
    public static void main(String[] args) {
        PostgraduateStudent student = new PostgraduateStudent(9, "demo@example.com", "ІПЗ-31", 91.5,
                "Аналіз алгоритмів", "Іван Коваль");
        System.out.println(student);
        System.out.println("Допуск: " + student.canDefend());
    }

    static class User {
        private int id;
        private String email;

        public User(int id, String email) {
            this.id = id;
            this.email = email;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", пошта: " + email;
        }
    }

    static class StudentUser extends User {
        private String groupCode;
        private double gpa;

        public StudentUser(int id, String email, String groupCode, double gpa) {
            super(id, email);
            this.groupCode = groupCode;
            this.gpa = gpa;
        }

        public double getGpa() {
            return gpa;
        }

        @Override
        public String toString() {
            return super.toString() + ", група: " + groupCode + ", бал: " + gpa;
        }
    }

    static class PostgraduateStudent extends StudentUser {
        private String thesisTopic;
        private String supervisorName;

        public PostgraduateStudent(int id, String email, String groupCode, double gpa, String thesisTopic, String supervisorName) {
            super(id, email, groupCode, gpa);
            this.thesisTopic = thesisTopic;
            this.supervisorName = supervisorName;
        }

        public boolean canDefend() {
            return getGpa() >= 85.0 && thesisTopic != null && !thesisTopic.trim().isEmpty();
        }

        @Override
        public String toString() {
            return super.toString() + ", тема: " + thesisTopic + ", керівник: " + supervisorName;
        }
    }
}
