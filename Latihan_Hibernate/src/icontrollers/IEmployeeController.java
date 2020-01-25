/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employee;

/**
 *
 * @author yuyun
 */
public interface IEmployeeController {
    public List<Employee> getAll();

    public List<Employee> search(String key);
    
    public String insert (Employee r);
    
    public String update (Employee r);
    
    public String delete (int id);
}
