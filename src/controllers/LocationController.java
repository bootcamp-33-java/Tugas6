/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.sql.Connection;
import java.util.List;
import models.Location;

/**
 *
 * @author Fachrurrozy
 */
public class LocationController implements ILocationController{
    
    private ILocationDAO ildao;
    
    public LocationController(Connection connection){
      ildao = new LocationDAO(connection);  
    }
    
    
    @Override
    public List<Location> getAll() {
        return ildao.getAll();
    }

    @Override
    public List<Location> getLocid(String locid) {
        return ildao.getLocid(Integer.parseInt(locid));
    }

    @Override
    public List<Location> search(String key) {
        return ildao.search(key);
    }

    @Override
    public String update(String locid, String stradd, String poscode,String city, String staprov, String counid) {
        String result = "";
        Location location = new Location(Integer.parseInt(locid), stradd, Integer.parseInt(poscode), city, staprov, counid);
        if (ildao.update(location)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String locid) {
         String result = "";
        if (ildao.delete(Integer.parseInt(locid))) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
    @Override
    public void insert(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Iterable<Location> getByPoscode(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Iterable<Location> getByCity(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Iterable<Location> getByStaprov(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Iterable<Location> getByCoid(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Location> getById(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Location> getByName(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String locid, String stradd, String poscode,String city, String staprov, String counid) {
    String result = "";
        Location location = new Location(Integer.parseInt(locid), stradd, Integer.parseInt(poscode), city, staprov, counid);
        if (ildao.insert(location)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Location> getByLocid(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<Location> getByStradd(String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}