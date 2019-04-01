package edu.berkeley.aep;

public class Chance implements Bestable{
    // Understands the probability of a particular outcome
    private double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    public Chance not() {
        return new Chance(1 - this.probability);
    }

    public Chance and(Chance other) {
        double combinedProbability = probability*other.probability;
        return new Chance(combinedProbability);
    }

    public Chance or(Chance other) {
        double combinedProbability = probability*other.probability;
        double sumProbability = probability + other.probability;
        return new Chance(sumProbability - combinedProbability);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Chance)) {
            return false;
        }
        return Double.compare(probability, ((Chance) obj).probability) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    @Override
    public boolean betterThan(Bestable another) {
        Chance other = (Chance) another;
        return this.probability > other.probability;
    }
}
