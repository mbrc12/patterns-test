import java.util.concurrent.atomic.AtomicReference;

public class GoogleDetector extends LangDetectorUtils {

    private static GoogleDetector instance;
    // Provide an Object to lock on
    private static final Object lock = new Object();

    public static GoogleDetector getInstance() {
        // Two threads cannot simultaneously set instance.
        synchronized (lock) {
            if (instance == null) {
                instance = new GoogleDetector();
            }
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
