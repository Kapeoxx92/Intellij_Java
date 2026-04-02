// Pamiętaj o poprawnej nazwie klasy!
class Playlist {
    public static final int MAX_TRACKS = 10;
    private static int totalCreated = 0;

    private final String title;
    private final String owner;
    private int trackCount;
    private int totalDurationSeconds;

    // konstruktor główny
    public Playlist(String title, String owner) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title required");
        }
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner required");
        }

        this.title = title;
        this.owner = owner;
        this.trackCount = 0;
        this.totalDurationSeconds = 0;

        totalCreated++;
    }

    // konstruktor 1-arg
    public Playlist(String title) {
        this(title, "Anonymous");
    }

    // konstruktor 0-arg
    public Playlist() {
        this("Untitled");
    }

    // dodawanie utworu
    public void addTrack(int durationSeconds) {
        if (durationSeconds <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        if (trackCount == MAX_TRACKS) {
            throw new IllegalStateException("Playlist is full");
        }

        trackCount++;
        totalDurationSeconds += durationSeconds;
    }

    // usuwanie ostatniego utworu
    public void removeLastTrack(int durationSeconds) {
        if (trackCount == 0) {
            throw new IllegalStateException("Playlist is empty");
        }

        trackCount--;
        totalDurationSeconds -= durationSeconds;
        if (totalDurationSeconds < 0) {
            totalDurationSeconds = 0; // zabezpieczenie
        }
    }

    // scalanie playlist
    public void mergeFrom(Playlist other) {
        if (other == null || other.trackCount == 0) return;

        int avg = other.totalDurationSeconds / other.trackCount;

        for (int i = 0; i < other.trackCount; i++) {
            if (this.trackCount == MAX_TRACKS) break;
            this.addTrack(avg);
        }
    }

    // średnia długość
    public double getAverageDuration() {
        if (trackCount == 0) return 0.0;
        return (double) totalDurationSeconds / trackCount;
    }

    // statyczna metoda
    public static int getTotalCreated() {
        return totalCreated;
    }

    // gettery
    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public int getTotalDurationSeconds() {
        return totalDurationSeconds;
    }

    // toString()
    @Override
    public String toString() {
        return "Playlist[title=" + title +
                ", owner=" + owner +
                ", tracks=" + trackCount + "/" + MAX_TRACKS +
                ", duration=" + totalDurationSeconds + "s]";
    }
}