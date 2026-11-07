package semester1.practice09;

public class Practice09 {
    private static final Runnable[] TASKS = {
        () -> Practice09_1.main(new String[0]),
        () -> Practice09_2.main(new String[0]),
        () -> Practice09_3.main(new String[0]),
        () -> Practice09_4.main(new String[0]),
        () -> Practice09_5.main(new String[0]),
        () -> Practice09_6.main(new String[0]),
        () -> Practice09_7.main(new String[0]),
        () -> Practice09_8.main(new String[0]),
        () -> Practice09_9.main(new String[0]),
        () -> Practice09_10.main(new String[0]),
        () -> Practice09_11.main(new String[0]),
        () -> Practice09_12.main(new String[0]),
        () -> Practice09_13.main(new String[0]),
        () -> Practice09_14.main(new String[0]),
        () -> Practice09_15.main(new String[0]),
        () -> Practice09_16.main(new String[0]),
        () -> Practice09_17.main(new String[0]),
        () -> Practice09_18.main(new String[0]),
        () -> Practice09_19.main(new String[0]),
        () -> Practice09_20.main(new String[0]),
        () -> Practice09_21.main(new String[0]),
        () -> Practice09_22.main(new String[0]),
        () -> Practice09_23.main(new String[0]),
        () -> Practice09_24.main(new String[0]),
        () -> Practice09_25.main(new String[0]),
        () -> Practice09_26.main(new String[0]),
        () -> Practice09_27.main(new String[0]),
        () -> Practice09_28.main(new String[0]),
        () -> Practice09_29.main(new String[0]),
        () -> Practice09_30.main(new String[0]),
        () -> Practice09_31.main(new String[0]),
        () -> Practice09_32.main(new String[0]),
        () -> Practice09_33.main(new String[0]),
        () -> Practice09_34.main(new String[0]),
        () -> Practice09_35.main(new String[0]),
        () -> Practice09_36.main(new String[0]),
        () -> Practice09_37.main(new String[0]),
        () -> Practice09_38.main(new String[0]),
        () -> Practice09_39.main(new String[0])
    };

    public static void main(String[] args) {
        if (args.length == 0) {
            for (int task = 1; task <= TASKS.length; task++) {
                runTask(task);
                System.out.println();
            }
            return;
        }

        int task;
        try {
            task = Integer.parseInt(args[0]);
        } catch (NumberFormatException exception) {
            System.out.println("Вкажіть номер завдання від 1 до " + TASKS.length + ".");
            return;
        }
        if (task >= 1 && task <= TASKS.length) {
            runTask(task);
        } else if (task == 40) {
            System.out.println("Завдання 40: перевірка коду, коміт і push у GitHub.");
        } else {
            System.out.println("Вкажіть номер завдання від 1 до " + TASKS.length + ".");
        }
    }

    private static void runTask(int task) {
        System.out.println("=== Завдання " + task + " ===");
        TASKS[task - 1].run();
    }
}
