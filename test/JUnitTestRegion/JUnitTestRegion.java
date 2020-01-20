/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTestRegion;

import controllers.RegionController;
import icontrollers.IRegionController;
import java.util.List;
import models.Region;
import org.junit.Assert;
import org.junit.Test;
import tools.DBConnection;

/**
 *
 * @author FIKRI-PC
 */
public class JUnitTestRegion {
    DBConnection connection = new DBConnection();
    IRegionController irc= new RegionController(connection.getConnection());
    
    public JUnitTestRegion() {
    }
    @Test
    public void testGetById(){
    List<Region> act = irc.getById("1");
    Assert.assertNotNull(act);
    }
    public void testGetAll(){
    List<Region> act3 = irc.getAll();
    Assert.assertNotNull(act3);
    }
    public void testSearch(){
    List<Region> act2 = irc.search("1");
    Assert.assertNotNull(act2);
    }
    public void testInsert(){
    irc.insert("111","NamaSaya");
    List<Region> m = irc.getById("111");
    Assert.assertEquals("111", m.get(0).getId());
    Assert.assertEquals("NamaSaya", m.get(0).getName());
    
    }
    public void testUpdate(){
    irc.update("111","NamaSayaIni");
    List<Region> m = irc.getById("111");
    Assert.assertEquals("111", m.get(0).getId());
    Assert.assertEquals("NamaSayaIni", m.get(0).getName());
    }
    public void testDelete(){
    irc.delete("111");
    List<Region> m = irc.getById("111");
    Assert.assertEquals("111", m.get(0).getId());
    }
    
}
