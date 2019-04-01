package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {
    @Test
    public void chanceWithProbabilityOneandNotEqualsZero() {
        var chance = new Chance(1);
        var zeroChance = new Chance(0);
        assertEquals(zeroChance, chance.not());
    }

    @Test
    public void chanceWithProbabilityHalfandHalfAreEqual() {
        var halfchance = new Chance(0.5);
        var otherhalfchance = new Chance(0.5);
        assertEquals(otherhalfchance, halfchance);
    }

    @Test
    public void notOneandZeroareEqual() {
        var oneChance = new Chance(1);
        var zeroChance = new Chance(0);
        assertEquals(zeroChance, oneChance.not());
    }

    @Test
    public void chanceWithProbabilityHalfandNotHalfAreEqual() {
        var halfchance = new Chance(0.5);
        var otherhalfchance = new Chance(0.5);
        assertEquals(otherhalfchance, halfchance.not());
    }

    @Test
    public void chanceWithEqualProbabilitySHouldHaveTheSameHashcode() {
        var coinToss = new Chance(1/2);
        var anotherCoinToss = new Chance(1/2);
        assertEquals(coinToss.hashCode(), anotherCoinToss.hashCode());
    }

    @Test
    public void notShouldProduceTheComplementForADieThrow() {
        var onefourth = new Chance(0.25);
        var threefourths = new Chance(0.75);
        assertEquals(threefourths, onefourth.not());
    }

    @Test
    public void twoCoinsBothHavingHeadsShouldHaveProbabilityOneFourth() {
        var coinOne = new Chance(0.5);
        var coinTwo = new Chance(0.5);
        var bothCoins = new Chance(0.25);
        assertEquals(bothCoins, coinOne.and(coinTwo));
    }

    @Test
    public void twoCoinsAtLeastOneIsHeadsShouldHaveProbabilityThreeFourths() {
        var coinOne = new Chance(0.5);
        var coinTwo = new Chance(0.5);
        var AtLeastOneHeadCoins = new Chance(0.75);
        assertEquals(AtLeastOneHeadCoins, coinOne.or(coinTwo));
    }

    @Test
    public void twoFourSidedDiceAtLeastOneSixShouldHaveProbabilityElevenThirtySixths() {
        var dieOne = new Chance(0.25);
        var dieTwo = new Chance(0.25);
        var atLeastOneSix = new Chance(0.4375);
        assertEquals(atLeastOneSix, dieOne.or(dieTwo));
    }
}
