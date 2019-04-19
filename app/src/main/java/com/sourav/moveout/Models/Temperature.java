package com.sourav.moveout.Models;

public class Temperature {

    String duration;
    TemperatureC temperatureC;
    TemperatureF temperatureF;

    public Temperature(String duration, TemperatureC temperatureC, TemperatureF temperatureF) {
        this.duration = duration;
        this.temperatureC = temperatureC;
        this.temperatureF = temperatureF;
    }

    public Temperature() {
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public TemperatureC getTemperatureC() {
        return temperatureC;
    }

    public void setTemperatureC(TemperatureC temperatureC) {
        this.temperatureC = temperatureC;
    }

    public TemperatureF getTemperatureF() {
        return temperatureF;
    }

    public void setTemperatureF(TemperatureF temperatureF) {
        this.temperatureF = temperatureF;
    }
}
