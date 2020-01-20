/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.LocationController;
import icontrollers.ILocationController;
import java.util.List;
import models.Location;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DBConnection;

/**
 *
 * @author aqira
 */
public class JUnitTestLocation {

    public JUnitTestLocation() {
    }

    DBConnection connection = new DBConnection();
    ILocationController ilc = new LocationController(connection.getConnection());

    @Test
    public void testGetById() {
        List<Location> act = ilc.getById("1000");
        Assert.assertNotNull(act);
    }

    public void testGetAll() {
        List<Location> act3 = ilc.getAll();
        Assert.assertNotNull(act3);
    }

    public void testSearch() {
        List<Location> act2 = ilc.search("1000");
        Assert.assertNotNull(act2);
    }

    public void testInsert() {
        ilc.insert("111", "Address ku", "41414", "aaa", "aaa", "aaa");
        List<Location> m = ilc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("Address ku", m.get(0).getAddress());
        Assert.assertEquals("41414", m.get(0).getPostalCode());
        Assert.assertEquals("aaa", m.get(0).getCity());
        Assert.assertEquals("aaa", m.get(0).getStateProvince());
        Assert.assertEquals("aaa", m.get(0).getCountryId());
    }

    public void testUpdate() {
        ilc.insert("111", "Address ku", "41414", "aaa", "aaa", "aaa");
        List<Location> m = ilc.getById("111");
        Assert.assertEquals("111", m.get(0).getId());
        Assert.assertEquals("Address ku", m.get(0).getAddress());
        Assert.assertEquals("41414", m.get(0).getPostalCode());
        Assert.assertEquals("aaa", m.get(0).getCity());
        Assert.assertEquals("aaa", m.get(0).getStateProvince());
        Assert.assertEquals("aaa", m.get(0).getCountryId());
    }

    public void testDelete() {
        ilc.delete("111");
        Assert.assertNull(ilc.getById("111"));
    }
}
