package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LogEntry {
    public enum EventType {
        OPERATIONAL, ALARM, MAINTENANCE, SHUTDOWN, STARTUP
    }

    private String turbineId;
    private String operatorName;
    private EventType event;
    private String timestamp;
    private SensorReading[] sensorReadings;

    public LogEntry(String turbineId, EventType event, String operatorName, SensorReading[] sensorReadings) {
        this.turbineId = turbineId;
        this.event = event;
        this.operatorName = operatorName;
        this.sensorReadings = Arrays.copyOf(sensorReadings, sensorReadings.length);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.timestamp = now.format(formatter);
    }

    public LogEntry(String turbineId, EventType event, String operatorName, SensorReading[] sensorReadings, String customTimestamp) {
        this(turbineId, event, operatorName, sensorReadings);
        this.timestamp = customTimestamp;
    }

    public String getTimestamp() { return timestamp; }
    public String getOperatorName() { return operatorName; }
    public String getTurbineId() { return turbineId; }
    public String getEventType() { return event.name(); }

    public LocalDate getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(this.timestamp, formatter).toLocalDate();
    }

    public SensorReading getReadingByName(String name) {
        for (SensorReading sr : sensorReadings) {
            if (sr.getName().equals(name)) return sr;
        }
        return null;
    }

    public double computePowerOutput() {
        SensorReading powerSensor = getReadingByName("POWER");
        return (powerSensor != null) ? powerSensor.getValue() : -1.0;
    }

    public boolean isAlarm() { return event == EventType.ALARM; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + turbineId + " | " + event + " | " + operatorName + " | " + sensorReadings.length + " odczytow";
    }
}