/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.JobsController;
import controllers.RegionController;
import icontrollers.IJobsController;
import icontrollers.IRegionController;
import java.util.List;
import models.Jobs;
import models.Region;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.*;
import tools.DBConnection;

/**
 *
 * @author BWP
 */
public class JUnitTestJobs {

    DBConnection connection = new DBConnection();
    IJobsController irc = new JobsController(connection.getConnection());

    public JUnitTestJobs() {
    }

    @Test
    public void testGetById() {
        List<Jobs> act = irc.getById("AD_VP");
        Assert.assertNotNull(act);
    }

    @Test
    public void testGetAll() {
        List<Jobs> act3 = irc.getAll();
        Assert.assertNotNull(act3);
    }

    @Test
    public void testSearch() {
        List<Jobs> act2 = irc.search("ST_MAN");
        Assert.assertNotNull(act2);
    }

    @Test
    public void testInsert() {
        Jobs jobs = new Jobs("BB44","BOOTCAMP33" ,70000, 80000);
        irc.insert(jobs);
        List<Jobs> m = irc.getById(jobs.getJobId());
        Assert.assertEquals(jobs.getJobId(), m.get(0).getJobId());
        Assert.assertEquals(jobs.getJobTitle(), m.get(0).getJobTitle());
        Assert.assertEquals(jobs.getMinSal(), m.get(0).getMinSal());
        Assert.assertEquals(jobs.getMaxSal(), m.get(0).getMaxSal());
    }

    @Test
    public void testUpadate() {
        Jobs jobs = new Jobs("ST_MAN","SANTUY", 1000, 2000);
        irc.update(jobs);
        List<Jobs> m = irc.getById(jobs.getJobId());
        Assert.assertEquals(jobs.getJobId(), m.get(0).getJobId());
        Assert.assertEquals(jobs.getJobTitle(), m.get(0).getJobTitle());
        Assert.assertEquals(jobs.getMinSal(), m.get(0).getMinSal());
        Assert.assertEquals(jobs.getMaxSal(), m.get(0).getMaxSal());
    }

    @Test
    public void testDelete() {
        irc.delete("BB44");
        Assert.assertTrue(irc.getById("BB44").toString() == "[]");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
