// Pamiętaj o poprawnej nazwie klasy!
class Prescription {
    private final String medicationName;
    private final double dosageMg;
    private int refillsRemaining;

    // konstruktor z walidacją
    public Prescription(String medicationName, double dosageMg, int refillsRemaining) {
        if (medicationName == null || medicationName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid medication name");
        }
        if (dosageMg <= 0) {
            throw new IllegalArgumentException("Dosage must be positive");
        }
        if (refillsRemaining < 0) {
            throw new IllegalArgumentException("Refills cannot be negative");
        }

        this.medicationName = medicationName;
        this.dosageMg = dosageMg;
        this.refillsRemaining = refillsRemaining;
    }

    // useRefill()
    public void useRefill() {
        if (refillsRemaining == 0) {
            throw new IllegalStateException("No refills remaining");
        }
        refillsRemaining--;
    }

    // gettery
    public String getMedicationName() {
        return medicationName;
    }

    public double getDosageMg() {
        return dosageMg;
    }

    public int getRefillsRemaining() {
        return refillsRemaining;
    }

    // toString()
    @Override
    public String toString() {
        return "Prescription[med=" + medicationName +
                ", dose=" + dosageMg + "mg" +
                ", refills=" + refillsRemaining + "]";
    }
}