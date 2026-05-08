package models;

import java.util.Arrays;

public class WindTurbine {
    private final String turbineId;
    private final String model;
    private final int ratedPowerKw;
    private final int hubHeightM;
    private final String[] sensors;

    public WindTurbine(String id, String model) {
        this.turbineId = id;
        this.model = model;
        this.ratedPowerKw = 2000;
        this.hubHeightM = 100;
        this.sensors = new String[]{"POWER", "WIND_SPEED", "ROTOR_RPM"};
    }

    public WindTurbine(String turbineId, String model, int ratedPowerKw, int hubHeightM, String[] sensors) {
        if (ratedPowerKw < 500 || ratedPowerKw > 10000) {
            throw new IllegalArgumentException("ratedPowerKw poza dozwolonym zakresem: 500-10000");
        }
        if (hubHeightM < 50 || hubHeightM > 200) {
            throw new IllegalArgumentException("hubHeightM poza dozwolonym zakresem: 50-200");
        }
        this.turbineId = turbineId;
        this.model = model;
        this.ratedPowerKw = ratedPowerKw;
        this.hubHeightM = hubHeightM;
        this.sensors = Arrays.copyOf(sensors, sensors.length);
    }

    public boolean hasSensor(String name) {
        if (sensors == null) return false;
        for (String s : sensors) {
            if (s.equals(name)) return true;
        }
        return false;
    }

    public String getId() {
        return turbineId;
    }

    public String getModel() {
        return model;
    }

    public String[] getSensors() {
        return sensors != null ? Arrays.copyOf(sensors, sensors.length) : new String[0];
    }

    @Override
    public String toString() {
        return "[" + turbineId + "] " + model + " | " + ratedPowerKw + " kW | " + hubHeightM + " m | " + (sensors != null ? sensors.length : 0) + " sensorow";
    }
}