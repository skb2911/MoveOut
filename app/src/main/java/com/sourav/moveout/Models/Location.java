package com.sourav.moveout.Models;

public class Location {
    String latitude, longitude;

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location() {
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        longitude = longitude;
    }
}
