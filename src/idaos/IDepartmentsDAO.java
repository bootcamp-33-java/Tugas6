/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Departments;

/**
 *
 * @author BWP
 */
public interface IDepartmentsDAO {
    
    /**
     * getAll method untuk mengambil semua data pada tabel JobGrades
     *
     * @return
     */
    public List<Departments> getAll();
    
    /**
     * getbyid method untuk mendapatkan dan meyeleksi data dari table JobGrades
     * berdasarkan id
     * @param id
     * @return 
     */
    public List<Departments> getById(int id);

    /**
     * search method untuk mendapatkan dan menyeleksi data dari tabel JobGrades
     * @param key where key
     * @return 
     */
    public List<Departments> search(String key);
    
    /**
     * insert method untuk memasukkan data ke dalam tabel JobGrades
     * @param r
     * @return 
     */
    public boolean insert(Departments r);
    
    /**
     * update method untuk mengganti nilai data di dalam kolom JobGrades
     * @param r
     * @return 
     */
    public boolean update(Departments r);
    
    /**
     * delete method untuk menghapus satu baris data sesuai id masukkan
     * @param r
     * @return 
     */
    public boolean delete(int r);
}
