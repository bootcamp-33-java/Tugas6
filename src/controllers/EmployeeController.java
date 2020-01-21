/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import java.sql.Connection;
import java.util.List;
import models.Employee;

/**
 *
 * @author M Farij Ariefqy Saputra
 */
public class EmployeeController implements IEmployeeController {

    private IEmployeeDAO irdao;

    public EmployeeController(Connection connection) {
        irdao = new EmployeeDAO(connection);
    }

    @Override
    public List<Employee> getAll() {
        return irdao.getAll();
    }
    
    @Override
    public List<Employee> getJobId() {
        return irdao.getJobId();
    }
    
    @Override
    public List<Employee> getDepartmentId() {
        return irdao.getDepartmentId();
    }

    @Override
    public List<Employee> getById(String id) {
        return irdao.getById(Integer.parseInt(id));
    }

    @Override
    public List<Employee> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(String id, String firstName, String lastName, String email, String phoneNumber,
            String hireDate, String jobId, String salary, String commissionPct, String managerId, String departmentId) {
        String result = "";
        Employee employees = new Employee(Integer.parseInt(id), firstName, lastName, email, phoneNumber,
                hireDate, jobId, Integer.parseInt(salary), Float.parseFloat(commissionPct),
                Integer.parseInt(managerId), Integer.parseInt(departmentId));
        if (irdao.insert(employees)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String firstName, String lastName, String email, String phoneNumber,
            String hireDate, String jobId, String salary, String commissionPct, String managerId, String departmentId) {
        String result = "";
        Employee employees = new Employee(Integer.parseInt(id), firstName, lastName, email, phoneNumber,
                hireDate, jobId, Integer.parseInt(salary), Float.parseFloat(commissionPct),
                Integer.parseInt(managerId), Integer.parseInt(departmentId));
        if (irdao.update(employees)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (irdao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }

}
