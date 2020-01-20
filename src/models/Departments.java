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
public class Departments {

    private String departmentName;
    private int depatmentID, managerID, locationID;

    public Departments(int depatmentID, String departmentName, int managerID, int locationID) {
        this.departmentName = departmentName;
        this.depatmentID = depatmentID;
        this.managerID = managerID;
        this.locationID = locationID;
    }

    public Departments() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepatmentID() {
        return depatmentID;
    }

    public int getManagerID() {
        return managerID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepatmentID(int depatmentID) {
        this.depatmentID = depatmentID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
 
    
    
}
