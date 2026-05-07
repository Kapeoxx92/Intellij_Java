import java.util.Objects;

class CipherSeal {

    protected String owner;
    protected String serial;

    public CipherSeal(String owner, String serial) {
        this.owner = owner;
        this.serial = normalize(serial);
    }

    protected String normalize(String s) {
        return s.trim().toUpperCase();
    }

    public String getSerial() {
        return serial;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || other.getClass() != CipherSeal.class) return false;

        CipherSeal that = (CipherSeal) other;

        return Objects.equals(this.owner, that.owner)
                && Objects.equals(this.serial, that.serial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, serial);
    }
}
class TimedCipherSeal extends CipherSeal {

    private int expiryDay;

    public TimedCipherSeal(String owner, String serial, int expiryDay) {
        super(owner, serial);
        this.expiryDay = expiryDay;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        // ważne: różne klasy → NIGDY równe
        if (other == null || this.getClass() != other.getClass()) return false;

        TimedCipherSeal that = (TimedCipherSeal) other;

        return Objects.equals(this.owner, that.owner)
                && Objects.equals(this.serial, that.serial)
                && this.expiryDay == that.expiryDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, serial, expiryDay);
    }
}