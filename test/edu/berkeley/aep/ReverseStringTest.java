package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ReverseStringTest {

    @Test
    public void reverseOfEmptyStringIsEmptyString() {
        assertEquals("", ReverseString.reverse(""));
    }

    @Test
    public void reverseOfAIsA() {
        assertEquals("A", ReverseString.reverse("A"));
    }

    @Test
    public void reverseOfABIsBA() {
        assertEquals("BA", ReverseString.reverse("AB"));
    }

    @Test
    public void reverseOfTRAPIsPART() {
        assertEquals("TRAP", ReverseString.reverse("PART"));
    }

    @Test
    public void reverseOfCATIsNottac() {
        assertNotEquals("tac", ReverseString.reverse("CAT"));
    }
}
