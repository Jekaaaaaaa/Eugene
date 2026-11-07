package semester1.practice09;

public class Practice09_22 {
    public static void main(String[] args) {
        UniversityCourse course = new UniversityCourse("Java", 4);
        course.addModule(new CourseModule("Класи", 10, 20, 40.0));
        course.addModule(new CourseModule("ООП", 10, 20, 60.0));
        System.out.println(course);
        System.out.println("Кредити ЄКТС: " + course.getEctsCredits());
        System.out.println("Максимум 100 балів: " + course.hasFullScore());
    }

    static class CourseModule {
        private final String topic;
        private final int lectureHours;
        private final int practiceHours;
        private double maxScore;

        public CourseModule(String topic, int lectureHours, int practiceHours, double maxScore) {
            this.topic = topic;
            this.lectureHours = lectureHours;
            this.practiceHours = practiceHours;
            this.maxScore = maxScore;
        }

        public int getTotalHours() {
            return lectureHours + practiceHours;
        }

        public double getMaxScore() {
            return maxScore;
        }
    }

    static class UniversityCourse {
        private final String courseTitle;
        private final CourseModule[] modules;
        private int moduleCount;

        public UniversityCourse(String courseTitle, int capacity) {
            this.courseTitle = courseTitle;
            this.modules = new CourseModule[capacity];
        }

        public void addModule(CourseModule module) {
            if (module != null && moduleCount < modules.length) {
                modules[moduleCount++] = module;
            }
        }

        public double getEctsCredits() {
            long hours = 0;
            for (int i = 0; i < moduleCount; i++) {
                hours += modules[i].getTotalHours();
            }
            return hours / 30.0;
        }

        public boolean hasFullScore() {
            double score = 0.0;
            for (int i = 0; i < moduleCount; i++) {
                score += modules[i].getMaxScore();
            }
            return Math.abs(score - 100.0) < 1e-9;
        }

        @Override
        public String toString() {
            return courseTitle + ", модулів: " + moduleCount;
        }
    }
}
