package analysis;

import models.LogEntry;
import models.WindFarm;
import java.util.*;
import java.util.stream.Collectors;

public class FarmAnalytics {

    public static double totalPowerOutput(WindFarm farm) {
        return farm.getAllLogs().stream()
                .mapToDouble(LogEntry::computePowerOutput)
                .filter(p -> p != -1.0)
                .sum();
    }

    public static double averagePowerPerTurbine(WindFarm farm, String turbineId) {
        return farm.filterByTurbine(turbineId).getAllLogs().stream()
                .mapToDouble(LogEntry::computePowerOutput)
                .filter(p -> p != -1.0)
                .average()
                .orElse(-1.0);
    }

    public static Map<String, Long> eventsCountDescending(WindFarm farm) {
        return farm.getAllLogs().stream()
                .collect(Collectors.groupingBy(LogEntry::getEventType, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static Map<String, Long> alarmsPerTurbineDescending(WindFarm farm) {
        return farm.getAllLogs().stream()
                .filter(LogEntry::isAlarm)
                .collect(Collectors.groupingBy(LogEntry::getTurbineId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static Map<String, Double> monthlyPowerOutput(WindFarm farm) {
        return farm.getAllLogs().stream()
                .filter(l -> l.computePowerOutput() != -1.0)
                .collect(Collectors.groupingBy(
                        l -> l.getTimestamp().substring(0, 7),
                        TreeMap::new,
                        Collectors.summingDouble(LogEntry::computePowerOutput)
                ));
    }

    public static int[] alarmsByHour(WindFarm farm) {
        int[] hourlyStats = new int[24];
        farm.getAllLogs().stream()
                .filter(LogEntry::isAlarm)
                .forEach(l -> {
                    int hour = Integer.parseInt(l.getTimestamp().substring(11, 13));
                    hourlyStats[hour]++;
                });
        return hourlyStats;
    }

    public static String topOperator(WindFarm farm) {
        return farm.getAllLogs().stream()
                .collect(Collectors.groupingBy(LogEntry::getOperatorName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Brak danych");
    }

    public static String topTurbineByPower(WindFarm farm) {
        return farm.getAllLogs().stream()
                .filter(l -> l.computePowerOutput() != -1.0)
                .collect(Collectors.groupingBy(LogEntry::getTurbineId, Collectors.summingDouble(LogEntry::computePowerOutput)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Brak danych");
    }

    public static String topMonthByPower(WindFarm farm) {
        Map<String, Double> monthly = monthlyPowerOutput(farm);
        return monthly.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Brak danych");
    }
}