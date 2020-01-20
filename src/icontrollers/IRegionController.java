/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author BWP
 */
public interface IRegionController {
    
    /**
     * untuk mengambil semua data pada tabel region
     * @return 
     */
    public List<Region> getAll();
    
    /**
     * untuk mendapatkan data berdasarkan id
     * @param id
     * @return 
     */
    public List<Region> getById(int id);
    
    /**
     * untuk mencari data berdasarkan keywordnya
     * 
     * @param key
     * @return 
     */
    public List<Region> search(String key);
    
    /**
     * untuk memasukkan data ke tabel regions
     * @param id
     * @param name
     * @return 
     */
    public String insert(Region r);

    /**
     * untuk mengupdate data sesuai id
     * @param id
     * @param name
     * @return 
     */
    public String update(Region r);
    
    /**
     * untuk mendelete berdasarkan id atau nama
     * @param id
     * @return 
     */
    public String delete(int id);
}
