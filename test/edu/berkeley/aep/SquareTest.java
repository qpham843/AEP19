package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {
    @Test
    public void squareWithSideOneShouldHaveAreaOne() {
        var square = new Square(1);
        assertEquals(1, square.area());
    }
}
