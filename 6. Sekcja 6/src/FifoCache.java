class FifoCache {

    private String[] keys;
    private String[] values;
    private int size;
    private int capacity;

    public FifoCache(int capacity) {
        this.capacity = capacity;
        this.keys = new String[capacity];
        this.values = new String[capacity];
        this.size = 0;
    }

    // PUT
    public void put(String key, String value) {

        // 1. jeśli klucz istnieje -> tylko aktualizacja
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return; // NIE zmieniamy kolejności FIFO
            }
        }

        // 2. jeśli brak miejsca -> usuń najstarszy (index 0)
        if (size == capacity) {
            removeOldest();
        }

        // 3. dodaj nowy na koniec
        keys[size] = key;
        values[size] = value;
        size++;
    }

    // GET
    public String get(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    // CONTAINS
    public boolean contains(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    // SIZE
    public int size() {
        return size;
    }

    // usuwanie najstarszego elementu (FIFO)
    private void removeOldest() {
        for (int i = 1; i < size; i++) {
            keys[i - 1] = keys[i];
            values[i - 1] = values[i];
        }
        size--;
    }
}