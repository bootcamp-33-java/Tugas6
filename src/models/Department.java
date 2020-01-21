/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Insane
 */
public class Department {

    private int id;
    private String name;
    private int managerId;
    private String locationId;
    
    public Department() {

    }

    public Department(int id, String name, int managerId, String locationId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
        this.locationId = locationId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
    

}
