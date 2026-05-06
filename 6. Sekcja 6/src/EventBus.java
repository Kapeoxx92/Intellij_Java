class EventBus {

    private String[] events;
    private String[] listeners;
    private int size;

    public EventBus() {
        events = new String[10];
        listeners = new String[10];
        size = 0;
    }

    // SUBSCRIBE
    public void subscribe(String event, String listener) {
        ensureCapacity();
        events[size] = event;
        listeners[size] = listener;
        size++;
    }

    // UNSUBSCRIBE (usuwa pierwsze dopasowanie)
    public void unsubscribe(String event, String listener) {
        for (int i = 0; i < size; i++) {
            if (events[i].equals(event) && listeners[i].equals(listener)) {

                // przesuwanie w lewo
                for (int j = i; j < size - 1; j++) {
                    events[j] = events[j + 1];
                    listeners[j] = listeners[j + 1];
                }

                size--;
                return;
            }
        }
    }

    // PUBLISH
    public String[] publish(String event) {

        String[] temp = new String[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (events[i].equals(event)) {
                temp[count++] = listeners[i];
            }
        }

        // przycięcie do dokładnego rozmiaru
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // dynamiczne powiększanie
    private void ensureCapacity() {
        if (size == events.length) {
            String[] newEvents = new String[events.length * 2];
            String[] newListeners = new String[listeners.length * 2];

            for (int i = 0; i < size; i++) {
                newEvents[i] = events[i];
                newListeners[i] = listeners[i];
            }

            events = newEvents;
            listeners = newListeners;
        }
    }
}