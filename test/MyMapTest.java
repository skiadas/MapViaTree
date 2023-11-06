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
        assertFalse(map.contains("E"));
        assertFalse(map.contains("A"));
        assertEquals(10, map.get("C"));
        assertEquals(20, map.get("B"));
        assertEquals(null, map.get("E"));
        assertEquals(null, map.get("A"));
        assertEquals(2, map.size());
    }

    @Test
    void canPutRootRight() {
        map.put("C", 10);
        map.put("E", 30);
        assertTrue(map.contains("C"));
        assertTrue(map.contains("E"));
        assertFalse(map.contains("B"));
        assertFalse(map.contains("F"));
        assertFalse(map.contains("D"));
        assertEquals(10, map.get("C"));
        assertEquals(30, map.get("E"));
        assertEquals(null, map.get("B"));
        assertEquals(null, map.get("F"));
        assertEquals(null, map.get("D"));
        assertEquals(2, map.size());
    }

    @Test
    void canPutRootLeftLeft() {
        map.put("C", 10);
        map.put("B", 20);
        map.put("A", 30);
        assertTrue(map.contains("C"));
        assertTrue(map.contains("B"));
        assertTrue(map.contains("A"));
        assertFalse(map.contains("E"));
        assertEquals(10, map.get("C"));
        assertEquals(20, map.get("B"));
        assertEquals(30, map.get("A"));
        assertEquals(null, map.get("E"));
        assertEquals(3, map.size());
        map.forEach( (k, v) -> {
            System.out.println(k + v);
        });
    }

}