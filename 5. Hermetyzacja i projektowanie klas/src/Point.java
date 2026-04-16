// Klasa Point (niemutowalna)
class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point[x=" + x + ", y=" + y + "]";
    }
}
// Klasa Circle
class Circle {
    private final Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        // defensive copy
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }

    // defensive copy przy zwracaniu
    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    public double getRadius() {
        return radius;
    }

    // sprawdzenie czy punkt jest w kole
    public boolean contains(Point p) {
        double dx = p.getX() - center.getX();
        double dy = p.getY() - center.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= radius;
    }

    // przesunięcie (nowy obiekt)
    public Circle translate(double dx, double dy) {
        Point newCenter = new Point(center.getX() + dx, center.getY() + dy);
        return new Circle(newCenter, radius);
    }

    @Override
    public String toString() {
        return "Circle[center=" + center.toString() +
                ", radius=" + radius + "]";
    }
}