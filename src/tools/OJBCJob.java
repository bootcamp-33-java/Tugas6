/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import models.Job;
import daos.JobDAO;
import idaos.IJobDAO;

/**
 *
 * @author ASUS
 */
public class OJBCJob {
    
    DBConnection connection = new DBConnection();
    IJobDAO ijdao = new JobDAO(connection.getConnection());
    
    public void update(){
        Job job = new Job("AD_LOL","BBBL",2000,3000);
        System.out.println(ijdao.update(job));
    }
    
    public void search(){
        for (Job job : ijdao.search("AD")) {
            System.out.println(job.getId());
            System.out.println(job.getName());
            System.out.println(job.getMinSalary());
            System.out.println(job.getMaxSalary());
        }
    }
    public static void main(String[] args) {
        OJBCJob testing = new OJBCJob();
//        testing.update();
        testing.search();
    }
}
