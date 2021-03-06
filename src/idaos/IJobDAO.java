/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Job;

/**
 *
 * @author Tutus
 */
public interface IJobDAO {
    public List<Job> getAll();
    
    public List<Job> getById(String id);
    
    public List<Job> getMinSalary(int minSalary);
    
    public List<Job> getMaxSalary(int maxSalary);
    
    public List<Job> search(String key);
    
    public boolean insert(Job j);
    
    public boolean update(Job j);
    
    public boolean delete(String id);
}
