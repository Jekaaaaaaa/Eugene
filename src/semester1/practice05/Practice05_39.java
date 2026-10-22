package semester1.practice05;

public class Practice05_39 {
    public static void main(String[] args) {
        int[][][] cube = new int[3][3][3];
        for (int x = 0; x < cube.length; x++) {
            System.out.println("--- Шар " + x + " ---");
            for (int y = 0; y < cube[x].length; y++) {
                for (int z = 0; z < cube[x][y].length; z++) {
                    cube[x][y][z] = x + y + z;
                    System.out.print(cube[x][y][z] + "\t");
                }
                System.out.println();
            }
        }
    }
}
