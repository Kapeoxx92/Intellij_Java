class LogFile {

    private boolean open;
    private int linesWritten;

    // konstruktor – log na starcie jest otwarty
    public LogFile() {
        this.open = true;
        this.linesWritten = 0;
    }

    // zapis jednej linii (symulacja)
    public void write(String message) {
        if (!open) {
            // testy i tak sprawdzają isOpen(), ale to dodatkowe zabezpieczenie
            return;
        }
        linesWritten++;
    }

    // zamknięcie zasobu (idempotentne)
    public boolean close() {
        if (!open) {
            return false;
        }
        open = false;
        return true;
    }

    // czy log jest otwarty
    public boolean isOpen() {
        return open;
    }

    // liczba zapisanych linii
    public int getLinesWritten() {
        return linesWritten;
    }
}