import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {
    private MyMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new MyMap<>();
    }

    @Test
    void canMakeEmptyMap() {
        assertEquals(0, map.size());
        assertFalse(map.contains("C"));
        assertEquals(null, map.get("C"));
    }

    @Test
    void canPutOneElement() {
        map.put("C", 10);
        assertTrue(map.contains("C"));
        assertEquals(10, map.get("C"));
        assertEquals(1, map.size());
    }

    @Test
    void canPutRootLeft() {
        map.put("C", 10);
        map.put("B", 20);
        assertTrue(map.contains("C"));
        assertTrue(map.contains("B"));
        assertEquals(10, map.get("C"));
        assertEquals(20, map.get("B"));
        assertEquals(2, map.size());
    }

    @Test
    void canPutRootRight() {
        map.put("C", 10);
        map.put("E", 30);
        assertTrue(map.contains("C"));
        assertTrue(map.contains("E"));
        assertEquals(10, map.get("C"));
        assertEquals(30, map.get("E"));
        assertEquals(2, map.size());
    }

}