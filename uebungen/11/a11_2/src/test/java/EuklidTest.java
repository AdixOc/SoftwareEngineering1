import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuklidTest {

    @Test
    void ggT() {
        Euklid euklid = new Euklid();
        assertEquals(1, euklid.ggT(1, 1)); // counter = 1
        assertEquals(1, euklid.ggT(2, 1)); // counter = 2
        assertEquals(1, euklid.ggT(1, 2)); // counter = 2
        assertEquals(2, euklid.ggT(0, 2)); // counter = 0
        assertEquals(2, euklid.ggT(512, 64)); // counter = 8
    }
}