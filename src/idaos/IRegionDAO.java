/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author BWP
 */
public interface IRegionDAO {

    /**
     * getAll method untuk mengambil semua data pada tabel Regions
     *
     * @return
     */
    public List<Region> getAll();
    
    /**
     * getbyid method untuk mendapatkan dan meyeleksi data dari table regions
     * berdasarkan id
     * @param id
     * @return 
     */
    public List<Region> getById(int id);

    /**
     * search method untuk mendapatkan dan menyeleksi data dari tabel regions
     * @param key where key
     * @return 
     */
    public List<Region> search(String key);
    
    /**
     * insert method untuk memasukkan data ke dalam tabel Regions
     * @param r
     * @return 
     */
    public boolean insert(Region r);
    
    /**
     * update method untuk mengganti nilai data di dalam kolom Region
     * @param r
     * @return 
     */
    public boolean update(Region r);
    
    /**
     * delete method untuk menghapus satu baris data sesuai id masukkan
     * @param r
     * @return 
     */
    public boolean delete(int r);
}
