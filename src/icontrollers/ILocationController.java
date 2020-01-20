/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Location;

/**
 *
 * @author BWP
 */
public interface ILocationController {
      
    /**
     * untuk mengambil semua data pada tabel JobGrades
     * @return 
     */
    public List<Location> getAll();
    
    /**
     * untuk mendapatkan data berdasarkan id
     * @param id
     * @return 
     */
    public List<Location> getById(int id);
    
    /**
     * untuk mencari data berdasarkan keywordnya
     * 
     * @param key
     * @return 
     */
    public List<Location> search(String key);
    
    /**
     * untuk memasukkan data ke tabel JobGrades
     * @param id
     * @param name
     * @return 
     */
    public String insert(Location r);

    /**
     * untuk mengupdate data sesuai id
     * @param id
     * @param name
     * @return 
     */
    public String update(Location r);
    
    /**
     * untuk mendelete berdasarkan id atau nama
     * @param id
     * @return 
     */
    public String delete(int id);
}
