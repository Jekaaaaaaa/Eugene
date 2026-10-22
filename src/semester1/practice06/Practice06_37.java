package semester1.practice06;

import java.util.Locale;

public class Practice06_37 {
    public static void main(String[] args) {
        ArraySearcher searcher = new ArraySearcher();
        searcher.setData(new int[]{4, 8, 15, 16, 23, 42, 8});
        System.out.println("Число 8: " + searcher.contains(8) + "; перший індекс: " + searcher.findIndex(8));
        System.out.println("Число 99: " + searcher.contains(99) + "; індекс: " + searcher.findIndex(99));
    }

    static class ArraySearcher {
        private int[] data = new int[0];
    
        public void setData(int[] data) {
            this.data = data == null ? new int[0] : data.clone();
        }
    
        public boolean contains(int target) {
            return findIndex(target) != -1;
        }
    
        public int findIndex(int target) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == target) {
                    return i;
                }
            }
            return -1;
        }
    }
}
