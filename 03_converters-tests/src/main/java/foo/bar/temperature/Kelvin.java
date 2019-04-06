package foo.bar.temperature;

import foo.bar.length.Centimeter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Kelvin implements TemperatureUnit {
    public static final BigDecimal KELVIN_TO_CELSIUS =
            new BigDecimal("273.15").setScale(SCALE, ROUNDING_MODE);

    private final BigDecimal value;

    public Kelvin(BigDecimal value) {
        if (BigDecimal.ZERO.compareTo(value) > 0) {
            throw new IllegalArgumentException("Length can't be negative!");
        }
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Celsius toCelcius() {
        return new Celsius(value.subtract(KELVIN_TO_CELSIUS).setScale(SCALE, ROUNDING_MODE));
    }
}
