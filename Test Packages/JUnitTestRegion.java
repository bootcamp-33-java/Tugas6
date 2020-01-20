/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.RegionController;
import icontrollers.IRegionController;
import java.util.List;
import models.Region;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.*;
import tools.DBConnection;

/**
 *
 * @author BWP
 */
public class JUnitTestRegion {
    DBConnection connection = new DBConnection();
    IRegionController irc = new RegionController(connection.getConnection());
    
    public JUnitTestRegion() {
    }
    
    @Test
    public void testGetById(){
        List<Region> act = irc.getById(1);
        Assert.assertNotNull(act);
    }
    
    @Test
    public void testGetAll(){
        List<Region> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }
    
    @Test
    public void testSearch(){
        List<Region> act2 = irc.search("As");
        Assert.assertNotNull(act2);
    }
    
    @Test
    public void testInsert(){
        Region region = new Region(33, "asiap");
        irc.insert(region);
        List<Region> m = irc.getById(region.getId());
        Assert.assertEquals(region.getId(), m.get(0).getId());
        Assert.assertEquals(region.getName(), m.get(0).getName());
    }
    
    @Test
    public void testUpadate(){
        Region region = new Region(1, "BagusGantengLee");
        irc.update(region);
        List<Region> m = irc.getById(region.getId());    
        Assert.assertEquals(region.getId(), m.get(0).getId());
        Assert.assertEquals(region.getName(), m.get(0).getName());
    }
    
    @Test
    public void testDelete(){
        irc.delete(2242);
        Assert.assertTrue(irc.getById(33).toString() == "[]");
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
