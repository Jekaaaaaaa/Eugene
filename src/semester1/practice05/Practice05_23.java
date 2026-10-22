package semester1.practice05;

public class Practice05_23 {
    public static void main(String[] args) {
        int[][] table = new int[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = i * 3 + j + 1;
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
