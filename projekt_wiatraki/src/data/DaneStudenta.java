package data;

import models.*;
import java.util.ArrayList;
import java.util.Random;

public class DaneStudenta {

    public static WindFarm utworzFarme() {
        WindFarm farm = new WindFarm("Baltyk-North", "Baltic Wind Energy", "Baltyk, Poland");

        String[] sensorsSet1 = {"POWER", "WIND_SPEED", "ROTOR_RPM"};
        String[] sensorsSet2 = {"POWER", "WIND_SPEED", "TEMPERATURE", "VIBRATION", "VOLTAGE", "BLADE_PITCH"};

        WindTurbine t1 = new WindTurbine("T-01", "Siemens-100");
        WindTurbine t2 = new WindTurbine("T-02", "Siemens-100");
        WindTurbine t3 = new WindTurbine("T-03", "Vestas-V120");

        farm.addTurbine(t1);
        farm.addTurbine(t2);
        farm.addTurbine(t3);

        Random rand = new Random();
        String[] operators = {"Jan Kowalski", "Anna Nowak", "Marek Brzoza"};
        LogEntry.EventType[] types = LogEntry.EventType.values();

        int alarmCount = 0;
        int maintenanceCount = 0;

        for (int i = 0; i < 60; i++) {
            String turbineId = "T-0" + (rand.nextInt(3) + 1);
            String operator = operators[rand.nextInt(operators.length)];

            LogEntry.EventType type;
            if (alarmCount < 10) {
                type = LogEntry.EventType.ALARM;
                alarmCount++;
            } else if (maintenanceCount < 5) {
                type = LogEntry.EventType.MAINTENANCE;
                maintenanceCount++;
            } else {
                type = types[rand.nextInt(types.length)];
            }

            String[] currentSensors = (turbineId.equals("T-03")) ? sensorsSet2 : sensorsSet1;
            SensorReading[] readings = new SensorReading[currentSensors.length];

            for (int j = 0; j < currentSensors.length; j++) {
                double val = (currentSensors[j].equals("POWER")) ? rand.nextDouble() * 500 : rand.nextDouble() * 100;
                readings[j] = new SensorReading(currentSensors[j], val);
            }

            int month = (i / 15) + 1;
            int hour = rand.nextInt(24);
            String customTimestamp = String.format("2024-%02d-10 %02d:00", month, hour);

            LogEntry entry = new LogEntry(turbineId, type, operator, readings, customTimestamp);

            farm.addLog(entry);
        }

        return farm;
    }
}