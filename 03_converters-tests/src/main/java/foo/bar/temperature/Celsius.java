package foo.bar.temperature;

import java.math.BigDecimal;

import static foo.bar.temperature.Farenheit.FARENHEIT_TO_CELSIUS;


public class Celsius implements TemperatureUnit {

    private final BigDecimal value;


    public Celsius(BigDecimal value) {
        if (BigDecimal.ZERO.compareTo(value) > 0) {
            throw new IllegalArgumentException("Weight can't be negative!");
        }
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Kelvin toKelvin() {
        return new Kelvin(value.add(Kelvin.KELVIN_TO_CELSIUS).setScale(SCALE, ROUNDING_MODE));
    }

    public Farenheit toFarenheit() {
        return new Farenheit(value.multiply(Farenheit.FARENHEIT_TO_CELSIUS).setScale(SCALE, ROUNDING_MODE));
    }
}
