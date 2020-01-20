/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Departments;
import models.Location;
//import models.Employees;

/**
 *
 * @author BWP
 */
public interface IDepartmentsController {

    /**
     * untuk mengambil semua data pada tabel JobGrades
     *
     * @return
     */
    public List<Departments> getAll();

    /**
     * untuk mendapatkan data berdasarkan id
     *
     * @param id
     * @return
     */
    public List<Departments> getById(int id);

    /**
     * untuk mencari data berdasarkan keywordnya
     *
     * @param key
     * @return
     */
    public List<Departments> search(String key);
    
    public String insert(int id, String departmentName, int managerId, int locationId);

    /**
     * untuk memasukkan data ke tabel JobGrades
     *
     * @param depatmentID
     * @param id
     * @param name
     * @return
     */
    /**
     *
     */
    public String update(String id, String departmentName, String managerId, String locationId);

    /**
     * untuk mendelete berdasarkan id atau nama
     *
     * @param id
     * @return
     */
    public String delete(int id);

    

}
