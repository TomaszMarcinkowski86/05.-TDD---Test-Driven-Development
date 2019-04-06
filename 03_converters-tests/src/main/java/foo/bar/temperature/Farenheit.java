package foo.bar.temperature;

import foo.bar.length.Centimeter;

import java.math.BigDecimal;

public class Farenheit implements TemperatureUnit {

    public static final BigDecimal FARENHEIT_TO_CELSIUS =
            new BigDecimal("1.8").setScale(SCALE, ROUNDING_MODE);

    private final BigDecimal value;

    public Farenheit(BigDecimal value) {
        if (BigDecimal.ZERO.compareTo(value) > 0) {
            throw new IllegalArgumentException("Length can't be negative!");
        }
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Celsius toCelsius() {
        return new Celsius(value.multiply(FARENHEIT_TO_CELSIUS).setScale(SCALE, ROUNDING_MODE).add(BigDecimal.valueOf(32)));
    }
}
