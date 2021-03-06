/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.DepartmentController;
import icontrollers.IDepartmentController;
import models.Department;

/**
 *
 * @author Insane
 */
public class OJDBCDepartment {
    
    DBConnection connection = new DBConnection();
    IDepartmentController iddao = new DepartmentController(connection.getConnection());

    public void getAll() {
 
        for (Department department : iddao.getAll()) {
            System.out.println(department.getId());
            System.out.println(department.getName());
            System.out.println(department.getManagerId());
            System.out.println(department.getLocationId());
        }
    }

    public void save() {
        System.out.println(iddao.save("280" , "BOOTCAMP33", "127", "1700"));
    }

    public void getById() {
        for (Department department : iddao.getById("10")) {
            System.out.println(department.getId());
            System.out.println(department.getName());
            System.out.println(department.getManagerId());
            System.out.println(department.getLocationId());
        }
    }

    public void search() {
        for (Department d : iddao.search("1")) {
                System.out.println(d.getId());
            System.out.println(d.getName());
            System.out.println(d.getManagerId());
            System.out.println(d.getLocationId());
        }
    }


    public void delete() {
        System.out.println(iddao.delete("260"));
    }

    public static void main(String[] args) {
        OJDBCDepartment testing = new OJDBCDepartment();
//        testing.getAll();
        testing.save();
//        testing.getById();
//        testing.search(); 
//        testing.delete(); 
    }
    
}
