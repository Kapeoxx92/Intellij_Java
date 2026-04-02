// Pamiętaj o poprawnej nazwie klasy!
class UnitConverter {

    // prywatny konstruktor – blokuje tworzenie obiektów
    private UnitConverter() {}

    // km -> mile
    public static double kmToMiles(double km) {
        return km * 0.621371;
    }

    // mile -> km
    public static double milesToKm(double miles) {
        return miles / 0.621371;
    }

    // kg -> lbs
    public static double kgToLbs(double kg) {
        return kg * 2.20462;
    }

    // lbs -> kg
    public static double lbsToKg(double lbs) {
        return lbs / 2.20462;
    }

    // walidacja dystansu
    public static boolean isValidDistance(double km) {
        return km >= 0;
    }
}