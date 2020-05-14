import java.util.HashMap;
import java.util.Map;

public class LangDetectorFactory {

    private static Map<String, LangDetector> instances;
    private final static Object instancesLock = new Object();

    static {
        GoogleDetector.register();
    }

    public static LangDetector getDetector (String name) {
        synchronized (instancesLock) {
            if (instances == null || !instances.containsKey(name)) {
                throw new AssertionError();
            }
            return instances.get(name);
        }
    }

    public static void register(LangDetector detector) {
        synchronized (instancesLock) {
            if (instances == null) instances = new HashMap<>();
            instances.put(detector.name(), detector);
        }
    }

    // Stop others from instantiating this class.
    private LangDetectorFactory() {}
}
