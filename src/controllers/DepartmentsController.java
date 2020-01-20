/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentsDAO;
import daos.RegoinDAO;
import icontrollers.IDepartmentsController;
import idaos.IDepartmentsDAO;
import java.sql.Connection;
import java.util.List;
import models.Departments;

/**
 *
 * @author BWP
 */
public class DepartmentsController implements IDepartmentsController {

    private IDepartmentsDAO irdao;

    public DepartmentsController(Connection connection) {
        irdao = new DepartmentsDAO(connection);
    }

    @Override
    public List<Departments> getAll() {
        return irdao.getAll();
    }

    @Override
    public List<Departments> getById(int id) {
        return irdao.getById(id);
    }

    @Override
    public List<Departments> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(Departments j) {
        String result = "";
        Departments departments = new Departments(j.getDepatmentID(), j.getDepartmentName(), j.getManagerID(), j.getLocationID());

        if (irdao.insert(departments)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String update(Departments j) {
        String result = "";
        Departments departments = new Departments(j.getDepatmentID(), j.getDepartmentName(), j.getManagerID(), j.getLocationID());
        if (irdao.update(departments)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(int id) {
        String result = "";
        if (irdao.delete(id)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
}
