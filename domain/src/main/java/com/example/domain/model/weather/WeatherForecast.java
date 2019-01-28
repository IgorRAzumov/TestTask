package com.example.domain.model.weather;

public class WeatherForecast {
    private int temperature;
    private int realFeelTemperature;
    private int pressure;
    private int  humidity;

    public static WeatherForecast Builder() {
        return new WeatherForecast();
    }

    private WeatherForecast() {
    }

    public WeatherForecast setTemperature(int temperature) {
        this.temperature = temperature;
        return this;
    }

    public WeatherForecast setRealFeelTemperature(int realFeelTemperature) {
        this.realFeelTemperature = realFeelTemperature;
        return this;
    }

    public WeatherForecast setPressure(int pressure) {
        this.pressure = pressure;
        return this;
    }

    public WeatherForecast setHumidity(int humidity) {
        this.humidity = humidity;
        return this;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getRealFeelTemperature() {
        return realFeelTemperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
