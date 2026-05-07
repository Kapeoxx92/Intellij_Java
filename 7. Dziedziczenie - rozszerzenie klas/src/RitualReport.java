abstract class RitualReport {

    // template method
    final String generate() {
        return header() + "\n"
                + "--" + "\n"
                + body() + "\n"
                + "--" + "\n"
                + footer();
    }

    protected abstract String header();

    protected abstract String body();

    // domyślna stopka
    protected String footer() {
        return "seal=plain";
    }
}
class LanternRollCallReport extends RitualReport {

    private String hallName;
    private int litCount;
    private int dimCount;

    public LanternRollCallReport(String hallName, int litCount, int dimCount) {
        this.hallName = hallName;
        this.litCount = litCount;
        this.dimCount = dimCount;
    }

    @Override
    protected String header() {
        return "hall=" + hallName;
    }

    @Override
    protected String body() {
        int sum = litCount + dimCount;

        return "lit=" + litCount
                + ",dim=" + dimCount
                + ",sum=" + sum;
    }

    @Override
    protected String footer() {

        if (dimCount == 0) {
            return "seal=clear";
        }

        return super.footer();
    }
}