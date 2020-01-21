/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTestRegion;

import controllers.EmployeeController;
import icontrollers.IEmployeeController;
import java.util.List;
import models.Employee;
import org.junit.Assert;
import org.junit.Test;
import tools.DBConnection;

/**
 *
 * @author Bagus Widyantoro Putro
 */
public class JUnitTestEmployee {

    DBConnection connection = new DBConnection();
    IEmployeeController iec = new EmployeeController(connection.getConnection());

//    public JUnitTestEmployee() {
//    }
//
//    @Test
//    public void testGetById() {
//        List<Employee> act = iec.getById("206");
//        Assert.assertNotNull(act);
//    }
//
//    @Test
//    public void testGetAll() {
//        List<Employee> act3 = iec.getAll();
//        Assert.assertNotNull(act3);
//    }
//
//    @Test
//    public void testSearch() {
//        List<Employee> act2 = iec.search("1");
//        Assert.assertNotNull(act2);
//    }

    @Test
    public void testInsert() {
        iec.insert("216", "SidulLee", "BoyLee", "BOYGMAILLLee", "532628", "10/10/2002", "AC_ACCOUNT", "8300", "0.2", "205", "110");
        //Employee employee = new Employee(900, "gianny", "luigi", "a@mail.com", "098970", new Date("12/01/2019"), new BigDecimal(23), new BigDecimal(0.2), new Department(new Short("90")), new Employee(100), new Job("AD_PRES"));   
        List<Employee> m = iec.getById("216");
       
        Assert.assertEquals("216", String.valueOf(m.get(0).getId()));
        Assert.assertEquals("SidulLee", m.get(0).getFirstName());
        Assert.assertEquals("BoyLee", m.get(0).getLastName());
        Assert.assertEquals("BOYGMAILLLee", m.get(0).getEmail());
        Assert.assertEquals("532628", m.get(0).getPhoneNumber());
//        Assert.assertEquals("10/10/2002", m.get(0).getHireDate());
        Assert.assertEquals("AC_ACCOUNT", m.get(0).getJobID());
        Assert.assertEquals(8300, m.get(0).getSalary());
//        Assert.assertSame(0.2f, m.get(0).getCommisionPCT());
        Assert.assertEquals(205, m.get(0).getManagerID());
        Assert.assertEquals(110, m.get(0).getDepartmentID());
    }

//    @Test
//    public void testUpdate() {
//        iec.update("207", "Sidul", "Boy", "BOYGMAIL", "", "06/07/2002", "AC_ACCOUNT", 8300, 0.2f, 205, 110);
//        List<Employee> m = iec.getById("207");
//        Assert.assertEquals("207", m.get(0).getEmployeeID());
//        Assert.assertEquals("Sidul", m.get(0).getFirstName());
//        Assert.assertEquals("Boy", m.get(0).getLastName());
//        Assert.assertEquals("BOYGMAIL", m.get(0).getEmail());
//        Assert.assertEquals("", m.get(0).getPhoneNumber());
//        Assert.assertEquals("06/07/2002", m.get(0).getHireDate());
//        Assert.assertEquals("AC_ACCOUNT", m.get(0).getJobID());
//        Assert.assertEquals(8300, m.get(0).getSalary());
//        Assert.assertSame(0.2f, m.get(0).getCommisionPCT());
//        Assert.assertEquals(205, m.get(0).getManagerID());
//        Assert.assertEquals(110, m.get(0).getDepartmentID());
//    }
//
//    @Test
//    public void testDelete() {
//        iec.delete("207");
//        List<Employee> m = iec.getById("207");
//        Assert.assertEquals("207", m.get(0).getEmployeeID());
//    }

}
