/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author BWP
 */
public class Location {
    int locationID;
    String streetAddreess, postalCode, city, stateProvince, countryID;

    public Location() {
    }

    public Location(int locationID, String streetAddreess, String postalCode, String city, String stateProvince, String countryID) {
        this.locationID = locationID;
        this.streetAddreess = streetAddreess;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryID = countryID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public void setStreetAddreess(String streetAddreess) {
        this.streetAddreess = streetAddreess;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public int getLocationID() {
        return locationID;
    }

    public String getStreetAddreess() {
        return streetAddreess;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public String getCountryID() {
        return countryID;
    }
    
    
}
