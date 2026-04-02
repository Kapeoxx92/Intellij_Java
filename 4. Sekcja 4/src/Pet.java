// Pamiętaj o poprawnej nazwie klasy!
class Pet {
    // prywatne pola instancji
    private String name;
    private String species;

    // prywatne pole statyczne
    private static int count = 0;

    // konstruktor
    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
        count++; // inkrementacja licznika
    }

    // gettery
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    // metoda statyczna
    public static int getCount() {
        return count;
    }

    // toString()
    @Override
    public String toString() {
        return "Pet[name=" + name +
                ", species=" + species + "]";
    }
}