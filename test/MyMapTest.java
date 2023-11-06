import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
        assertEquals(Optional.empty(), map.get("C"));
    }

    @Test
    void canPutOneElement() {
        map.put("C", 10);
        assertTrue(map.contains("C"));
        assertEquals(Optional.of(10), map.get("C"));
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
        assertEquals(Optional.of(10), map.get("C"));
        assertEquals(Optional.of(20), map.get("B"));
        assertEquals(Optional.empty(), map.get("E"));
        assertEquals(Optional.empty(), map.get("A"));
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
        assertEquals(Optional.of(10), map.get("C"));
        assertEquals(Optional.of(30), map.get("E"));
        assertEquals(Optional.empty(), map.get("B"));
        assertEquals(Optional.empty(), map.get("F"));
        assertEquals(Optional.empty(), map.get("D"));
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
        assertEquals(Optional.of(10), map.get("C"));
        assertEquals(Optional.of(20), map.get("B"));
        assertEquals(Optional.of(30), map.get("A"));
        assertEquals(Optional.empty(), map.get("E"));
        assertEquals(3, map.size());
        map.forEach( (k, v) -> {
            System.out.println(k + v);
        });
    }

}