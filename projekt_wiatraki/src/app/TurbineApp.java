package app;

import analysis.FarmAnalytics;
import data.DaneStudenta;
import models.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TurbineApp {
    private WindFarm farm;
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public TurbineApp() {
        this.farm = DaneStudenta.utworzFarme();
    }

    public void run() {
        while (true) {
            System.out.println("\n=== SYSTEM ZARZĄDZANIA FARMĄ WIATROWĄ ===");
            System.out.println("1. Statystyki farmy");
            System.out.println("2. Analiza turbiny");
            System.out.println("3. Przeglądaj zdarzenia (Filtrowanie)");
            System.out.println("4. Dodaj wpis");
            System.out.println("5. Informacje o farmie");
            System.out.println("0. Wyjście");

            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1" -> showFarmStats();
                    case "2" -> analyzeTurbine();
                    case "3" -> browseEvents();
                    case "4" -> addLogEntry();
                    case "5" -> farmInfo();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Niepoprawny wybór.");
                }
            } catch (Exception e) {
                System.out.println("Wystąpił błąd: " + e.getMessage());
            }
        }
    }

    private void showFarmStats() {
        double totalPower = FarmAnalytics.totalPowerOutput(farm);
        System.out.println("Łączna moc (POWER): " + String.format("%.2f", totalPower));

        System.out.println("\nRanking turbin (% udziału w POWER):");
        for (String id : farm.getUniqueTurbineIds()) {
            double turbinePower = farm.filterByTurbine(id).getAllLogs().stream()
                    .mapToDouble(LogEntry::computePowerOutput).filter(p -> p != -1).sum();
            double percent = (totalPower > 0) ? (turbinePower / totalPower) * 100 : 0;
            System.out.printf("- %s: %.2f%%\n", id, percent);
        }

        System.out.println("\nAlarmy per godzina (Wizualizacja):");
        int[] hourly = FarmAnalytics.alarmsByHour(farm);
        int max = Arrays.stream(hourly).max().orElse(1);
        for (int h = 0; h < 24; h++) {
            int bars = (max > 0) ? (hourly[h] * 20 / max) : 0;
            System.out.printf("%02d:00 [%-20s] (%d)\n", h, "*".repeat(bars), hourly[h]);
        }
    }

    private void analyzeTurbine() {
        System.out.println("Dostępne turbiny: " + Arrays.toString(farm.getUniqueTurbineIds()));
        System.out.print("Podaj ID turbiny: ");
        String id = scanner.nextLine();
        WindTurbine t = farm.getTurbineById(id);
        if (t == null) { System.out.println("Brak turbiny."); return; }

        WindFarm filtered = farm.filterByTurbine(id);
        displayPaginated(filtered.getAllLogs());
    }

    private void browseEvents() {
        System.out.println("Filtruj wg: 1.Turbiny 2.Typu 3.Operatora 4.Daty");

        String mode = scanner.nextLine();

        WindFarm result = farm;

        switch (mode) {

            case "1" -> {
                System.out.print("ID: ");
                result = farm.filterByTurbine(scanner.nextLine());
            }

            case "2" -> {
                System.out.print("Typ: ");
                result = farm.filterByEventType(scanner.nextLine());
            }

            case "3" -> {
                System.out.println("Operatorzy: " + Arrays.toString(farm.getUniqueOperators()));
                System.out.print("Operator: ");
                result = farm.filterByOperator(scanner.nextLine());
            }

            case "4" -> {
                LocalDate start = readDate("Data od (DD.MM.RRRR): ");
                LocalDate end = readDate("Data do (DD.MM.RRRR): ");
                result = farm.filterByDateRange(start, end);
            }

            default -> {
                System.out.println("Niepoprawna opcja.");
                return;
            }
        }

        displayPaginated(result.getAllLogs());

        System.out.println("Suma POWER w filtrze: "
                + String.format("%.2f", FarmAnalytics.totalPowerOutput(result)));
    }

    private void addLogEntry() {

        String tId;

        while (true) {
            System.out.print("ID turbiny: ");

            tId = scanner.nextLine();

            if (farm.getTurbineById(tId) != null) {
                break;
            }

            System.out.println("Błąd: Turbina nie istnieje.");
        }

        LocalDate date = readDate("Data (DD.MM.RRRR): ");

        System.out.print("Czas (HH:MM): ");
        String time = scanner.nextLine();

        System.out.println("Typy: " + Arrays.toString(LogEntry.EventType.values()));

        LogEntry.EventType type = null;

        while (type == null) {
            try {
                System.out.print("Typ zdarzenia: ");
                type = LogEntry.EventType.valueOf(scanner.nextLine().toUpperCase());

            } catch (Exception e) {
                System.out.println("Błędny typ.");
            }
        }

        System.out.print("Operator: ");
        String op = scanner.nextLine();

        System.out.print("POWER: ");
        double power = Double.parseDouble(scanner.nextLine());

        SensorReading[] readings = {
                new SensorReading("POWER", power)
        };

        String timestamp =
                date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                        + " " + time;

        LogEntry newEntry =
                new LogEntry(tId, type, op, readings, timestamp);

        farm.addLog(newEntry);

        System.out.println("Sukces: Wpis został zapisany w systemie.");
    }

    private void displayPaginated(List<LogEntry> logs) {
        int pageSize = 20;
        for (int i = 0; i < logs.size(); i++) {
            System.out.println(logs.get(i));
            if ((i + 1) % pageSize == 0 && i < logs.size() - 1) {
                System.out.print("--- Naciśnij Enter, aby zobaczyć więcej ---");
                scanner.nextLine();
            }
        }
    }

    private LocalDate readDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return LocalDate.parse(scanner.nextLine(), dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Błędny format daty!");
            }
        }
    }

    private void farmInfo() {
        System.out.println("Operatorzy: " + Arrays.toString(farm.getUniqueOperators()));
        System.out.println("Liczba logów: " + farm.logCount());
    }

    public static void main(String[] args) {
        new TurbineApp().run();
    }
}