public abstract class LangDetectorUtils implements LangDetector {

    // package private member to detect auto-validated text.
    abstract String detectValid(String text);

    public String detect(String text) {
        if (text == null) throw new AssertionError();
        return detectValid(text);
    }
    public abstract String name();
}
