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
public class Country {

    private String countryID, countryName;
    private int regionID;

    public Country(String countryID, String countryName, int regionID) {
        this.countryID = countryID;
        this.countryName = countryName;
        this.regionID = regionID;
    }

    public Country() {
    }

    public String getCountryID() {
        return countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getRegionID() {
        return regionID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }
    
}
