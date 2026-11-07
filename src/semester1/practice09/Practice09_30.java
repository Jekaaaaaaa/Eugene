package semester1.practice09;

public class Practice09_30 {
    public static void main(String[] args) {
        Solid3D sphere = new Sphere3D("Сталь", 7850.0, 0.1);
        Solid3D cylinder = new Cylinder3D("Золото", 19300.0, 0.05, 0.2);
        printSolid("Сфера", sphere);
        printSolid("Циліндр", cylinder);
    }

    private static void printSolid(String name, Solid3D solid) {
        System.out.printf("%s (%s), об'єм: %.6f м³, площа поверхні: %.4f м², маса: %.2f кг%n",
                name, solid.getMaterialName(), solid.getVolume(), solid.getSurfaceArea(), solid.getMassKg());
    }

    static abstract class Solid3D {
        private final String materialName;
        private final double densityKgPerM3;

        public Solid3D(String materialName, double densityKgPerM3) {
            this.materialName = materialName;
            this.densityKgPerM3 = densityKgPerM3;
        }

        public String getMaterialName() {
            return materialName;
        }

        public abstract double getVolume();

        public abstract double getSurfaceArea();

        public final double getMassKg() {
            return densityKgPerM3 * getVolume();
        }
    }

    static class Sphere3D extends Solid3D {
        private final double radius;

        public Sphere3D(String materialName, double densityKgPerM3, double radius) {
            super(materialName, densityKgPerM3);
            this.radius = radius;
        }

        @Override
        public double getVolume() {
            return 4.0 / 3.0 * Math.PI * radius * radius * radius;
        }

        @Override
        public double getSurfaceArea() {
            return 4.0 * Math.PI * radius * radius;
        }
    }

    static class Cylinder3D extends Solid3D {
        private final double radius;
        private final double height;

        public Cylinder3D(String materialName, double densityKgPerM3, double radius, double height) {
            super(materialName, densityKgPerM3);
            this.radius = radius;
            this.height = height;
        }

        @Override
        public double getVolume() {
            return Math.PI * radius * radius * height;
        }

        @Override
        public double getSurfaceArea() {
            return 2.0 * Math.PI * radius * (radius + height);
        }
    }
}
