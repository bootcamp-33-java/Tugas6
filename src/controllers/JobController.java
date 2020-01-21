/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import icontrollers.IJobController;
import idaos.IJobDAO;
import java.sql.Connection;
import java.util.List;
import models.Job;

/**
 *
 * @author Tutus
 */
public class JobController implements IJobController{
    private  IJobDAO ijdao;
    public JobController(Connection connection){
        ijdao = new JobDAO(connection);
    }

    @Override
    public List<Job> getAll() {
        return ijdao.getAll();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Job> getById(String id) {
        return ijdao.getById(id);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public List<Job> search(String key) {
        return ijdao.search(key);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String name, String minSalary, String maxSalary) {
        String result = "";
        Job job = new Job(id, name, Integer.parseInt(minSalary),Integer.parseInt(maxSalary));
        if (ijdao.insert(job)) {
            result = "Data Berhasil disimpan";
        } else {
            result = "Maaf data gagal disimpan";
        }
        return result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(String id, String name, String minSalary, String maxSalary) {
        String result = "";
        Job job = new Job(id, name, Integer.parseInt(minSalary), Integer.parseInt(maxSalary));
        if (ijdao.update(job)) {
            result = "Data Berhasil diupdate";
        } else {
            result = "Maaf data gagal dupdate";
        }
        return result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (ijdao.delete(id)) {
            result = "Data Berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Job> getMinSalary(String minSalary) {
        return ijdao.getMinSalary(Integer.parseInt(minSalary));
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Job> getMaxSalary(String maxSalary) {
        return ijdao.getMaxSalary(Integer.parseInt(maxSalary));
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
