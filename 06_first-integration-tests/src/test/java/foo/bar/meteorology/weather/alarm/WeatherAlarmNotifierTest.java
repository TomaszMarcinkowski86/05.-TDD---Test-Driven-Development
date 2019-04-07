package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;
import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.logging.Logger;

import static org.mockito.Mockito.when;

public class WeatherAlarmNotifierTest {

    private WeatherAlarmNotifier alarmNotifier =
            new WeatherAlarmNotifier(
                new WeatherService(
                    new TemperatureProvider(),
                    new RainfallProvider(),
                    new WindSpeedProvider()
                )
            );

    TemperatureProvider temperatureProviderMock = Mockito.mock(TemperatureProvider.class);
    RainfallProvider rainfallProviderMock = Mockito.mock(RainfallProvider.class);
    WindSpeedProvider windSpeedProviderMock = Mockito.mock(WindSpeedProvider.class);

    private WeatherService weatherServiceWithMock =
            new WeatherService(
                    temperatureProviderMock,
                    rainfallProviderMock,
                    windSpeedProviderMock
            );
WeatherAlarmNotifier weatherAlarmNotifier = new WeatherAlarmNotifier(weatherServiceWithMock);
    @ParameterizedTest (name= "Alarm level is {0} ponieważ opady wynoszą{1} mm," +
            " temperatura jest równa {2} C, a wiatr wieje z prędkością {3} km/h")
    //    "Alarm Level, Opady, Temperatura, Wiatr",
    @CsvSource(value = {

            "ALL_OK,          3,          15,    20",
            "FIRST_LEVEL,   101,          36,    20",
            "SECOND_LEVEL,    3,          15,   102",
            "THIRD_LEVEL,   101,          20,    20"
    })

    void alarma(WeatherAlarmLevel level, int opady, int temp, int wiatr){
        when(temperatureProviderMock
                .getTemperature())
                .thenReturn(temp);
        when(rainfallProviderMock
                .getRainfallLevel())
                .thenReturn(opady);
        when(windSpeedProviderMock
                .getWindSpeed())
                .thenReturn(wiatr);
        Weather weatherMock = weatherServiceWithMock.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weatherMock.toString());

        Assertions.assertEquals(level, weatherAlarmNotifier.raiseLevelIfNeccessary());


    }
    //here comes your tests

}
