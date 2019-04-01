package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UnitsTest {
    @Test
    public void twelveInchesIsOneFoot() {
        var twelveInches = new ArithmeticUnits(12d, UnitType.INCHES);
        var oneFoot = new ArithmeticUnits(1d, UnitType.FEET);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void threeFeetIsOneYard() {
        var threeFeet = new ArithmeticUnits(3d, UnitType.FEET);
        var oneYard = new ArithmeticUnits(1d, UnitType.YARDS);
        assertEquals(threeFeet, oneYard);
    }

    @Test
    public void oneThousandSevenHundredSixtyYardsIsOneMile() {
        var lotsOfYards = new ArithmeticUnits(1760d, UnitType.YARDS);
        var oneMile = new ArithmeticUnits(1d, UnitType.MILES);
        assertEquals(lotsOfYards, oneMile);
    }

    @Test
    public void fiveThousandEightyFeetIsOneMile() {
        var lotsOfFeet = new ArithmeticUnits(5280d, UnitType.FEET);
        var oneMile = new ArithmeticUnits(1d, UnitType.MILES);
        assertEquals(lotsOfFeet, oneMile);
    }

    @Test
    public void oneTableSpoonIsThreeTeaSpoons() {
        var oneTableSpoon = new ArithmeticUnits(1d, UnitType.TABLESPOON);
        var threeTeaSpoons = new ArithmeticUnits(3d, UnitType.TEASPOON);
        assertEquals(oneTableSpoon, threeTeaSpoons);
    }

    @Test
    public void oneOunceIsTwoTableSpoons() {
        var oneOunce = new ArithmeticUnits(1d, UnitType.OUNCE);
        var twoTableSpoons = new ArithmeticUnits(2d, UnitType.TABLESPOON);
        assertEquals(oneOunce, twoTableSpoons);
    }

    @Test
    public void oneOunceIsSixTeaSpoons() {
        var oneOunce = new ArithmeticUnits(1d, UnitType.OUNCE);
        var sixTeaSpoons = new ArithmeticUnits(6d, UnitType.TEASPOON);
        assertEquals(oneOunce, sixTeaSpoons);
    }

    @Test
    public void eightOunceIsOneCup() {
        var eightOunce = new ArithmeticUnits(8d, UnitType.OUNCE);
        var oneCup = new ArithmeticUnits(1d, UnitType.CUP);
        assertEquals(eightOunce, oneCup);
    }

    @Test
    public void zeroFarenheitIsNotZeroCelcius() {
        var zeroFarenheit = new ScaledUnits(0d, UnitType.FAHRENHEIT);
        var zeroCelcius = new ScaledUnits(0d, UnitType.CELSIUS);
        assertNotEquals(zeroCelcius, zeroFarenheit);
    }

    @Test
    public void twoInchesplustwoInchesIsFourInches() {
        var twoInches = new ArithmeticUnits(2d, UnitType.INCHES);
        var twoMoreInches = new ArithmeticUnits(2d, UnitType.INCHES);
        assertEquals(new ArithmeticUnits(4d, UnitType.INCHES), twoInches.add(twoMoreInches));
    }

    @Test
    public void threeTeaSpoonsIsOneTableSpoon() {
        var threeTeaSpoons = new ArithmeticUnits(3d, UnitType.TEASPOON);
        var oneTableSpoon = new ArithmeticUnits(1d, UnitType.TABLESPOON);
        assertEquals(threeTeaSpoons, oneTableSpoon);
    }

    @Test
    public void twoTeaSpoonsPlusOneTeaSpoonIsOneTableSpoon() {
        var twoTeaSpoons = new ArithmeticUnits(2d, UnitType.TEASPOON);
        var oneTeaSpoon = new ArithmeticUnits(1d, UnitType.TEASPOON);
        var oneTableSpoon = new ArithmeticUnits(1d, UnitType.TABLESPOON);
        assertEquals(oneTableSpoon, oneTeaSpoon.add(twoTeaSpoons));
    }

    @Test
    public void twoTBSPIsSixTeaSpoons() {
        var twoTBSP = new ArithmeticUnits(2d, UnitType.TABLESPOON);
        var sixTeaSpoon = new ArithmeticUnits(6d, UnitType.TEASPOON);
        assertEquals(twoTBSP, sixTeaSpoon);
    }

    @Test
    public void twoHundredTwelveFarhenheitIsOneHundredCelsius() {
        var twoHundredTwelveFarenheit = new ArithmeticUnits(212d, UnitType.FAHRENHEIT);
        var oneHundredCelcius = new ArithmeticUnits(100d, UnitType.CELSIUS);
        assertEquals(twoHundredTwelveFarenheit, oneHundredCelcius);
    }

    @Test
    public void thirtyTwoFahrenheitIsZeroCelsius() {
        var thirtyTwoFahrenheit = new ScaledUnits(32d, UnitType.FAHRENHEIT);
        var zeroCelcius = new ScaledUnits(0d, UnitType.CELSIUS);
        assertEquals(thirtyTwoFahrenheit, zeroCelcius);
    }

    @Test
    public void twoCelsiusIsBetterThanZeroCelsius() {
        var twoCelcius = new ScaledUnits(2d, UnitType.CELSIUS);
        var zeroCelcius = new ScaledUnits(0d, UnitType.CELSIUS);
        assert(twoCelcius.betterThan(zeroCelcius));
    }

    @Test
    public void oneFootIsBetterThanTenInches() {
        var tenInches = new ScaledUnits(10d, UnitType.INCHES);
        var oneFoot = new ScaledUnits(1d, UnitType.FEET);
        assert(oneFoot.betterThan(tenInches));
    }
}
