/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.EmployeeDAO;
import idaos.IEmployeeDAO;
import models.Employee;

/**
 *
 * @author Bagus Widyantoro Putro
 */
public class OJDBCEmployees {

    DBConnection connection = new DBConnection();
    IEmployeeDAO irdao = new EmployeeDAO(connection.getConnection());

    public void getAll() {

        for (Employee employee : irdao.getData(0, "")) {
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getEmail());
            System.out.println(employee.getPhoneNumber());
            System.out.println(employee.getHireDate());
            System.out.println(employee.getJobID());
            System.out.println(employee.getSalary());
            System.out.println(employee.getCommisionPCT());
            System.out.println(employee.getManagerID());
            System.out.println(employee.getDepartmentID());
        }
    }

    public void getJobId() {
        for (Employee employee : irdao.getJobId()) {
            System.out.println(employee.getJobID());
        }
    }
    
    public void getDepartmentId() {
        for (Employee employee : irdao.getDepartmentId()) {
            System.out.println(employee.getDepartmentID());
        }
    }

    public void search() {
        for (Employee employee : irdao.getData(0,"AC_ACCOUNT")) {
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getEmail());
            System.out.println(employee.getPhoneNumber());
            System.out.println(employee.getHireDate());
            System.out.println(employee.getJobID());
            System.out.println(employee.getSalary());
            System.out.println(employee.getCommisionPCT());
            System.out.println(employee.getManagerID());
            System.out.println(employee.getDepartmentID());
        }
    }

    
    public void update() {
        Employee employee = new Employee(207, "Siduliiii", "Boyo", "BOYGMAIL", "55555", "06/07/2002", "AC_ACCOUNT", 8300, 0.2f, 205, 110);
        System.out.println(irdao.save(employee));

    }
    
    public void insert() {
        Employee employee = new Employee(400, "Sidul", "BoyI", "BOYGMAIWL", "555", "06/07/2002", "AC_ACCOUNT", 8300, 0.2f, 205, 110);
        System.out.println(irdao.save(employee));
    }

    public void delete() {
        System.out.println(irdao.delete(207));
    }
    
    public void save() {
        Employee employee = new Employee(217, "HH", "ooo", "BhDAWD", "55555", "06/07/2002", "AC_ACCOUNT", 8300, 0.2f, 205, 110);
        System.out.println(irdao.save(employee));
    }

    public void getById() {
        for (Employee employee : irdao.getData(206,"")) {
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getEmail());
            System.out.println(employee.getPhoneNumber());
            System.out.println(employee.getHireDate());
            System.out.println(employee.getJobID());
            System.out.println(employee.getSalary());
            System.out.println(employee.getCommisionPCT());
            System.out.println(employee.getManagerID());
            System.out.println(employee.getDepartmentID());
        }
    }
    public static void main(String[] args) {
        OJDBCEmployees testing = new OJDBCEmployees();
//       testing.getAll();
//        testing.insert();
        testing.getById();
//        testing.search();
//        testing.delete();
//       testing.update();
//        testing.getJobId();
//        testing.getDepartmentId();
//        testing.save();
    }
}
