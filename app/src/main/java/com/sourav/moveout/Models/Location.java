package com.sourav.moveout.Models;

public class Location {
    String Latitude, Longitude;

    public Location(String latitude, String longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public Location() {
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
}
