/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import daos.RegoinDAO;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import java.sql.Connection;
import java.util.List;
import models.Country;

/**
 *
 * @author BWP
 */
public class CountriesController implements ICountryController {

    private ICountryDAO irdao;

    public CountriesController(Connection connection) {
        irdao = new CountryDAO(connection);
    }

    @Override
    public List<Country> getAll() {
        return irdao.getAll();
    }

    @Override
    public List<Country> getById(String id) {
        return irdao.getById(id);
    }

    @Override
    public List<Country> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(Country j) {
        String result = "";
        Country country = new Country(j.getCountryID(), j.getCountryName(), j.getRegionID());

        if (irdao.insert(country)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String update(Country j) {
        String result = "";
        Country country = new Country(j.getCountryID(), j.getCountryName(), j.getRegionID());

        if (irdao.update(country)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (irdao.delete(id)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
}
