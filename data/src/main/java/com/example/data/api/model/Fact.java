
package com.example.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fact {

    @SerializedName("temp")
    @Expose
    private Integer temp;
    @SerializedName("feels_like")
    @Expose
    private Integer feelsLike;
    @SerializedName("pressure_mm")
    @Expose
    private Integer pressureMm;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public void setFeelsLike(Integer feelsLike) {
        this.feelsLike = feelsLike;
    }

    public void setPressureMm(Integer pressureMm) {
        this.pressureMm = pressureMm;
    }

    public void setPressurePa(Integer pressureMm) {
        this.pressureMm= pressureMm;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getTemp() {
        return temp;
    }

    public Integer getFeelsLike() {
        return feelsLike;
    }

    public Integer getPressureMm() {
        return pressureMm;
    }

    public Integer getHumidity() {
        return humidity;
    }


}
