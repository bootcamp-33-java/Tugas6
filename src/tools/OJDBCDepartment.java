/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DepartmentsController;
import controllers.JobsController;
import icontrollers.IDepartmentsController;
import models.Departments;
import models.Location;

/**
 *
 * @author Insane
 */
public class OJDBCDepartment {

    DBConnection connection = new DBConnection();
    IDepartmentsController irdao = new DepartmentsController(connection.getConnection());

    public void getAll() {

        for (Departments department : irdao.getAll()) {
            System.out.println(department.getDepatmentID());
            System.out.println(department.getDepartmentName());
            System.out.println(department.getLocationID());
            System.out.println(department.getManagerID());
        }
    }

    public void insert() {
        Departments department = new Departments(280 , "BOOTCAMP33", 127, 1700);
        System.out.println(irdao.insert(department));
        
    }

    public void getById() {
        for (Departments department : irdao.getById(10)) {
            System.out.println(department.getDepatmentID());
            System.out.println(department.getDepartmentName());
            System.out.println(department.getLocationID());
            System.out.println(department.getManagerID());
        }
    }

    public void search() {
        for (Departments department : irdao.search("1")) {
            System.out.println(department.getDepatmentID());
            System.out.println(department.getDepartmentName());
            System.out.println(department.getLocationID());
            System.out.println(department.getManagerID());
        }
    }

//    public void update() {
//        Departments department = new Departments(260 , "Servant", 127, 1700);
//        System.out.println(irdao.update());
//
//    }

//    public void delete() {
//        System.out.println(irdao.delete("IT_PROG"));
//    }

    public static void main(String[] args) {
        ManualTestControllerJobs testing = new ManualTestControllerJobs();
        testing.getAll();
//        testing.insert();
//        testing.getById();
//        testing.search();
//        testing.delete();
//        testing.update();
    }

}
