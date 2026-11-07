package semester1.practice08;

public class Practice08_34 {
    public static void main(String[] args) {
        int[] grades = {70, 90, 100};
        System.out.println(new GradeSheet("Іван", grades));
        System.out.println(new WeightedGradeSheet("Іван", grades, new double[]{1.0, 2.0, 3.0}));
    }

    static class GradeSheet {
        private String studentName;
        protected int[] grades;

        public GradeSheet(String studentName, int[] grades) {
            this.studentName = studentName;
            this.grades = grades.clone();
        }

        public double calculateScore() {
            double sum = 0.0;
            for (int grade : grades) {
                sum += grade;
            }
            return grades.length == 0 ? 0.0 : sum / grades.length;
        }

        @Override
        public String toString() {
            return String.format("%s: %.2f бала", studentName, calculateScore());
        }
    }

    static class WeightedGradeSheet extends GradeSheet {
        private double[] weights;

        public WeightedGradeSheet(String studentName, int[] grades, double[] weights) {
            super(studentName, grades);
            if (grades.length != weights.length) {
                throw new IllegalArgumentException("Кожній оцінці має відповідати вага");
            }
            this.weights = weights.clone();
        }

        @Override
        public double calculateScore() {
            double sum = 0.0;
            double totalWeight = 0.0;
            for (int i = 0; i < grades.length; i++) {
                sum += grades[i] * weights[i];
                totalWeight += weights[i];
            }
            return totalWeight == 0.0 ? 0.0 : sum / totalWeight;
        }

        @Override
        public String toString() {
            return "Зважений бал — " + super.toString();
        }
    }
}
