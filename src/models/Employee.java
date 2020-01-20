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
public class Employee {
    private int employeeID, salary,managerID,departmentID;
    private String firstName, lastName, email, phoneNumber, hireDate, jobID;
    private float commisionPCT;

    public Employee(int employeeID, String firstName, String lastName, String email, String phoneNumber, String hireDate, String jobID, int salary, float commisionPCT, int managerID, int departmentID) {
        this.employeeID = employeeID;
        this.salary = salary;
        this.managerID = managerID;
        this.departmentID = departmentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobID = jobID;
        this.commisionPCT = commisionPCT;
    }

    public Employee() {
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getSalary() {
        return salary;
    }

    public int getManagerID() {
        return managerID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getJobID() {
        return jobID;
    }

    public float getCommisionPCT() {
        return commisionPCT;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public void setCommisionPCT(float commisionPCT) {
        this.commisionPCT = commisionPCT;
    }
    
}
