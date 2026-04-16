import java.util.ArrayList;

// Klasa Player (niemutowalna)
class Player {
    private final String name;
    private final double salary;

    public Player(String name, double salary) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid player name");
        }
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be non-negative");
        }
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Player[name=" + name + ", salary=" + salary + "]";
    }
}


// Klasa Team
class Team {
    private String teamName;
    private int capacity;
    private ArrayList<Player> players;
    private Player captain;

    public Team(String teamName, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.teamName = teamName;
        this.capacity = capacity;
        this.players = new ArrayList<>();
        this.captain = null;
    }

    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
        if (players.size() >= capacity) {
            throw new IllegalStateException("Team is full");
        }
        players.add(player);
    }

    public void setCaptain(Player player) {
        if (!players.contains(player)) {
            throw new IllegalArgumentException("Player is not in the team");
        }
        this.captain = player;
    }

    public boolean isFull() {
        return players.size() >= capacity;
    }

    public double totalPayroll() {
        double sum = 0;
        for (Player p : players) {
            sum += p.getSalary();
        }
        return sum;
    }

    public int getPlayerCount() {
        return players.size();
    }

    public Player getCaptain() {
        return captain;
    }

    @Override
    public String toString() {
        String captainName = (captain == null) ? "none" : captain.getName();
        return "Team[name=" + teamName +
                ", players=" + getPlayerCount() + "/" + capacity +
                ", captain=" + captainName + "]";
    }
}