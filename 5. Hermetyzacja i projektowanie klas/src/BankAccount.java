// Pamiętaj o poprawnej nazwie klasy!
class BankAccount {
    // stałe klasowe
    public static final double MAX_SINGLE_DEPOSIT = 100000.0;
    public static final double MAX_SINGLE_WITHDRAWAL = 50000.0;

    // pola prywatne
    private final String iban;
    private String ownerName;
    private double balance;

    // konstruktor
    public BankAccount(String iban, String ownerName, double initialBalance) {
        if (iban == null || iban.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid IBAN");
        }
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid owner name");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.iban = iban;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // wpłata
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > MAX_SINGLE_DEPOSIT) {
            throw new IllegalArgumentException("Exceeds single deposit limit");
        }

        balance += amount;
    }

    // wypłata
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > MAX_SINGLE_WITHDRAWAL) {
            throw new IllegalArgumentException("Exceeds single withdrawal limit");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance -= amount;
    }

    // przelew
    public void transfer(BankAccount target, double amount) {
        this.withdraw(amount); // jeśli tu poleci wyjątek, dalej się nie wykona
        target.deposit(amount);
    }

    // zmiana właściciela
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid owner name");
        }
        this.ownerName = ownerName;
    }

    // gettery
    public String getIban() {
        return iban;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // toString()
    @Override
    public String toString() {
        return "BankAccount[iban=" + iban +
                ", owner=" + ownerName +
                ", balance=" + balance + "]";
    }
}