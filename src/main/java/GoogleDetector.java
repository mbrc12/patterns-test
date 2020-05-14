public class GoogleDetector extends LangDetectorUtils {

    private static GoogleDetector instance;

    public static GoogleDetector getInstance() {
        if (instance == null) {
            instance = new GoogleDetector();
        }
        return instance;
    }

    @Override
    public String name() {
        return "google";
    }

    public static void register() {
        LangDetectorFactory.register(getInstance());
    }

    private GoogleDetector() {
    }

    String detectValid(String text) {
        // Write business logic to detect non-null text
        return "english";
    }
}
