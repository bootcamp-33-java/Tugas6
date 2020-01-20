/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Location;

/**
 *
 * @author BWP
 */
public interface ILocationDAO {
    
    /**
     * getAll method untuk mengambil semua data pada tabel JobGrades
     *
     * @return
     */
    public List<Location> getAll();
    
    /**
     * getbyid method untuk mendapatkan dan meyeleksi data dari table JobGrades
     * berdasarkan id
     * @param id
     * @return 
     */
    public List<Location> getById(int id);

    /**
     * search method untuk mendapatkan dan menyeleksi data dari tabel JobGrades
     * @param key where key
     * @return 
     */
    public List<Location> search(String key);
    
    /**
     * insert method untuk memasukkan data ke dalam tabel JobGrades
     * @param r
     * @return 
     */
    public boolean insert(Location r);
    
    /**
     * update method untuk mengganti nilai data di dalam kolom JobGrades
     * @param r
     * @return 
     */
    public boolean update(Location r);
    
    /**
     * delete method untuk menghapus satu baris data sesuai id masukkan
     * @param r
     * @return 
     */
    public boolean delete(int r);
}
