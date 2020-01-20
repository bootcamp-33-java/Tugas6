/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import java.sql.Connection;
import java.util.List;
import models.Country;

/**
 *
 * @author FIKRI
 */
public class CountryController implements ICountryController{
     private ICountryDAO icdao;

    public CountryController(Connection connection) {
        icdao = new CountryDAO(connection);
    }

    @Override
    public List<Country> getAll() {
        return icdao.getAll();
    }
    @Override
    public List<Country> getById(String c_id){
    return icdao.getById(c_id);
    }
    @Override
    public List<Country> search(String key) {
    return icdao.search(key);
    }
    @Override
    public String insert(String c_id, String name, String r_id) {
    String result ="";
    Country country = new Country(c_id, name,Integer.parseInt(r_id));
    if (icdao.insert(country)) {
        result= "Data Berhasil disimpan";
    } else {
        result = "Maaf data gagal disimpan";
    }
    return result;
    }
    @Override
    public String update(String c_id, String name, String r_id) {
    String result ="";
    Country country= new Country(c_id, name ,Integer.parseInt(r_id));
    if (icdao.update(country)) {
        result= "Data Berhasil diupdate";
    } else {
        result = "Maaf data gagal disimpan";
    }
    return result;
    }
    @Override
    public String delete(String c_id) {
    String result ="";
    if (icdao.delete(c_id)) {
        result= "Data Berhasil dihapus";
    } else {
        result = "Maaf data gagal disimpan";
    }
    return result;
    }

    @Override
    public Iterable<Country> getByName(String Val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
