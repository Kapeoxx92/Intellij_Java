// Pamiętaj o poprawnej nazwie klasy!
final class ImmutableVector2D {
    private final double x;
    private final double y;

    // konstruktor
    public ImmutableVector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // dodawanie wektorów
    public ImmutableVector2D add(ImmutableVector2D other) {
        return new ImmutableVector2D(this.x + other.x, this.y + other.y);
    }

    // skalowanie
    public ImmutableVector2D scale(double factor) {
        return new ImmutableVector2D(this.x * factor, this.y * factor);
    }

    // negacja
    public ImmutableVector2D negate() {
        return new ImmutableVector2D(-this.x, -this.y);
    }

    // długość wektora (zaokrąglona do 2 miejsc)
    public double length() {
        double len = Math.sqrt(x * x + y * y);
        return Math.round(len * 100.0) / 100.0;
    }

    // gettery
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // toString()
    @Override
    public String toString() {
        return "Vector2D[x=" + x + ", y=" + y + "]";
    }
}