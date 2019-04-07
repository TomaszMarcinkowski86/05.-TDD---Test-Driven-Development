package foo.bar.meteorology.weather;

import foo.bar.blockchain.external.GlobalIndexExternalService;
import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherServiceTest {

    private WeatherService weatherService =
        new WeatherService(
            new TemperatureProvider(),
            new RainfallProvider(),
            new WindSpeedProvider()
        );

    @Test
    void testWeatherService() {
        Weather weather = weatherService.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weather.toString());

        Assertions.assertNotNull(weather);
    }

    TemperatureProvider temperatureProviderMock = mock(TemperatureProvider.class);
    RainfallProvider rainfallProviderMock = mock(RainfallProvider.class);
    WindSpeedProvider windSpeedProviderMock = mock(WindSpeedProvider.class);

    private WeatherService weatherServiceWithMock =
            new WeatherService(
                   temperatureProviderMock,
                   rainfallProviderMock,
                    windSpeedProviderMock
            );
    @Test
    void testWeatherMock(){

        when(temperatureProviderMock
                .getTemperature())
                .thenReturn(20);
        when(rainfallProviderMock
                .getRainfallLevel())
                .thenReturn(100);
        when(windSpeedProviderMock
                .getWindSpeed())
                .thenReturn(30);
        Weather weatherMock = weatherServiceWithMock.getWeather();

        Logger.getLogger("JUnit 5").info("Current weather : " + weatherMock.toString());

        Assertions.assertNotNull(weatherServiceWithMock);
    }

}
