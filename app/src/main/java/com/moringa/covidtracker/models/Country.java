package com.moringa.covidtracker.models;

public class Country {
    private String name;

    public Country() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country(String name) {
        this.name = name;
    }
}
