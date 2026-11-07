package semester1.practice08;

import semester1.practice08.Practice08_9.Developer;

public class Practice08_38 {
    public static void main(String[] args) {
        TeamLead lead = new TeamLead("Марія", 54000.0, "Java", 3);
        lead.addTeamMember(new Developer("Іван", 35000.0, "Java"));
        lead.addTeamMember(new Developer("Олена", 36000.0, "Kotlin"));
        System.out.println(lead);
    }

    static class TeamLead extends Developer {
        private Developer[] teamMembers;
        private int memberCount;

        public TeamLead(String name, double salary, String programmingLanguage, int capacity) {
            super(name, salary, programmingLanguage);
            this.teamMembers = new Developer[capacity];
        }

        public void addTeamMember(Developer dev) {
            if (dev != null && memberCount < teamMembers.length) {
                teamMembers[memberCount++] = dev;
            }
        }

        public double getTotalTeamBudget() {
            double budget = salary;
            for (int i = 0; i < memberCount; i++) {
                budget += teamMembers[i].salary;
            }
            return budget;
        }

        @Override
        public String toString() {
            StringBuilder info = new StringBuilder("Тімлід: ").append(super.toString());
            info.append(", бюджет: ").append(getTotalTeamBudget()).append(" грн");
            for (int i = 0; i < memberCount; i++) {
                info.append(System.lineSeparator()).append("- ").append(teamMembers[i]);
            }
            return info.toString();
        }
    }
}
