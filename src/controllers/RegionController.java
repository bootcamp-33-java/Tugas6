/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegoinDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.List;
import models.Region;

/**
 *
 * @author BWP
 */
public class RegionController implements IRegionController {

    private IRegionDAO irdao;

    public RegionController(Connection connection) {
        irdao = new RegoinDAO(connection);
    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }

    @Override
    public List<Region> getById(int id) {
        return irdao.getById(id);
    }

    @Override
    public List<Region> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(Region r) {
        String result = "";
        Region region = new Region(r.getId(), r.getName());
        if (irdao.insert(region)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data berhasil disimpan";
        }
        return result;
    }
    
    @Override
    public String update(Region r){
        String result="";
        Region region = new Region(r.getId(), r.getName());
        if (irdao.update(region)) {
            result="Data berhasil diupdate";
        }else{
            result="Maaf data gagal diupdate";
        }
        return result;
    }
    
    @Override
    public String delete(int id){
        String result="";
        if(irdao.delete(id)){
            result = "Data berhasil dihapus";
        }else{
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
}
