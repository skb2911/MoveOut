package com.sourav.moveout.Models;

public class TemperatureF {

    String max, min;

    public TemperatureF(String max, String min) {
        this.max = max;
        this.min = min;
    }

    public TemperatureF() {
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
