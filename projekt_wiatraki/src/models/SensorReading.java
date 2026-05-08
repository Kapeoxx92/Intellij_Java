package models;

public class SensorReading {
    final private String name;
    final private double value;

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public SensorReading(String name, double value) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Niepoprawna nazwa");
        }
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ": " + String.format("%.2f", value);
    }
}