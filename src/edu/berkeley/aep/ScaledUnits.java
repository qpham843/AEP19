package edu.berkeley.aep;

public class ScaledUnits implements Bestable {
    //Understands comparing different scales of units.
    protected final Double value;
    protected final UnitType unitType;
    protected final UnitCategory unitCategory;

    public ScaledUnits(Double length, UnitType units) {
        this.value = length*units.scale + units.shift;
        this.unitType = units;
        this.unitCategory = units.unitCategory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledUnits)) {
            return false;
        }
        ScaledUnits other = (ScaledUnits) obj;
        if (!this.unitCategory.equals(other.unitCategory)) {
            throw new IllegalArgumentException("Cannot compare " + this.unitCategory + " to " + other.unitCategory);
        }
        return this.unitCategory.equals(other.unitCategory) && this.value.equals(other.value);
    }

    @Override
    public boolean betterThan(Bestable another) {
        ScaledUnits other = (ScaledUnits) another;
        if (!this.unitCategory.equals(other.unitCategory)) {
            throw new IllegalArgumentException("Cannot compare " + this.unitCategory + " to " + other.unitCategory);
        }
        return this.value > other.value && this.unitCategory.equals(other.unitCategory);
    }
}
