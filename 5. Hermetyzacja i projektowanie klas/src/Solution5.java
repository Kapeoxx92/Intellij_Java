import java.util.Scanner;

class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Temperature temperature = null;

        while (true) {
            String command = scanner.next();
            double value = 0;

            switch (command) {
                case "CELSIUS":
                    value = scanner.nextDouble();
                    temperature = Temperature.ofCelsius(value);
                    break;

                case "KELVIN":
                    value = scanner.nextDouble();
                    temperature = Temperature.ofKelvin(value);
                    break;

                case "FAHRENHEIT":
                    value = scanner.nextDouble();
                    temperature = Temperature.ofFahrenheit(value);
                    break;

                case "TO_C":
                    System.out.println(temperature.toCelsius());
                    break;

                case "TO_K":
                    System.out.println(temperature.toKelvin());
                    break;

                case "TO_F":
                    System.out.println(temperature.toFahrenheit());
                    break;

                case "PRINT":
                    System.out.println(temperature.toString());
                    break;

                case "COLDER":
                    value = scanner.nextDouble();
                    System.out.println(temperature.isColder(Temperature.ofCelsius(value)));
                    break;

                case "WARMER":
                    value = scanner.nextDouble();
                    System.out.println(temperature.isWarmer(Temperature.ofCelsius(value)));
                    break;

                case "AVERAGE":
                    value = scanner.nextDouble();
                    System.out.println(temperature.avarage(Temperature.ofCelsius(value)));
                    break;

                case "ERR_C":
                    value = scanner.nextDouble();
                    try {
                        Temperature.ofCelsius(value);
                    } catch (IllegalArgumentException error) {
                        System.out.println(error.getMessage());
                    }

                case "ERR_K":
                    value = scanner.nextDouble();
                    try {
                        Temperature.ofKelvin(value);
                    } catch (IllegalArgumentException error) {
                        System.out.println(error.getMessage());
                    }
            }
        }
    }
}