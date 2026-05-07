class StationBadge {

    protected String stationCode;
    protected String trace;

    public StationBadge(String stationCode) {
        this.stationCode = stationCode;
        this.trace = "STATION(" + stationCode + ")";
    }

    public String getInitTrace() {
        return trace;
    }
}
class ShiftBadge extends StationBadge {

    protected String shiftCode;

    public ShiftBadge(String stationCode, String shiftCode) {
        super(stationCode);
        this.shiftCode = shiftCode;

        this.trace = this.trace + ">SHIFT(" + shiftCode + ")";
    }
}
class EmergencyBadge extends ShiftBadge {

    private int priority;

    public EmergencyBadge(String stationCode, String shiftCode, int priority) {
        super(stationCode, shiftCode);
        this.priority = priority;

        this.trace = this.trace + ">EMERGENCY(" + priority + ")";
    }

    public String badgeLine() {
        return stationCode + "/" + shiftCode + "/" + priority;
    }
}