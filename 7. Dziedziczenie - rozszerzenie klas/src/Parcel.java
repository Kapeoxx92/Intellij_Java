class Parcel {

    private String code;
    private int grams;

    public Parcel(String code, int grams) {
        this.code = code;
        this.grams = grams;
    }

    public String basicLabel() {
        return code + "/" + grams;
    }
}
class ThermalParcel extends Parcel {

    private int minTemp;
    private int maxTemp;

    public ThermalParcel(String code, int grams, int minTemp, int maxTemp) {
        super(code, grams);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    // ile "brakuje" do zakresu
    public int temperatureDebt(int currentTemp) {

        if (currentTemp < minTemp) {
            return minTemp - currentTemp;
        }

        if (currentTemp > maxTemp) {
            return currentTemp - maxTemp;
        }

        return 0;
    }

    // ocena temperatury
    public String verdict(int currentTemp) {

        if (currentTemp < minTemp) {
            return "LOW";
        }

        if (currentTemp > maxTemp) {
            return "HIGH";
        }

        return "SAFE";
    }
}