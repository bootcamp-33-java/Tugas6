/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnitTestRegion;

import controllers.JobController;
import icontrollers.IJobController;
import java.util.List;
import models.Job;
import org.junit.Assert;
import org.junit.Test;
import tools.DBConnection;

/**
 *
 * @author ASUS
 */
public class JUnitTestJob {

    DBConnection connection = new DBConnection();
    IJobController ijc = new JobController(connection.getConnection());
    
    public JUnitTestJob(){
    }
    
//    @Test
//    public void testgetById(){
//        List<Job> act = ijc.getById("1");
//        Assert.assertNotNull(act);
//    }
//    
//    @Test
//    public void testGetAll(){
//        List<Job> act3 = ijc.getAll();
//        Assert.assertNotNull(act3);
//    }
//    
    @Test
    public void testSearch(){
        List<Job> act2 = ijc.search("1");
        Assert.assertNotNull(act2);
    }
    
//    @Test
//    public void testInsert(){
//        ijc.insert("111", "Bekerja di", "0", "0");
////        ijc.insert("111", "NamaSaya"," " ,"");
//        List<Job> m = ijc.getById("111");
//        Assert.assertEquals("111", m.get(0).getId());
//        Assert.assertEquals("Bekerja di ", m.get(0).getName());
//    }
//  
//    @Test
//    public void testUpdate(){
//        ijc.update("111", "NamaSayaIni","0","0");
//        List<Job> m = ijc.getById("111");
//        Assert.assertEquals("111", m.get(0).getId());
//        Assert.assertEquals("Bekerja di ", m.get(0).getName());
//    }
//    
//    @Test
//    public  void testDelete(){
//        ijc.delete("111");
//        Assert.assertNull(ijc.getById("111"));
//    }
}

