package semester1.practice05;

public class Practice05_40 {
    public static void main(String[] args) {
        String[] cities = {"Київ", "Львів", "Одеса"};
        double[][][] weather = new double[3][7][2];
        double[][] dayTemps = {{15, 16, 14, 17, 18, 16, 15}, {12, 13, 11, 14, 15, 13, 12}, {18, 19, 17, 20, 21, 19, 18}};
        double[][] nightTemps = {{7, 8, 6, 9, 10, 8, 7}, {4, 5, 3, 6, 7, 5, 4}, {11, 12, 10, 13, 14, 12, 11}};
        for (int city = 0; city < weather.length; city++) {
            for (int day = 0; day < weather[city].length; day++) {
                weather[city][day][0] = dayTemps[city][day];
                weather[city][day][1] = nightTemps[city][day];
            }
        }
        double coldestNight = weather[0][0][1];
        int coldestCity = 0;
        int coldestDay = 0;
        for (int city = 0; city < weather.length; city++) {
            double daySum = 0;
            for (int day = 0; day < weather[city].length; day++) {
                daySum += weather[city][day][0];
                if (weather[city][day][1] < coldestNight) {
                    coldestNight = weather[city][day][1];
                    coldestCity = city;
                    coldestDay = day;
                }
            }
            System.out.printf(java.util.Locale.US, "%s: середня денна температура %.2f °C%n", cities[city], daySum / weather[city].length);
        }
        System.out.println("Найхолодніша ніч: " + coldestNight + " °C, " + cities[coldestCity] + ", день " + (coldestDay + 1));
    }
}
