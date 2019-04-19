package com.sourav.moveout.Models;

import java.util.ArrayList;

public class City {
    String name;
    ArrayList<String> dontMiss;
    String about;
    Location location;
    String timeZone;
    ArrayList<Currency> listOfCurrencies;
    ArrayList<Temperature> listOfTemperature;
    ArrayList<String> thingsToDo;

    public City(String name, ArrayList<String> dontMiss, String about, Location location, String timeZone, ArrayList<Currency> listOfCurrencies, ArrayList<Temperature> listOfTemperature, ArrayList<String> thingsToDo) {
        this.name = name;
        this.dontMiss = dontMiss;
        this.about = about;
        this.location = location;
        this.timeZone = timeZone;
        this.listOfCurrencies = listOfCurrencies;
        this.listOfTemperature = listOfTemperature;
        this.thingsToDo = thingsToDo;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getDontMiss() {
        return dontMiss;
    }

    public void setDontMiss(ArrayList<String> dontMiss) {
        this.dontMiss = dontMiss;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public ArrayList<Currency> getListOfCurrencies() {
        return listOfCurrencies;
    }

    public void setListOfCurrencies(ArrayList<Currency> listOfCurrencies) {
        this.listOfCurrencies = listOfCurrencies;
    }

    public ArrayList<Temperature> getListOfTemperature() {
        return listOfTemperature;
    }

    public void setListOfTemperature(ArrayList<Temperature> listOfTemperature) {
        this.listOfTemperature = listOfTemperature;
    }

    public ArrayList<String> getThingsToDo() {
        return thingsToDo;
    }

    public void setThingsToDo(ArrayList<String> thingsToDo) {
        this.thingsToDo = thingsToDo;
    }
}
