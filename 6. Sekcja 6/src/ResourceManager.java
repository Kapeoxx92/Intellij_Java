class ResourceManager {

    private String[] resources;
    private int size;

    public ResourceManager() {
        resources = new String[10];
        size = 0;
    }

    // REGISTER
    public void register(String name) {
        ensureCapacity();
        resources[size++] = name;
    }

    // CLOSEALL (LIFO + opróżnienie)
    public String[] closeAll() {

        String[] result = new String[size];

        // odwrócenie kolejności
        for (int i = 0; i < size; i++) {
            result[i] = resources[size - 1 - i];
        }

        // reset stanu
        size = 0;

        return result;
    }

    // STATUS
    public int status() {
        return size;
    }

    // powiększanie tablicy
    private void ensureCapacity() {
        if (size == resources.length) {
            String[] newArr = new String[resources.length * 2];
            for (int i = 0; i < resources.length; i++) {
                newArr[i] = resources[i];
            }
            resources = newArr;
        }
    }
}