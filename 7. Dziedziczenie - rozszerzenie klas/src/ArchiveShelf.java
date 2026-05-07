class ArchiveShelf {

    private String sectionCode;
    private int widthCm;

    public ArchiveShelf(String sectionCode, int widthCm) {
        this.sectionCode = sectionCode;
        this.widthCm = widthCm;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public String label() {
        return sectionCode + "/" + widthCm;
    }
}
class ReservedArchiveShelf extends ArchiveShelf {

    private int reservedCm;

    public ReservedArchiveShelf(String sectionCode, int widthCm, int reservedCm) {
        super(sectionCode, widthCm);
        this.reservedCm = reservedCm;
    }

    // wolna przestrzeń (nie może być ujemna)
    public int freeWidth() {
        int free = getWidthCm() - reservedCm;
        return Math.max(0, free);
    }

    // czy się mieści
    public boolean canFit(int requestCm) {
        return requestCm <= freeWidth();
    }
}