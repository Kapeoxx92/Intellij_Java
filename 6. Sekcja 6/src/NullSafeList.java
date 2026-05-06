class NullSafeList {

    private int[] data;
    private int size;

    // konstruktor
    public NullSafeList() {
        data = new int[10]; // początkowa pojemność
        size = 0;
    }

    // dodawanie elementu
    public void add(int value) {
        ensureCapacity();
        data[size] = value;
        size++;
    }

    // pobieranie elementu
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    // sprawdzanie czy zawiera
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return true;
            }
        }
        return false;
    }

    // aktualny rozmiar
    public int size() {
        return size;
    }

    // reprezentacja tekstowa
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // powiększanie tablicy gdy brak miejsca
    private void ensureCapacity() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
}