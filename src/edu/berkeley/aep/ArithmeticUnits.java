package edu.berkeley.aep;

enum UnitCategory {
    DISTANCE,
    VOLUME,
    TEMPERATURE;
}

enum UnitType {
    //Understands different unit types
    FEET (12d, 0d, UnitCategory.DISTANCE),
    INCHES (1d, 0d, UnitCategory.DISTANCE),
    YARDS (36d, 0d, UnitCategory.DISTANCE),
    MILES (63360d, 0d, UnitCategory.DISTANCE),
    TEASPOON (1d, 0d, UnitCategory.VOLUME),
    TABLESPOON (3d, 0d, UnitCategory.VOLUME),
    OUNCE (6d, 0d, UnitCategory.VOLUME),
    CUP (48d, 0d, UnitCategory.VOLUME),
    FAHRENHEIT(1d, 0d, UnitCategory.TEMPERATURE),
    CELSIUS(9d/5d, 32d, UnitCategory.TEMPERATURE);

    public final Double scale;
    public final Double shift;
    public final UnitCategory unitCategory;

    UnitType(Double scale, Double shift, UnitCategory unitCategory) {
        this.scale = scale;
        this.shift = shift;
        this.unitCategory = unitCategory;
    }
}

public class ArithmeticUnits extends ScaledUnits {

    ArithmeticUnits(Double length, UnitType units) {
        super(length, units);
    }

    public ArithmeticUnits add(ArithmeticUnits other) {
        if (this.unitCategory != other.unitCategory) {
            throw new RuntimeException("Cannot add two units of different categories!");
        }
        return new ArithmeticUnits(this.value + other.value, this.unitType);
    }
}
