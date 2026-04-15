// Pamiętaj o poprawnej nazwie klasy!
final class Temperature {
    // TODO: private final double celsius
    private final double celsius;

    // TODO: private konstruktor Temperature(double celsius)
    private Temperature(double celsius) {
        this.celsius = celsius;
    }
    // TODO: private static Temperature create(double celsius)
    private static Temperature create(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Temperature below absolute zero");
        }
        return new Temperature(celsius);
    }
    // Walidacja: celsius < -273.15 → IllegalArgumentException("Temperature below absolute zero")

    // TODO: public static Temperature ofCelsius(double celsius)
    public static Temperature ofCelsius(double celsius) {
        return create(celsius);
    }
    // TODO: public static Temperature ofKelvin(double kelvin)
    public static Temperature ofKelvin(double kelvin) {
        if (kelvin < 0) {
            throw new IllegalArgumentException("Temperature below absolute zero");
        } else {
            return create(kelvin - 273.15);
        }
    }
    //   Walidacja: kelvin < 0 → IllegalArgumentException("Temperature below absolute zero")
    //   Przelicz: celsius = kelvin - 273.15
    // TODO: public static Temperature ofFahrenheit(double fahrenheit)
    public static Temperature ofFahrenheit(double fahrenheit) {
        if (fahrenheit < 0) {
            throw new IllegalArgumentException("Temperature below absolute zero");
        } else {
            return create((fahrenheit - 32.0) * 5.0 / 9.0);
        }
    }
    //   Przelicz: celsius = (fahrenheit - 32.0) * 5.0 / 9.0

    // TODO: toCelsius(), toKelvin(), toFahrenheit()
    public double toCelsius() {
        return celsius;
    }
    public double toKelvin() {
        return celsius + 273.15;
    }
    public double toFahrenheit() {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    // TODO: isColder(Temperature other), isWarmer(Temperature other)
    public boolean isColder(Temperature other) {
        return this.celsius < other.celsius;
    }
    public boolean isWarmer(Temperature other) {
        return this.celsius > other.celsius;
    }
    // TODO: isSameTemperature(Temperature other)
    public boolean isSameTemperature(Temperature other) {
        return Double.compare(this.celsius, other.celsius) == 0;
    }

    // TODO: average(Temperature other) → nowy obiekt z uśrednioną celsius
    public Temperature avarage(Temperature other) {
        return new Temperature((this.celsius + other.celsius) / 2);
    }
    //   Uwaga: użyj new Temperature(...) bezpośrednio (pomijasz walidację – jest niepotrzebna)

    // TODO: toString() → Temperature[celsius=<celsius>]

    @Override
    public String toString() {
        return "Temperature[celsius=" + this.celsius + "]";
    }
}