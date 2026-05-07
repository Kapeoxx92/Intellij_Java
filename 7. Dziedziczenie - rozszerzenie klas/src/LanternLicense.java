final class LanternLicense {

    private final String code;
    private final int expiryDay;

    public LanternLicense(String code, int expiryDay) {
        this.code = code;
        this.expiryDay = expiryDay;
    }

    // MASKOWANIE
    public String masked() {
        if (code.length() <= 4) {
            return code;
        }

        String first = code.substring(0, 2);
        String last = code.substring(code.length() - 2);

        StringBuilder stars = new StringBuilder();
        for (int i = 0; i < code.length() - 4; i++) {
            stars.append("*");
        }

        return first + stars + last;
    }

    // czy wygasła
    public boolean isExpired(int currentDay) {
        return currentDay > expiryDay;
    }

    // ZWRACA NOWY OBIEKT (immutability)
    public LanternLicense renew(int extraDays) {
        return new LanternLicense(code, expiryDay + extraDays);
    }

    public int getExpiryDay() {
        return expiryDay;
    }
}