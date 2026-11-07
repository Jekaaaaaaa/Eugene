package semester1.practice08;

public class Practice08 {
    private static final Runnable[] TASKS = {
        () -> Practice08_1.main(new String[0]),
        () -> Practice08_2.main(new String[0]),
        () -> Practice08_3.main(new String[0]),
        () -> Practice08_4.main(new String[0]),
        () -> Practice08_5.main(new String[0]),
        () -> Practice08_6.main(new String[0]),
        () -> Practice08_7.main(new String[0]),
        () -> Practice08_8.main(new String[0]),
        () -> Practice08_9.main(new String[0]),
        () -> Practice08_10.main(new String[0]),
        () -> Practice08_11.main(new String[0]),
        () -> Practice08_12.main(new String[0]),
        () -> Practice08_13.main(new String[0]),
        () -> Practice08_14.main(new String[0]),
        () -> Practice08_15.main(new String[0]),
        () -> Practice08_16.main(new String[0]),
        () -> Practice08_17.main(new String[0]),
        () -> Practice08_18.main(new String[0]),
        () -> Practice08_19.main(new String[0]),
        () -> Practice08_20.main(new String[0]),
        () -> Practice08_21.main(new String[0]),
        () -> Practice08_22.main(new String[0]),
        () -> Practice08_23.main(new String[0]),
        () -> Practice08_24.main(new String[0]),
        () -> Practice08_25.main(new String[0]),
        () -> Practice08_26.main(new String[0]),
        () -> Practice08_27.main(new String[0]),
        () -> Practice08_28.main(new String[0]),
        () -> Practice08_29.main(new String[0]),
        () -> Practice08_30.main(new String[0]),
        () -> Practice08_31.main(new String[0]),
        () -> Practice08_32.main(new String[0]),
        () -> Practice08_33.main(new String[0]),
        () -> Practice08_34.main(new String[0]),
        () -> Practice08_35.main(new String[0]),
        () -> Practice08_36.main(new String[0]),
        () -> Practice08_37.main(new String[0]),
        () -> Practice08_38.main(new String[0]),
        () -> Practice08_39.main(new String[0])
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
