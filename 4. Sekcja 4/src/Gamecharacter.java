// Pamiętaj o poprawnej nazwie klasy!
class GameCharacter {
    public static final int MAX_HEALTH = 100;
    private static int nextId = 1;

    private final int id;
    private final String name;
    private int health;
    private int level;

    // konstruktor główny
    public GameCharacter(String name, int level) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name required");
        }
        if (level < 1) {
            throw new IllegalArgumentException("Level must be >= 1");
        }

        this.id = nextId++;
        this.name = name;
        this.level = level;
        this.health = MAX_HEALTH;
    }

    // konstruktor 1-arg
    public GameCharacter(String name) {
        this(name, 1);
    }

    // zadawanie obrażeń
    public void takeDamage(int dmg) {
        if (dmg <= 0) return;
        health -= dmg;
        if (health < 0) {
            health = 0;
        }
    }

    // leczenie
    public void heal(int amount) {
        if (amount <= 0) return;
        health += amount;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
    }

    // czy żyje
    public boolean isAlive() {
        return health > 0;
    }

    // gettery
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    // toString()
    @Override
    public String toString() {
        return "GameCharacter[id=" + id +
                ", name=" + name +
                ", health=" + health +
                ", level=" + level + "]";
    }
}