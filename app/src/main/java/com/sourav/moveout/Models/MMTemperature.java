package com.sourav.moveout.Models;

public class MMTemperature {
    TemperatureC temperatureC;
    TemperatureF temperatureF;

    public MMTemperature(TemperatureC temperatureC, TemperatureF temperatureF) {
        this.temperatureC = temperatureC;
        this.temperatureF = temperatureF;
    }

    public MMTemperature() {
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
