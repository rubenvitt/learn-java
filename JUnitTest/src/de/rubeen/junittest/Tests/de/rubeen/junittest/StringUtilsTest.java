package de.rubeen.junittest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Ruben Vitt - 19.09.17.
 */
class StringUtilsTest {
    @Test
    void testReverse() {
        assertEquals("", StringUtils.reverse(""));
        assertEquals("cba", StringUtils.reverse("abc"));
    }

}