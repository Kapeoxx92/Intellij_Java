// Pamiętaj o poprawnej nazwie klasy!
class Aquarium {
    private String name;
    private double capacityLiters;
    private int fishCount;

    // konstruktor
    public Aquarium(String name, double capacityLiters) {
        if (capacityLiters <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.name = name;
        this.capacityLiters = capacityLiters;
        this.fishCount = 0;
    }

    // dodawanie ryb
    public void addFish(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Count must be positive");
        }
        if (fishCount + n > getMaxFish()) {
            throw new IllegalStateException("Aquarium full");
        }
        fishCount += n;
    }

    // usuwanie ryb
    public void removeFish(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Count must be positive");
        }
        if (fishCount < n) {
            throw new IllegalStateException("Not enough fish");
        }
        fishCount -= n;
    }

    // transfer ryb
    public void transferTo(Aquarium other, int n) {
        // najpierw usuń, potem dodaj
        this.removeFish(n);
        try {
            other.addFish(n);
        } catch (RuntimeException e) {
            // rollback jeśli się nie udało
            this.addFish(n);
            throw e;
        }
    }

    // maksymalna liczba ryb
    public int getMaxFish() {
        return (int)(capacityLiters / 10);
    }

    // gettery
    public String getName() {
        return name;
    }

    public double getCapacityLiters() {
        return capacityLiters;
    }

    public int getFishCount() {
        return fishCount;
    }

    // toString()
    @Override
    public String toString() {
        return "Aquarium[name=" + name +
                ", capacity=" + capacityLiters + "L" +
                ", fish=" + fishCount + "/" + getMaxFish() + "]";
    }
}