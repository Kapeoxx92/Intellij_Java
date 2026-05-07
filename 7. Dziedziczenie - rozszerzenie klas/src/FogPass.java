class FogPass {

    private String owner;
    private int baseMinutes;

    public FogPass(String owner, int baseMinutes) {
        this.owner = owner;
        this.baseMinutes = baseMinutes;
    }

    public String getOwner() {
        return owner;
    }

    public int getBaseMinutes() {
        return baseMinutes;
    }

    public String describe() {
        return owner + ":" + baseMinutes;
    }
}
class StampedFogPass extends FogPass {

    private String gateMark;
    private int extraMinutes;

    public StampedFogPass(String owner, int baseMinutes, String gateMark, int extraMinutes) {
        super(owner, baseMinutes);
        this.gateMark = gateMark;
        this.extraMinutes = extraMinutes;
    }

    public int totalMinutes() {
        return getBaseMinutes() + extraMinutes;
    }

    @Override
    public String describe() {
        return getOwner() + "@" + gateMark + "=" + totalMinutes();
    }
}