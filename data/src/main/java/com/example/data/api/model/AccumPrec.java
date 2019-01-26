
package com.example.data.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccumPrec {
    @SerializedName("1")
    @Expose
    private Double first;
    @SerializedName("3")
    @Expose
    private Double third;
    @SerializedName("7")
    @Expose
    private Double seven;

    public Double getFirst() {
        return first;
    }

    public void setFirst(Double value) {
        this.first = value;
    }

    public Double get3() {
        return third;
    }

    public void setThird(Double value) {
        this.third = value;
    }

    public Double getSeventh() {
        return seven;
    }

    public void setSeventh(Double value) {
        this.seven = value;
    }

}
