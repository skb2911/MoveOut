package com.sourav.moveout.Models;

public class SNTemperature {
    TemperatureC temperatureC;
    TemperatureF temperatureF;

    public SNTemperature(TemperatureC temperatureC, TemperatureF temperatureF) {
        this.temperatureC = temperatureC;
        this.temperatureF = temperatureF;
    }

    public SNTemperature() {
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
