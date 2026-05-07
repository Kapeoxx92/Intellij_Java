class MuseumTag {

    protected String title;
    protected String room;

    public MuseumTag(String title, String room) {
        this.title = title;
        this.room = room;
    }

    public String tagLine() {
        return room + ":" + title;
    }
}
class RestoredMuseumTag extends MuseumTag {

    private int repairedIn;

    public RestoredMuseumTag(String title, String room, int repairedIn) {
        super(title, room);
        this.repairedIn = repairedIn;
    }

    @Override
    public String tagLine() {
        return room + ":" + title + "#" + repairedIn;
    }

    public int yearsSinceRepair(int currentYear) {
        return currentYear - repairedIn;
    }

    public String reviewBand(int currentYear) {
        int years = yearsSinceRepair(currentYear);

        if (years >= 100) {
            return "LEGACY";
        }
        return "FRESH";
    }
}