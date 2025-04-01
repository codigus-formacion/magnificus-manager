package magnificus.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PathKeyTest {

    @ParameterizedTest
    @MethodSource("generateOkPathKeys")
    void testOfThenOk(String string) {
        assertEquals(PathKey.of(string).toString(), string);
    }

    static Collection<String> generateOkPathKeys() {
        return Arrays.asList(
            "/docs",
            "/docs/t1software",
            "/docs/d2domains/d1miscellany",
            "/docs/a3applications/d2domains/t1software");
    }

    @ParameterizedTest
    @MethodSource("generateFailPathKeys")
    void testOfThenFail(String string) {
        assertThrows(AssertionError.class, () -> {
            PathKey.of(string);
        });
    }

    static Collection<String> generateFailPathKeys() {
        return Arrays.asList(
            "",
            "docs/t1software",
            "/docs/d2domains//d1miscellany",
            "/docs/a3applications/d2domains/t1software/");
    }

    @Test
    void testEquals() {
        assertEquals(PathKey.of("/docs"), PathKey.of("/docs"));
        assertEquals(PathKey.of("/docs/t1software"), PathKey.of("/docs/t1software"));
        assertEquals(PathKey.of("/docs/d2domains/d1miscellany"), PathKey.of("/docs/d2domains/d1miscellany"));
        assertEquals(PathKey.of("/docs/a3applications/d2domains/t1software"), PathKey.of("/docs/a3applications/d2domains/t1software"));
    }

    @Test
    void testHead() {

    }

    @Test
    void testHasTail() {

    }

    @Test
    void testTail() {

    }

    @Test
    void testIsDescendant() {
        assertTrue(PathKey.of("/docs/d2domains/d2values").isDescendant(PathKey.of("/docs/d2domains")));
    }

    @Test
    void testAdd() {

    }

    @Test
    void testToString() {

    }
}
