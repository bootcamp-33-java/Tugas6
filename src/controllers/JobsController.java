/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobsDAO;
import daos.RegoinDAO;
import icontrollers.IJobsController;
import idaos.IJobsDAO;
import java.sql.Connection;
import java.util.List;
import models.Jobs;

/**
 *
 * @author BWP
 */
public class JobsController implements IJobsController {

    private IJobsDAO irdao;

    public JobsController(Connection connection) {
        irdao = new JobsDAO(connection);
    }

    @Override
    public List<Jobs> getAll() {
        return irdao.getAll();
    }

    @Override
    public List<Jobs> getById(String id) {
        return irdao.getById(id);
    }

    @Override
    public List<Jobs> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(Jobs j) {
        String result = "";
        Jobs jobs = new Jobs(j.getJobId(), j.getJobTitle(), j.getMinSal(), j.getMaxSal());

        if (irdao.insert(jobs)) {
            result = "Data berhasil disimpan";
        } else {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String update(Jobs j) {
        String result = "";
        Jobs jobs = new Jobs(j.getJobId(), j.getJobTitle(), j.getMinSal(), j.getMaxSal());
        
        if (irdao.update(jobs)) {
            result = "Data berhasil diupdate";
        } else {
            result = "Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if (irdao.delete(id)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }
}
