/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Job;

/**
 *
 * @author Tutus
 */
public class JobDAO implements IJobDAO {
    private Connection connection;
    
    public JobDAO(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public List<Job> getAll() {
        List<Job> jobs = new ArrayList<Job>();
        String query = "SELECT * FROM JOBS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                j.setId(resultSet.getString(1));
                j.setName(resultSet.getString(2));
                j.setMinSalary(resultSet.getInt(3));
                j.setMaxSalary(resultSet.getInt(4));
                jobs.add(j);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return jobs;
    }

    @Override
    public List<Job> getById(String id) {
        List<Job> jobs = new ArrayList<Job>();
        String query = "SELECT * FROM JOBS WHERE job_id=?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job r = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                jobs.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return jobs;
    }

    @Override
    public List<Job> search(String key) {
        
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM JOBS WHERE job_id LIKE ? OR job_title LIKE ? OR min_salary LIKE ? OR max_salary LIKE ?";
        try {
            key="%"+key+"%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, key);
            preparedStatement.setString(3, key);
            preparedStatement.setString(4, key);
            ResultSet results = preparedStatement.executeQuery();
            while (results.next()) {
                Job r = new Job(results.getString(1), results.getString(2), results.getInt(3), results.getInt(4));
                jobs.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return jobs;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Job j) {
       boolean result = false;
        String query = "INSERT INTO JOBS(job_id, job_title,min_salary, max_salary) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getId());
            preparedStatement.setString(2, j.getName());
            preparedStatement.setInt(3, j.getMinSalary());
            preparedStatement.setInt(4, j.getMaxSalary());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Job j) {
        boolean result = false;
        String query = "UPDATE JOBS SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getName());
            preparedStatement.setInt(2, j.getMinSalary());
            preparedStatement.setInt(3, j.getMaxSalary());
            preparedStatement.setString(4, j.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        String query = "DELETE FROM JOBS WHERE job_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
        }
        return result;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Job> getMinSalary(int minSalary) {
         List<Job> jobs = new ArrayList<Job>();
        String query = "SELECT * FROM JOBS WHERE min_salary=?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, minSalary);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job r = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                jobs.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return jobs;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Job> getMaxSalary(int maxSalary) {
        List<Job> jobs = new ArrayList<Job>();
        String query = "SELECT * FROM JOBS WHERE max_salary=?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, maxSalary);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job r = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                jobs.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return jobs;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
