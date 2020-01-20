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
 * @author M Farij Ariefqy Saputra
 */
public interface IEmployeeController {
      
    /**
     * untuk mengambil semua data pada tabel JobGrades
     * @return 
     */
    public List<Employee> getAll();
    
    /**
     * untuk mendapatkan data berdasarkan id
     * @param id
     * @return 
     */
    public List<Employee> getById(String id);
    
    /**
     * untuk mencari data berdasarkan keywordnya
     * 
     * @param key
     * @return 
     */
    public List<Employee> search(String key);
    
    /**
     * untuk memasukkan data ke tabel JobGrades
     * @param id
     * @param name
     * @return 
     */
    public String insert(String id, String firstName, String lastName, String email, String phoneNumber, 
            String hireDate, String jobId, int salary, float commissionPct, int managerId, int departmentId );

    /**
     * untuk mengupdate data sesuai id
     * @param id
     * @param name
     * @return 
     */
    public String update(String id, String firstName, String lastName, String email, String phoneNumber, 
            String hireDate, String jobId, int salary, float commissionPct, int managerId, int departmentId);
    
    /**
     * untuk mendelete berdasarkan id atau nama
     * @param id
     * @return 
     */
    public String delete(String id);
}
