package semester1.practice09;

public class Practice09_1 {
    public static void main(String[] args) {
        ImmutableGeoPoint point = new ImmutableGeoPoint(95.0, 32.0);
        System.out.println("Початкова: " + point);
        System.out.println("Зміщена: " + point.shift(-5.0, 10.0));
        System.out.println("Початкова після зміщення: " + point);
    }

    static final class ImmutableGeoPoint {
        private final double latitude;
        private final double longitude;

        public ImmutableGeoPoint(double latitude, double longitude) {
            this.latitude = clamp(latitude, 90.0);
            this.longitude = clamp(longitude, 180.0);
        }

        public ImmutableGeoPoint shift(double dLat, double dLon) {
            return new ImmutableGeoPoint(latitude + dLat, longitude + dLon);
        }

        private static double clamp(double value, double limit) {
            if (Double.isNaN(value)) {
                throw new IllegalArgumentException("Координата має бути числом");
            }
            return Math.max(-limit, Math.min(limit, value));
        }

        @Override
        public String toString() {
            return "(" + latitude + "; " + longitude + ")";
        }
    }
}
