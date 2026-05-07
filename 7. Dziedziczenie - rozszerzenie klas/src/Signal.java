class Signal {

    protected String id;
    protected int basePower;

    public Signal(String id, int basePower) {
        this.id = id;
        this.basePower = basePower;
    }

    public int power() {
        return basePower;
    }

    public String preview() {
        return "BASE[" + id + "]=" + power();
    }
}
class EchoSignal extends Signal {

    private int echoCount;

    public EchoSignal(String id, int basePower, int echoCount) {
        super(id, basePower);
        this.echoCount = echoCount;
    }

    @Override
    public int power() {
        return basePower + echoCount * 2;
    }

    @Override
    public String preview() {
        return "ECHO[" + id + "]=" + power();
    }
}
class BurstSignal extends Signal {

    private int burstWidth;

    public BurstSignal(String id, int basePower, int burstWidth) {
        super(id, basePower);
        this.burstWidth = burstWidth;
    }

    @Override
    public int power() {
        return basePower * burstWidth;
    }

    @Override
    public String preview() {
        return "BURST[" + id + "]=" + power();
    }
}
class ManualSignal extends Signal {

    private boolean confirmed;

    public ManualSignal(String id, int basePower, boolean confirmed) {
        super(id, basePower);
        this.confirmed = confirmed;
    }

    @Override
    public int power() {

        if (confirmed) {
            return basePower + 5;
        }

        return Math.max(0, basePower - 3);
    }

    @Override
    public String preview() {
        return "MANUAL[" + id + "]=" + power();
    }
}
class SignalDesk {

    public static int totalPower(Signal[] arr) {

        int sum = 0;

        for (Signal s : arr) {
            sum += s.power();
        }

        return sum;
    }

    public static String strongestPreview(Signal[] arr) {

        if (arr.length == 0) {
            return "";
        }

        Signal best = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i].power() > best.power()) {
                best = arr[i];
            }
        }

        return best.preview();
    }
}