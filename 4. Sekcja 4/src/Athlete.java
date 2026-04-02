// Pamiętaj o poprawnej nazwie klasy!
class Athlete {
    // TODO: prywatne pola: String name, int age, double personalBestSeconds
    private String name;
    private int age;
    private double personalBestSeconds;

    // TODO: konstruktor Athlete(String name, int age, double personalBestSeconds)
    public Athlete(String name, int age, double personalBestSeconds) {
        this.name = name;
        this.age = age;
        this.personalBestSeconds = personalBestSeconds;
    }

    // TODO: gettery: getName(), getAge(), getPersonalBestSeconds()
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getPersonalBestSeconds() { return  personalBestSeconds; }

    // TODO: setAge(int age) — tylko jeśli age w [0, 120]
    public void setAge(int age) {
        if (age >= 0 && age <=120) {
            this.age = age;
        }
    }
    // TODO: setPersonalBestSeconds(double pb) — tylko jeśli pb > 0
    public void setPersonalBestSeconds(double pb) {
        if (pb > 0) {
            this.personalBestSeconds = pb;
        }
    }

    // TODO: toString() → Athlete[name=[name], age=[age], pb=[personalBestSeconds]]
    public String toString() {
        return "Athlete[name=" + name + ", age=" + age + ", pb=" + personalBestSeconds + "]";
    }
}
