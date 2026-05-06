class DatabaseSimulator {

    private boolean connected;
    private String name;

    private static int openCount = 0;

    // CONNECT
    public void connect(String name) {
        this.connected = true;
        this.name = name;
        openCount++;
    }

    // QUERY
    public String query(String sql) {
        if (!connected) {
            return null;
        }
        return sql;
    }

    // CLOSE (idempotentne)
    public boolean close() {
        if (!connected) {
            return false;
        }
        connected = false;
        openCount--;
        return true;
    }

    // STATIC OPEN COUNT
    public static int getOpenCount() {
        return openCount;
    }
}