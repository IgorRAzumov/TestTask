package com.example.domain.model.weather;

public class WeatherForecast {
    private int temperature;
    private int  realFeelTtemperature;
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
        this.realFeelTtemperature = realFeelTemperature;
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

    public int getRealFeelTtemperature() {
        return realFeelTtemperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
