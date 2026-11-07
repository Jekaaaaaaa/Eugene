package semester1.practice09;

import semester1.practice09.Practice09_25.AbstractShape;
import semester1.practice09.Practice09_25.CircleShape;
import semester1.practice09.Practice09_25.RectangleShape;

public class Practice09_35 {
    public static void main(String[] args) {
        LandPlot plot = new LandPlot(100.0, 3);
        System.out.println("Дім: " + plot.addStructure(new RectangleShape("Сірий", 6.0, 7.0)));
        System.out.println("Клумба: " + plot.addStructure(new CircleShape("Зелений", 2.0)));
        System.out.println("Гараж: " + plot.addStructure(new RectangleShape("Білий", 5.0, 5.0)));
        System.out.printf("Вільний газон: %.2f м²%n", plot.getFreeGreenArea());
    }

    static class LandPlot {
        private final double totalPlotAreaM2;
        private final AbstractShape[] structures;
        private int count;

        public LandPlot(double totalPlotAreaM2, int capacity) {
            this.totalPlotAreaM2 = totalPlotAreaM2;
            this.structures = new AbstractShape[capacity];
        }

        public boolean addStructure(AbstractShape s) {
            if (s == null || count == structures.length) {
                return false;
            }
            double area = s.getArea();
            if (!(area >= 0.0 && getUsedArea() + area <= totalPlotAreaM2 * 0.60)) {
                return false;
            }
            structures[count++] = s;
            return true;
        }

        private double getUsedArea() {
            double usedArea = 0.0;
            for (int i = 0; i < count; i++) {
                usedArea += structures[i].getArea();
            }
            return usedArea;
        }

        public double getFreeGreenArea() {
            return totalPlotAreaM2 - getUsedArea();
        }
    }
}
