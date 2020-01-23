/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import icontrollers.IDepartmentController;
import idaos.IDepartmentDAO;
import java.sql.Connection;
import java.util.List;
import models.Department;

/**
 *
 * @author Insane
 */
public class DepartmentController implements IDepartmentController {

    private IDepartmentDAO iddao;

    public DepartmentController(Connection connection) {
        iddao = new DepartmentDAO(connection);
    }

    @Override
    public List<Department> getAll() {
        return iddao.getData(0,"");
    }

    @Override
    public List<Department> getById(String id) {
        return iddao.getData(Integer.parseInt(id),"");
    }

    @Override
    public List<Department> search(String key) {
        return iddao.getData(0,key);
    }


    @Override
    public String save(String id, String name, String managerId, String locationId) {
        String result = "";
        Department department = new Department(Integer.parseInt(id), name, Integer.parseInt(managerId), Integer.parseInt(locationId));
        if (iddao.save(department)) {
            result = "Data Saved Successfull";
        } else {
            result = "Data Saved Failed";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (iddao.delete(Integer.parseInt(id))) {
            result = "Data Deleted Successfull";
        } else {
            result = "Data Deleted Failed";
        }
        return result;
    }




    
}
