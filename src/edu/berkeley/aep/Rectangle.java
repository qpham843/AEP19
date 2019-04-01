package edu.berkeley.aep;

import java.util.HashMap;
import java.util.Map;

public class Rectangle {
    /* A Rectangle: Understands a 4-sided figure with sides at right angles.*/
    private final int length;
    private final int width;
    private static Map<Integer, Rectangle> squaresIHaveCreated = new HashMap<>();

    public static Rectangle createSquare(int side) {
        Rectangle square;
        if (!squaresIHaveCreated.containsKey(side)) {
            squaresIHaveCreated.put(side, new Rectangle(side, side));
        }
        square = squaresIHaveCreated.get(side);
        return square;
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    int perimeter() {
        return 2*(length + width);
    }

    int area() {
        return length*width;
    }

    int squaredArea() {
        return area()*area();
    }

    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (!(obj instanceof Rectangle)) {return false;}

        Rectangle otherRect = (Rectangle) obj;
        boolean boolLength = length == otherRect.length;
        boolean boolWIdth = width == otherRect.width;
        return boolLength && boolWIdth;
    }

}
