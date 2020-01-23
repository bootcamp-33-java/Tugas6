/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Department;

/**
 *
 * @author Insane
 */
public interface IDepartmentController {

    public List<Department> getAll();

    public List<Department> getById(String id);

    public List<Department> search(String key);

    public String save(String id, String name, String managerId, String locationId);

    public String delete(String id);

}
