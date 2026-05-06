class TimedBlock {

    private String[] stack;
    private int size;

    public TimedBlock() {
        stack = new String[10];
        size = 0;
    }

    public void start(String name) {
        ensureCapacity();
        stack[size++] = name;
    }

    public String stop() {
        return stack[--size];
    }

    private void ensureCapacity() {
        if (size == stack.length) {
            String[] newStack = new String[stack.length * 2];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
    }
}