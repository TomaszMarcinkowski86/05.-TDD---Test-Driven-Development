package foo.bar.temperature;

import foo.bar.length.Centimeter;
import foo.bar.length.Inch;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureTest {

    @Test
    void shouldConvertZeroCelciusValue() {
        Celsius celcius = new Inch(BigDecimal.ZERO).toCentimeters(); // zero watrość statyczna znaczy to samo co (vauleOf(0))
        assertEquals(BigDecimal.ZERO.setScale(4), celcius.getValue());
    }
}
