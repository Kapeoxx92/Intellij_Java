class ObjectPool {

    private int[] pool;
    private int size;
    private int nextId;

    public ObjectPool() {
        pool = new int[10];
        size = 0;
        nextId = 1;
    }

    // ACQUIRE
    public int acquire() {
        if (size > 0) {
            return pool[--size]; // LIFO z puli
        }
        return nextId++; // nowy identyfikator
    }

    // RELEASE
    public void release(int id) {
        ensureCapacity();
        pool[size++] = id;
    }

    // POOLSIZE
    public int poolSize() {
        return size;
    }

    // powiększanie tablicy
    private void ensureCapacity() {
        if (size == pool.length) {
            int[] newPool = new int[pool.length * 2];
            for (int i = 0; i < pool.length; i++) {
                newPool[i] = pool[i];
            }
            pool = newPool;
        }
    }
}