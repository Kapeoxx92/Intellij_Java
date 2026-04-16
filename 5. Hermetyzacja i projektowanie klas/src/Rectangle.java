// Pamiętaj o poprawnej nazwie klasy!
class Rectangle {
    private double width;
    private double height;

    // konstruktor delegujący do setterów
    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    // settery z walidacją
    public void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        this.height = height;
    }

    // gettery
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // pole
    public double area() {
        return width * height;
    }

    // obwód
    public double perimeter() {
        return 2 * (width + height);
    }

    // czy kwadrat
    public boolean isSquare() {
        return Double.compare(width, height) == 0;
    }

    // proporcje
    public double aspectRatio() {
        return width / height;
    }

    // skalowanie (zwraca NOWY obiekt)
    public Rectangle scale(double factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Scale factor must be positive");
        }
        return new Rectangle(width * factor, height * factor);
    }

    // czy zawiera inny prostokąt
    public boolean canContain(Rectangle other) {
        return other.width <= this.width && other.height <= this.height;
    }

    // toString()
    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", height=" + height + "]";
    }
}