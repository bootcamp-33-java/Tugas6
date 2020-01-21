/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import daos.LocationDAO;
import icontrollers.IDepartmentController;
import idaos.IDepartmentDAO;
import java.sql.Connection;
import java.util.List;
import models.Department;
import models.Location;

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
        return iddao.getAll();
    }

    @Override
    public List<Department> getById(int Id) {
        return iddao.getById(Id);
    }

    @Override
    public List<Department> search(String Key) {
        return iddao.search(Key);
    }

    @Override
    public String insert(String id, String name, String managerId, String locationId) {
        String result = "";
        Department department = new Department(Integer.parseInt(id), name, Integer.parseInt(managerId), locationId);
        if (iddao.insert(department)) {
            result = "Data berhasil ditambah";
        } else {
            result = "Maaf data gagal ditambah";
        }
        return result;
    }

    @Override
    public String update(String id, String name, String managerId, String locationId) {
        String result = "";
        Department department = new Department(Integer.parseInt(id), name, Integer.parseInt(managerId), locationId);
        if (iddao.update(department)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (iddao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }

    
}
