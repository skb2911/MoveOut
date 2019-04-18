package com.sourav.moveout.Models;

public class LocalWeather {
    DFTemperature dfTemperature;
    MMTemperature mmTemperature;
    JATemperature jaTemperature;
    SNTemperature snTemperature;

    public LocalWeather(DFTemperature dfTemperature, MMTemperature mmTemperature, JATemperature jaTemperature, SNTemperature snTemperature) {
        this.dfTemperature = dfTemperature;
        this.mmTemperature = mmTemperature;
        this.jaTemperature = jaTemperature;
        this.snTemperature = snTemperature;
    }

    public LocalWeather() {
    }

    public DFTemperature getDfTemperature() {
        return dfTemperature;
    }

    public void setDfTemperature(DFTemperature dfTemperature) {
        this.dfTemperature = dfTemperature;
    }

    public MMTemperature getMmTemperature() {
        return mmTemperature;
    }

    public void setMmTemperature(MMTemperature mmTemperature) {
        this.mmTemperature = mmTemperature;
    }

    public JATemperature getJaTemperature() {
        return jaTemperature;
    }

    public void setJaTemperature(JATemperature jaTemperature) {
        this.jaTemperature = jaTemperature;
    }

    public SNTemperature getSnTemperature() {
        return snTemperature;
    }

    public void setSnTemperature(SNTemperature snTemperature) {
        this.snTemperature = snTemperature;
    }
}
