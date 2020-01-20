/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.DepartmentsController;
import controllers.RegionController;
import icontrollers.IDepartmentsController;
import icontrollers.IRegionController;
import java.util.List;
import models.Departments;
import models.Region;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.*;
import tools.DBConnection;

/**
 *
 * @author BWP
 */
public class JUnitTestDepartments {

    DBConnection connection = new DBConnection();
    IDepartmentsController irc = new DepartmentsController(connection.getConnection());

    public JUnitTestDepartments() {
    }

    @Test
    public void testGetById() {
        List<Departments> act = irc.getById(10);
        Assert.assertNotNull(act);
    }

    @Test
    public void testGetAll() {
        List<Departments> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }

    @Test
    public void testSearch() {
        List<Departments> act2 = irc.search("Marketing");
        Assert.assertNotNull(act2);
    }

    @Test
    public void testInsert() {
        Departments departments = new Departments(3,"BOOTCAMP33" ,200, 1700);
        irc.insert(departments);
        List<Departments> m = irc.getById(departments.getDepatmentID());
        Assert.assertEquals(departments.getDepatmentID(), m.get(0).getDepatmentID());
        Assert.assertEquals(departments.getDepartmentName(), m.get(0).getDepartmentName());
        Assert.assertEquals(departments.getManagerID(), m.get(0).getManagerID());
        Assert.assertEquals(departments.getLocationID(), m.get(0).getLocationID());
    }

    @Test
    public void testUpadate() {
        Departments departments = new Departments(10,"SANTUY", 100, 1700);
        irc.update(departments);
        List<Departments> m = irc.getById(departments.getDepatmentID());
        Assert.assertEquals(departments.getDepatmentID(), m.get(0).getDepatmentID());
        Assert.assertEquals(departments.getDepartmentName(), m.get(0).getDepartmentName());
        Assert.assertEquals(departments.getManagerID(), m.get(0).getManagerID());
        Assert.assertEquals(departments.getLocationID(), m.get(0).getLocationID());
    }

    @Test
    public void testDelete() {
        irc.delete(1);
        Assert.assertTrue(irc.getById(1).toString() == "[]");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
