import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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

}
