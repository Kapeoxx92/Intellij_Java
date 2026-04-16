// Pamiętaj o poprawnej nazwie klasy!
class Password {
    private int hash;
    private int length;
    private boolean hasDigit;
    private boolean hasUppercase;

    // konstruktor
    public Password(String plainText) {
        if (plainText == null || plainText.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        store(plainText);
    }

    // zapis hasła (prywatny)
    private void store(String text) {
        this.hash = computeHash(text);
        this.length = text.length();
        this.hasDigit = false;
        this.hasUppercase = false;

        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            }
        }
    }

    // obliczanie hash
    private static int computeHash(String text) {
        int sum = 0;
        for (char c : text.toCharArray()) {
            sum += c;
        }
        return sum;
    }

    // sprawdzanie zgodności
    public boolean matches(String attempt) {
        if (attempt == null) return false;
        return computeHash(attempt) == this.hash;
    }

    // czy silne
    public boolean isStrong() {
        return length >= 8 && hasDigit && hasUppercase;
    }

    // poziom siły
    public String getStrength() {
        if (length < 6) {
            return "WEAK";
        }
        if (isStrong()) {
            return "STRONG";
        }
        return "FAIR";
    }

    // zmiana hasła
    public void changePassword(String oldPassword, String newPassword) {
        if (!matches(oldPassword)) {
            throw new IllegalArgumentException("Current password is incorrect");
        }
        if (newPassword == null || newPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("New password cannot be empty");
        }
        store(newPassword);
    }

    // toString()
    @Override
    public String toString() {
        return "Password[hash=" + hash +
                ", strong=" + isStrong() + "]";
    }
}