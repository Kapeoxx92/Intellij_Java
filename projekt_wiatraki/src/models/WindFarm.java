package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class WindFarm {
    private String name;
    private String operator;
    private String location;
    private ArrayList<WindTurbine> turbines;
    private ArrayList<LogEntry> logEntries;

    public WindFarm(String name, String operator, String location) {
        this.name = name;
        this.operator = operator;
        this.location = location;
        this.turbines = new ArrayList<>();
        this.logEntries = new ArrayList<>();
    }

    public ArrayList<LogEntry> getAllLogs() {
        return new ArrayList<>(this.logEntries);
    }

    public WindFarm filterByTurbine(String turbineId) {
        WindFarm filtered = new WindFarm(this.name, this.operator, this.location);

        filtered.turbines = new ArrayList<>(this.turbines);

        filtered.logEntries = this.logEntries.stream()
                .filter(e -> e.getTurbineId().equalsIgnoreCase(turbineId))
                .collect(Collectors.toCollection(ArrayList::new));

        return filtered;
    }

    public WindFarm filterByEventType(String eventType) {
        WindFarm filtered = new WindFarm(this.name, this.operator, this.location);

        filtered.turbines = new ArrayList<>(this.turbines);

        filtered.logEntries = this.logEntries.stream()
                .filter(e -> e.getEventType().equalsIgnoreCase(eventType))
                .collect(Collectors.toCollection(ArrayList::new));

        return filtered;
    }

    public WindFarm filterByDateRange(LocalDate start, LocalDate end) {
        WindFarm filtered = new WindFarm(this.name, this.operator, this.location);

        filtered.turbines = new ArrayList<>(this.turbines);

        filtered.logEntries = this.logEntries.stream()
                .filter(e -> !e.getDate().isBefore(start) && !e.getDate().isAfter(end))
                .collect(Collectors.toCollection(ArrayList::new));

        return filtered;
    }

    public WindFarm filterByOperator(String operatorName) {
        WindFarm filtered = new WindFarm(this.name, this.operator, this.location);

        filtered.turbines = new ArrayList<>(this.turbines);

        filtered.logEntries = this.logEntries.stream()
                .filter(e -> e.getOperatorName().equalsIgnoreCase(operatorName))
                .collect(Collectors.toCollection(ArrayList::new));

        return filtered;
    }

    public WindTurbine getTurbineById(String id) {
        return turbines.stream()
                .filter(t -> t.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public String[] getUniqueTurbineIds() {
        return turbines.stream()
                .map(WindTurbine::getId)
                .distinct()
                .toArray(String[]::new);
    }

    public String[] getUniqueOperators() {
        return logEntries.stream()
                .map(LogEntry::getOperatorName)
                .distinct()
                .toArray(String[]::new);
    }

    public String[] getUniqueEventTypes() {
        return logEntries.stream()
                .map(LogEntry::getEventType)
                .distinct()
                .toArray(String[]::new);
    }

    public int logCount() {
        return logEntries.size();
    }

    public int turbineCount() {
        return turbines.size();
    }

    public void addTurbine(WindTurbine t) {
        this.turbines.add(t);
    }

    public void addLog(LogEntry l) {
        this.logEntries.add(l);
    }
}