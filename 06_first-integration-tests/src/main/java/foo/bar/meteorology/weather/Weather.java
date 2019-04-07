package foo.bar.meteorology.weather;

import foo.bar.blockchain.external.GlobalIndexExternalService;

public class Weather {

    private int temprature;
    private int windSpeed;
    private int rainfall;

    public Weather(int temprature, int windSpeed, int rainfall) {
        this.temprature = temprature;
        this.windSpeed = windSpeed;
        this.rainfall = rainfall;
    }

    public Weather(WeatherService calcMock) {

    }

    public int getTemprature() {
        return temprature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getRainfall() {
        return rainfall;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temprature=" + temprature + " C " +
                ", windSpeed=" + windSpeed + " km/h " +
                ", rainfall=" + rainfall + " mm/day " +
                '}';
    }
}
