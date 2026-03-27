import java.util.Scanner;

// Pamiętaj o poprawnej nazwie klasy!
class Song {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
        // TODO: Dodaj prywatne pola: String title, String artist, int durationSeconds
        private String title;
        private String artist;
        private int durationSeconds;

        // TODO: Dodaj konstruktor: Song(String title, String artist, int durationSeconds)
    public Song(String title, String artist, int durationSeconds){
            this.title = title;
            this.artist = artist;
            this.durationSeconds = durationSeconds;
        }

        // TODO: Dodaj gettery: getTitle(), getArtist(), getDurationSeconds()
        public String getTitle () {
            return title;
        }
        public String getArtist () {
            return artist;
        }
        public int getDurationSeconds () {
            return durationSeconds;
        }

        // TODO: Zaimplementuj getFormattedDuration() — format MM:SS
        public void getFormattedDuration () {

        }

        // TODO: Zaimplementuj toString()
        // Format: "[title]" by [artist] ([MM:SS])
        public String toString () {
            return "Song"[title + " by " + artist + ([MM:SS])]";
        }
    }