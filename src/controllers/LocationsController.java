/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import daos.RegoinDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.sql.Connection;
import java.util.List;
import models.Location;

/**
 *
 * @author BWP
 */
public class LocationsController implements ILocationController {

    private ILocationDAO irdao;

    public LocationsController(Connection connection) {
        irdao = new LocationDAO(connection);
    }

    @Override
    public List<Location> getAll() {
        return irdao.getAll();
    }

    @Override
    public List<Location> getById(int id) {
        return irdao.getById(id);
    }

    @Override
    public List<Location> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(Location j) {
        String result = "";
        Location location = new Location(j.getLocationID(), j.getStreetAddreess(), j.getPostalCode(), j.getCity(), j.getStateProvince(), j.getCountryID());

        if (irdao.insert(location)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String update(Location j) {
        String result = "";
        Location location = new Location(j.getLocationID(), j.getStreetAddreess(), j.getPostalCode(), j.getCity(), j.getStateProvince(), j.getCountryID());
        if (irdao.update(location)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(int id) {
        String result = "";
        if (irdao.delete(id)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
}
