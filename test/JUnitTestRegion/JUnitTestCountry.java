/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTestRegion;

import controllers.CountryController;
import icontrollers.ICountryController;
import java.util.List;
import models.Country;
import org.junit.Assert;
import org.junit.Test;
import tools.DBConnection;

/**
 *
 * @author FIKRI-PC
 */
public class JUnitTestCountry {
    DBConnection connection = new DBConnection();
    ICountryController irc= new CountryController(connection.getConnection());
    
    public JUnitTestCountry() {
    }
    @Test
    public void testGetById(){
    List<Country> act = irc.getById("1");
    Assert.assertNotNull(act);
    }
    public void testGetAll(){
    List<Country> act3 = irc.getAll();
    Assert.assertNotNull(act3);
    }
    public void testSearch(){
    List<Country> act2 = irc.search("1");
    Assert.assertNotNull(act2);
    }
    public void testInsert(){
    irc.insert("111","NamaSaya","2");
    List<Country> m = irc.getById("111");
    Assert.assertEquals("111", m.get(0).getCid());
    Assert.assertEquals("NamaSaya", m.get(0).getName());
    Assert.assertEquals("2", m.get(0).getRid());
    
    }
    public void testUpdate(){
    irc.update("111","NamaSayaIni","2");
    List<Country> m = irc.getById("111");
    Assert.assertEquals("111", m.get(0).getCid());
    Assert.assertEquals("NamaSayaIni", m.get(0).getName());
    Assert.assertEquals("2", m.get(0).getRid());
    }
    public void testDelete(){
    irc.delete("111");
    List<Country> m = irc.getById("111");
    Assert.assertEquals("111", m.get(0).getCid());
    }
    
}
