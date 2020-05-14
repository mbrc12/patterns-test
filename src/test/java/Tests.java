import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

public class Tests {

    @Test
    public void simpleTestSuccess() {
        LangDetector detector = LangDetectorFactory.getDetector("google");
        assertEquals("english", detector.detect("Hello"));
    }

    @Test
    public void simpleTestFail() {
        LangDetector detector = LangDetectorFactory.getDetector("google");
        assertThrows(AssertionError.class, () -> detector.detect(null));
    }

    @Test
    public void threadTest() {
        AtomicReference<LangDetector> detector1 = new AtomicReference<>();
        AtomicReference<LangDetector> detector2 = new AtomicReference<>();
        Thread t1 = new Thread(() -> detector1.set(LangDetectorFactory.getDetector("google")));
        Thread t2 = new Thread(() -> detector2.set(LangDetectorFactory.getDetector("google")));
        t1.start();
        t2.start();
        assertEquals(detector1.get(), detector2.get());
    }
}
