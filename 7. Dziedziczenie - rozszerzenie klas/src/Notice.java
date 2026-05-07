class Notice {

    protected String route;

    public Notice(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
class InkNotice extends Notice {

    private String subject;

    public InkNotice(String route, String subject) {
        super(route);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
class BellNotice extends Notice {

    private int rings;

    public BellNotice(String route, int rings) {
        super(route);
        this.rings = rings;
    }

    public int getRings() {
        return rings;
    }
}
class WhisperNotice extends Notice {

    private boolean sealed;

    public WhisperNotice(String route, boolean sealed) {
        super(route);
        this.sealed = sealed;
    }

    public boolean isSealed() {
        return sealed;
    }
}
class NoticeInspector {

    // diagnostyka pojedynczego komunikatu
    public static String technicalNote(Notice n) {

        if (n instanceof InkNotice) {

            InkNotice ink = (InkNotice) n;

            String subject = ink.getSubject();

            int length = subject.length();

            char firstUpper =
                    Character.toUpperCase(subject.charAt(0));

            return "INK:" + length + ":" + firstUpper;
        }

        if (n instanceof BellNotice) {

            BellNotice bell = (BellNotice) n;

            return "BELL:" + (bell.getRings() * 2);
        }

        if (n instanceof WhisperNotice) {

            WhisperNotice whisper = (WhisperNotice) n;

            if (whisper.isSealed()) {
                return "WHISPER:LOCKED";
            }

            return "WHISPER:OPEN";
        }

        return "BASE:-";
    }

    // suma wag
    public static int retryWeight(Notice[] notices) {

        int sum = 0;

        for (Notice n : notices) {

            if (n instanceof InkNotice) {

                InkNotice ink = (InkNotice) n;

                sum += ink.getSubject().length();
            }

            else if (n instanceof BellNotice) {

                BellNotice bell = (BellNotice) n;

                sum += bell.getRings() * 2;
            }

            else if (n instanceof WhisperNotice) {

                WhisperNotice whisper =
                        (WhisperNotice) n;

                sum += whisper.isSealed() ? 4 : 1;
            }

            else {
                sum += 0;
            }
        }

        return sum;
    }
}