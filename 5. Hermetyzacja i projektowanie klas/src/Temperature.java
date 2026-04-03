// Pamiętaj o poprawnej nazwie klasy!
final class Temperature {
    // TODO: private final double celsius
    private final double celsius;

    // TODO: private konstruktor Temperature(double celsius)
    Temperature(double celsius) {
        this.celsius = celsius;
    }
    // TODO: private static Temperature create(double celsius)
    // Walidacja: celsius < -273.15 → IllegalArgumentException("Temperature below absolute zero")

    // TODO: public static Temperature ofCelsius(double celsius)
    // TODO: public static Temperature ofKelvin(double kelvin)
    //   Walidacja: kelvin < 0 → IllegalArgumentException("Temperature below absolute zero")
    //   Przelicz: celsius = kelvin - 273.15
    // TODO: public static Temperature ofFahrenheit(double fahrenheit)
    //   Przelicz: celsius = (fahrenheit - 32.0) * 5.0 / 9.0

    // TODO: toCelsius(), toKelvin(), toFahrenheit()

    // TODO: isColder(Temperature other), isWarmer(Temperature other)
    // TODO: isSameTemperature(Temperature other)

    // TODO: average(Temperature other) → nowy obiekt z uśrednioną celsius
    //   Uwaga: użyj new Temperature(...) bezpośrednio (pomijasz walidację – jest niepotrzebna)

    // TODO: toString() → Temperature[celsius=<celsius>]
}