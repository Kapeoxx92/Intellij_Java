class SafeStack {
    private Integer[] data = new Integer[16];
    private int size = 0;

    public void push(int x) {
        if (this.size == this.data.length) {
            Integer [] bigger = new Integer[this.data.length * 2];
            for(int i = 0; i < this.size; i++) {
                bigger[i] = this.data[i];
            }
            this.data = bigger;
        }
        this.data[this.size++] = x;
    }

    public int pop () {
        int val = this.peek();
        this.data[size - 1] = null;
        this.size = this.size - 1;
        return val;
    }

    public int peek () {
        return data[size - 1];
    }

    public int size () {
        return this.size;
    }

    public boolean isEmpty () {
        return this.size == 0;
    }
}