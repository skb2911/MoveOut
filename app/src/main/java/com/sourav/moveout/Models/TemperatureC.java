package com.sourav.moveout.Models;

public class TemperatureC {
    String max, min;

    public TemperatureC(String max, String min) {
        this.max = max;
        this.min = min;
    }

    public TemperatureC() {
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
