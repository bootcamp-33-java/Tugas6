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
        
    public List<Department> getData(int id, String key);
    
    public boolean save(Department d);

    public boolean delete(int id);

}
