/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author Tutus
 */
public interface IJobController {
     public List<Job> getAll();
    public List<Job> getById(String id);
    public List<Job> getMinSalary(String minSalary);
    public List<Job> getMaxSalary(String maxSalary);
    public List<Job> search(String key);
    public String insert(String id, String name, String minSalary, String maxSalary);
    public String update(String id, String name, String minSalary, String maxSalary);
    public String delete(String id);
}
