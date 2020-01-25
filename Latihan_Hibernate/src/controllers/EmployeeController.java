/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import java.util.List;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author yuyun
 */
public class EmployeeController implements IEmployeeController {

    private IEmployeeDAO iedao;

    public EmployeeController(SessionFactory sessionFactory) {
        iedao = new EmployeeDAO(sessionFactory);
    }

    @Override
    public List<Employee> getAll() {
        return iedao.getAll();
    }

    @Override
    public List<Employee> search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(Employee r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Employee r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
