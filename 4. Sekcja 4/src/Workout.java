// Pamiętaj o poprawnej nazwie klasy!
class Workout {
    // prywatne pola
    private String name;
    private double caloriesBurned;

    // konstruktor
    public Workout(String name) {
        this.name = name;
        this.caloriesBurned = 0.0;
    }

    // addCalories(double amount)
    public void addCalories(double amount) {
        if (amount > 0) {
            this.caloriesBurned += amount;
        }
    }

    // addCalories(int amount)
    public void addCalories(int amount) {
        if (amount > 0) {
            this.caloriesBurned += (double) amount;
        }
    }

    // addCalories(double amount, int repetitions)
    public void addCalories(double amount, int repetitions) {
        if (amount > 0 && repetitions > 0) {
            this.caloriesBurned += amount * repetitions;
        }
    }

    // getter
    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    // toString()
    @Override
    public String toString() {
        return "Workout[name=" + name +
                ", calories=" + caloriesBurned + "]";
    }
}