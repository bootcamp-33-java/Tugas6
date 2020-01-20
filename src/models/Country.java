/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Galih Satriya
 */
public class Country {
     private String id;
     private String name;
     private int regionId;

    public Country() {
    }

    public Country(String id, String name, int regionId ) {
        this.id = id;
        this.name = name;
        this.regionId = regionId;
    }

    public String getCid() {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getRid() {
        return regionId;
    }

    public void setCid(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRid(int regionId) {
        this.regionId = regionId;
    }
}
