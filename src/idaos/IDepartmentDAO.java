/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import models.Department;
import java.util.List;

/**
 *
 * @author Insane
 */
public interface IDepartmentDAO {

    public List<Department> getAll();

    public List<Department> getById(int id);
    
    public List<Department> getByName(String name);

    public List<Department> search(String key);

    public boolean insert(Department d);

    public boolean update(Department d);

    public boolean delete(int id);

}