class CircularBuffer {

    private String[] buffer;
    private int capacity;
    private int size;
    private int start; // indeks najstarszego
    private int end;   // indeks miejsca zapisu

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new String[capacity];
        this.size = 0;
        this.start = 0;
        this.end = 0;
    }

    // ADD
    public void add(String value) {
        buffer[end] = value;

        end = (end + 1) % capacity;

        if (size == capacity) {
            // nadpisujemy najstarszy -> start przesuwa się
            start = (start + 1) % capacity;
        } else {
            size++;
        }
    }

    // GET (od najstarszego)
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int realIndex = (start + index) % capacity;
        return buffer[realIndex];
    }

    // SIZE
    public int size() {
        return size;
    }

    // ISFULL
    public boolean isFull() {
        return size == capacity;
    }

    // TOSTRING
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}