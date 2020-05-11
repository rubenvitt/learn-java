package de.rubeen.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Ruben Vitt - 19.09.17.
 */
public class StringUtilsTest {
    @Test
    public void testReverse() {
        assertEquals("", StringUtils.reverse(""));
        assertEquals("cba", StringUtils.reverse("abc"));
    }
}
