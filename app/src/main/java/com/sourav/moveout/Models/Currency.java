package com.sourav.moveout.Models;

public class Currency {

    String currencyName;
    String currencyConversion;

    public Currency(String currencyName, String currencyConversion) {
        this.currencyName = currencyName;
        this.currencyConversion = currencyConversion;
    }

    public Currency() {
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyConversion() {
        return currencyConversion;
    }

    public void setCurrencyConversion(String currencyConversion) {
        this.currencyConversion = currencyConversion;
    }
}
