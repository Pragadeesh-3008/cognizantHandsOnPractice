import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        assertEquals(5,2 + 3);

        assertTrue(10 > 5);

        assertFalse(2 > 10);

        assertNull(null);

        assertNotNull(new Object());
    }
}