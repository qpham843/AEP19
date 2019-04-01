package edu.berkeley.aep;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BestableComparerTest {
    @Test
    public void bestOfOneInch2Inch3InchIsThreeInch() {
        var oneInch = new ScaledUnits(1d, UnitType.INCHES);
        var twoInch = new ScaledUnits(2d, UnitType.INCHES);
        var threeInch = new ScaledUnits(3d, UnitType.INCHES);
        assertEquals(threeInch, new BestableComparer(oneInch, twoInch, threeInch).getBest());
    }

    @Test
    public void bestOfCertainProbabilityandHalfProbabilityIsCertainProbability() {
        var certainProbability = new Chance(1d);
        var halfProbability = new Chance(0.5);
        assertEquals(certainProbability, new BestableComparer(halfProbability, certainProbability).getBest());
    }

    @Test
    public void bestOfZeroProbabilityandHalfProbabilityIsHalfProbability() {
        var zeroProbability = new Chance(0d);
        var halfProbability = new Chance(0.5);
        assertEquals(zeroProbability, new BestableComparer(halfProbability, zeroProbability).getBest());
    }

    @Test
    public void sortedBestToWorstofZeroProbabilityAndHalfProbabilityIsHalfAndZeroProbability() {
        var zeroProbability = new Chance(0d);
        var halfProbability = new Chance(0.5);
        Bestable[] sorted = new Bestable[2];
        sorted[0] = halfProbability;
        sorted[1] = zeroProbability;
        assertEquals(sorted, new BestableComparer(zeroProbability, halfProbability).getSorted());
    }
}
