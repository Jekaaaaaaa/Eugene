package semester1.practice06;

import java.util.Locale;

public class Practice06_33 {
    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook();
        gradeBook.setData("Денис", new int[]{85, 92, 78, 96, 65});
        System.out.println(gradeBook.getStudentName() + ": середній бал " + gradeBook.getAverage()
                + "; максимум " + gradeBook.getHighestGrade() + "; мінімум " + gradeBook.getLowestGrade());
    }

    static class GradeBook {
        private String studentName;
        private int[] grades = new int[0];
    
        public void setData(String name, int[] g) {
            this.studentName = name;
            this.grades = g == null ? new int[0] : g.clone();
        }
    
        public double getAverage() {
            if (grades.length == 0) {
                return 0.0;
            }
            long sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.length;
        }
    
        public int getHighestGrade() {
            if (grades.length == 0) {
                return 0;
            }
            int max = grades[0];
            for (int grade : grades) {
                if (grade > max) {
                    max = grade;
                }
            }
            return max;
        }
    
        public int getLowestGrade() {
            if (grades.length == 0) {
                return 0;
            }
            int min = grades[0];
            for (int grade : grades) {
                if (grade < min) {
                    min = grade;
                }
            }
            return min;
        }
    
        public String getStudentName() {
            return studentName;
        }
    }
}
