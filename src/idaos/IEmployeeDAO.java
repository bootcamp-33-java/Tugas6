/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Employee;

/**
 *
 * @author BWP
 */
public interface IEmployeeDAO {
    
    /**
     * insert method untuk memasukkan data ke dalam tabel JobGrades
     * @param r
     * @return 
     */
//    public boolean insert(Employee r);
    
    public boolean save(Employee employee);
    
    public List<Employee> getData(int id, String key);
    
    /**
     * update method untuk mengganti nilai data di dalam kolom JobGrades
     * @param r
     * @return 
     */
//    public boolean update(Employee r);
    
    /**
     * delete method untuk menghapus satu baris data sesuai id masukkan
     * @param r
     * @return 
     */
    public boolean delete(int r);
}
