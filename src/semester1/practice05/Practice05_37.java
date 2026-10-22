package semester1.practice05;

public class Practice05_37 {
    public static void main(String[] args) {
        String[][] weekSchedule = new String[5][];
        weekSchedule[0] = new String[]{"Вища математика", "Основи програмування", "Фізика"};
        weekSchedule[1] = new String[]{"Англійська мова", "Історія України"};
        weekSchedule[2] = new String[]{"Основи програмування", "Основи програмування", "Бази даних", "Фізвиховання"};
        weekSchedule[3] = new String[]{"Дискретна математика"};
        weekSchedule[4] = new String[]{"Філософія", "Основи алгоритмізації", "Практикум"};
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця"};
        for (int i = 0; i < weekSchedule.length; i++) {
            System.out.println(days[i] + ", кількість пар: " + weekSchedule[i].length);
            for (int j = 0; j < weekSchedule[i].length; j++) {
                System.out.println((j + 1) + ". " + weekSchedule[i][j]);
            }
        }
    }
}
