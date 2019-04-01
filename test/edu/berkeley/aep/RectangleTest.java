package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
    @Test
    public void rectangleWithSideOneShouldHaveAreaOne() {
        var rectangle = new Rectangle(1, 1);
        assertEquals(1, rectangle.area());
    }
    @Test
    public void rectangleWithSideOneShouldHaveSquaredAreaOne() {
        var rectangle = new Rectangle(1, 1);
        assertEquals(1, rectangle.squaredArea());
    }
    @Test
    public void rectangleWithSidesTwoShouldHaveSquaredAreaSixteen() {
        var rectangle = new Rectangle(2, 2);
        assertEquals(16, rectangle.squaredArea());
    }

    @Test
    public void squareOfSideThreeShouldHaveAreaNine() {
        var square = Rectangle.createSquare(3);
        assertEquals(9, square.area());
    }
}
