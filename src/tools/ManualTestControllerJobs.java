/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.JobsController;
import icontrollers.IJobsController;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import models.Jobs;
import models.Region;

/**
 *
 * @author BWP
 */
public class ManualTestControllerJobs {

    DBConnection connection = new DBConnection();
    IJobsController irdao = new JobsController(connection.getConnection());

    public void getAll() {

        for (Jobs jobs : irdao.getAll()) {
            System.out.println(jobs.getJobId());
            System.out.println(jobs.getJobTitle());
            System.out.println(jobs.getMinSal());
            System.out.println(jobs.getMaxSal());
        }
    }

    public void insert() {
        Jobs jobs = new Jobs("BB33","BOOTCAMP33" ,70000, 80000);
        System.out.println(irdao.insert(jobs));
    }

    public void getById() {
        for (Jobs jobs : irdao.getById("AD_VP")) {
            System.out.println(jobs.getJobId());
            System.out.println(jobs.getJobTitle());
            System.out.println(jobs.getMinSal());
            System.out.println(jobs.getMaxSal());
        }
    }

    public void search() {
        for (Jobs jobs : irdao.search("AD_VP")) {
            System.out.println(jobs.getJobId());
            System.out.println(jobs.getJobTitle());
            System.out.println(jobs.getMinSal());
            System.out.println(jobs.getMaxSal());
        }
    }

    public void update() {
        Jobs jobGrades = new Jobs("ST_MAN","SANTUY", 1000, 2000);
        System.out.println(irdao.update(jobGrades));

    }

    public void delete() {
        System.out.println(irdao.delete("IT_PROG"));
    }

    public static void main(String[] args) {
        ManualTestControllerJobs testing = new ManualTestControllerJobs();
        testing.getAll();
//        testing.insert();
//        testing.getById();
//        testing.search();
//        testing.delete();
//        testing.update();
    }
}
