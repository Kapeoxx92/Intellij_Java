// Pamiętaj o poprawnej nazwie klasy!
class Planet {
    // prywatne pola
    private String name;
    private double diameterKm;
    private boolean hasRings;

    // konstruktor główny (3 argumenty)
    public Planet(String name, double diameterKm, boolean hasRings) {
        this.name = name;
        this.diameterKm = diameterKm;
        this.hasRings = hasRings;
    }

    // konstruktor 2-arg — deleguje do głównego
    public Planet(String name, double diameterKm) {
        this(name, diameterKm, false);
    }

    // konstruktor 1-arg — deleguje do 2-arg
    public Planet(String name) {
        this(name, 0.0);
    }

    // toString()
    @Override
    public String toString() {
        return "Planet[name=" + name +
                ", diameter=" + diameterKm +
                ", rings=" + hasRings + "]";
    }
}