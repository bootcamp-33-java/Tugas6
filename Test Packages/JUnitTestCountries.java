/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.CountriesController;
import icontrollers.ICountryController;
import icontrollers.IRegionController;
import java.util.List;
import models.Country;
import models.Region;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.*;
import tools.DBConnection;

/**
 *
 * @author BWP
 */
public class JUnitTestCountries {

    DBConnection connection = new DBConnection();
    ICountryController irc = new CountriesController(connection.getConnection());

    public JUnitTestCountries() {
    }

    @Test
    public void testGetById() {
        List<Country> act = irc.getById("AR");
        Assert.assertNotNull(act);
    }

    @Test
    public void testGetAll() {
        List<Country> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }

    @Test
    public void testSearch() {
        List<Country> act2 = irc.search("Argentina");
        Assert.assertNotNull(act2);
    }

    @Test
    public void testInsert() {
        Country country = new Country("BB","BOOTCAMP33" ,1);
        irc.insert(country);
        List<Country> m = irc.getById(country.getCountryID());
        Assert.assertEquals(country.getCountryID(), m.get(0).getCountryID());
        Assert.assertEquals(country.getCountryName(), m.get(0).getCountryName());
        Assert.assertEquals(country.getRegionID(), m.get(0).getRegionID());
    }

    @Test
    public void testUpadate() {
        Country country = new Country("AA","SANTUY", 2);
        irc.update(country);
        List<Country> m = irc.getById(country.getCountryID());
        Assert.assertEquals(country.getCountryID(), m.get(0).getCountryID());
        Assert.assertEquals(country.getCountryName(), m.get(0).getCountryName());
        Assert.assertEquals(country.getRegionID(), m.get(0).getRegionID());
    }

    @Test
    public void testDelete() {
        irc.delete("AAAA");
        Assert.assertTrue(irc.getById("AAAA").toString() == "[]");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
