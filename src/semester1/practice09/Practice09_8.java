package semester1.practice09;

import java.util.Arrays;

public class Practice09_8 {
    public static void main(String[] args) {
        String[] allergies = {"Пилок", "Латекс"};
        MedicalRecord record = new MedicalRecord("TEST-01", "Тестовий пацієнт", 2, true, allergies);
        allergies[0] = "Інше";
        System.out.println(record);
        System.out.println("Алергія на пилок: " + record.hasAllergyTo("пилок"));
    }

    static class MedicalRecord {
        private final String patientId;
        private String fullName;
        private int bloodGroup;
        private boolean rhPositive;
        private String[] allergies;

        public MedicalRecord(String patientId, String fullName, int bloodGroup, boolean rhPositive, String[] allergies) {
            if (bloodGroup < 1 || bloodGroup > 4) {
                throw new IllegalArgumentException("Група крові має бути в межах 1–4");
            }
            this.patientId = patientId;
            this.fullName = fullName;
            this.bloodGroup = bloodGroup;
            this.rhPositive = rhPositive;
            this.allergies = allergies == null ? new String[0] : allergies.clone();
        }

        public String[] getAllergies() {
            return allergies.clone();
        }

        public boolean hasAllergyTo(String substance) {
            for (String allergy : allergies) {
                if (allergy != null && allergy.equalsIgnoreCase(substance)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            String[] groups = {"I (O)", "II (A)", "III (B)", "IV (AB)"};
            return patientId + " " + fullName + ", " + groups[bloodGroup - 1] + (rhPositive ? " Rh+" : " Rh-")
                    + ", алергії: " + Arrays.toString(allergies);
        }
    }
}
