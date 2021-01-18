
package com.moringa.covidtracker.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class All implements Serializable
{

    @SerializedName("confirmed")
    @Expose
    private Integer confirmed;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;
    @SerializedName("deaths")
    @Expose
    private Integer deaths;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("sq_km_area")
    @Expose
    private Integer sqKmArea;
    @SerializedName("life_expectancy")
    @Expose
    private String lifeExpectancy;
    @SerializedName("elevation_in_meters")
    @Expose
    private String elevationInMeters;
    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("abbreviation")
    @Expose
    private String abbreviation;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("iso")
    @Expose
    private Integer iso;
    @SerializedName("capital_city")
    @Expose
    private String capitalCity;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("updated")
    @Expose
    private String updated;
    private final static long serialVersionUID = -7438183657713845316L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public All() {
    }

    /**
     * 
     * @param continent
     * @param country
     * @param iso
     * @param capitalCity
     * @param abbreviation
     * @param confirmed
     * @param population
     * @param sqKmArea
     * @param lifeExpectancy
     * @param recovered
     * @param elevationInMeters
     * @param _long
     * @param location
     * @param updated
     * @param deaths
     * @param lat
     */
    public All(Integer confirmed, Integer recovered, Integer deaths, String country, Integer population, Integer sqKmArea, String lifeExpectancy, String elevationInMeters, String continent, String abbreviation, String location, Integer iso, String capitalCity, String lat, String _long, String updated) {
        super();
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.country = country;
        this.population = population;
        this.sqKmArea = sqKmArea;
        this.lifeExpectancy = lifeExpectancy;
        this.elevationInMeters = elevationInMeters;
        this.continent = continent;
        this.abbreviation = abbreviation;
        this.location = location;
        this.iso = iso;
        this.capitalCity = capitalCity;
        this.lat = lat;
        this._long = _long;
        this.updated = updated;
    }

    public Integer getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Integer confirmed) {
        this.confirmed = confirmed;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getSqKmArea() {
        return sqKmArea;
    }

    public void setSqKmArea(Integer sqKmArea) {
        this.sqKmArea = sqKmArea;
    }

    public String getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(String lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public String getElevationInMeters() {
        return elevationInMeters;
    }

    public void setElevationInMeters(String elevationInMeters) {
        this.elevationInMeters = elevationInMeters;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getIso() {
        return iso;
    }

    public void setIso(Integer iso) {
        this.iso = iso;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

}
