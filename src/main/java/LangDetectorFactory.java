import java.util.HashMap;
import java.util.Map;

public class LangDetectorFactory {

    static {
        GoogleDetector.register();
    }

    private static Map<String, LangDetector> instances;

    public static LangDetector getDetector (String name) {
        if (instances == null || !instances.containsKey(name)) {
            throw new AssertionError();
        }
        return instances.get(name);
    }

    public static void register(LangDetector detector) {
        if (instances == null) {
            instances = new HashMap<>();
        }
        instances.put(detector.name(), detector);
    }

    // Stop others from instantiating this class.
    private LangDetectorFactory() {}
}
