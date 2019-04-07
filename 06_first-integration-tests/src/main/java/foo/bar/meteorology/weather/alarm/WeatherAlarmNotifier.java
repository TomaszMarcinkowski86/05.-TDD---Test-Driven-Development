package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;

public class WeatherAlarmNotifier {

    private WeatherService weatherService;

    public WeatherAlarmNotifier(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherAlarmLevel raiseLevelIfNeccessary() {
        Weather weather = weatherService.getWeather();
        WeatherAlarmLevel level = WeatherAlarmLevel.ALL_OK;
        int liczbaWywolanAlarmu = 0;
        if(weather.getTemprature()>35){
            level = WeatherAlarmLevel.SECOND_LEVEL;
            liczbaWywolanAlarmu =liczbaWywolanAlarmu+1;
        }
        if(weather.getWindSpeed()>100){
            level = WeatherAlarmLevel.SECOND_LEVEL;
            liczbaWywolanAlarmu = liczbaWywolanAlarmu+1;
        }
        if(weather.getRainfall()>100){
            level = WeatherAlarmLevel.THIRD_LEVEL;
            liczbaWywolanAlarmu = liczbaWywolanAlarmu+1;
        }
        if(liczbaWywolanAlarmu ==0){
            return WeatherAlarmLevel.ALL_OK;
        }else if(liczbaWywolanAlarmu==1){
            return level;
        }else return WeatherAlarmLevel.FIRST_LEVEL;

    }
}
