/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import idaos.ILocationDAO;
import icontrollers.ILocationController;
import java.sql.Connection;
import java.util.List;
import models.Location;

/**
 *
 * @author aqira
 */
public class LocationController implements ILocationController {

    private ILocationDAO ildao;

    public LocationController(Connection connection) {
        ildao = new LocationDAO(connection);
    }

    @Override
    public List<Location> getAll() {
        return ildao.getData(0,"");
    }

    @Override
    public List<Location> getById(String id) {
        return ildao.getData(Integer.parseInt(id),"");
    }

    @Override
    public List<Location> search(String key) {
        return ildao.getData(0,key);
    }
    
    @Override
    public List<Location> getData(int id, String key) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ildao.getData(id, key);
    }

    @Override
    public String insert(String id, String address, String postal_code, String city, String stateProvince, String countryId) {
        String result = "";
        Location location = new Location(Integer.parseInt(id), address, postal_code, city, stateProvince, countryId);
        if (ildao.insert(location)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String address, String postalCode, String city, 
            String stateProvince, String countryId) {
        String result = "";
        Location location = new Location(Integer.parseInt(id), address, postalCode, city, 
                stateProvince, countryId);
        if (ildao.update(location)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }
    
    public String save(String id, String address, String postal_code, String city, String stateProvince, String countryId) {
        String result = "";
        Location location = new Location(Integer.parseInt(id), address, postal_code, city, stateProvince, countryId);
        if (ildao.save(location)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (ildao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }

    
}
