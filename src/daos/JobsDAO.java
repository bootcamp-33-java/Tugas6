/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Jobs;

/**
 *
 * @author BWP
 */
public class JobsDAO implements IJobsDAO {

    private Connection connection;

    public JobsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Jobs> getAll() {
        List<Jobs> listJobs = new ArrayList<>();
        String query = "SELECT * FROM JOBS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Jobs r = new Jobs(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJobs.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listJobs;
    }

    @Override
    public boolean insert(Jobs j) {
        boolean result = false;
        String query = "INSERT INTO JOBS (JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getJobId());
            preparedStatement.setString(2, j.getJobTitle());
            preparedStatement.setInt(3, j.getMinSal());
            preparedStatement.setInt(4, j.getMaxSal());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Jobs> getById(String key) {
        List<Jobs> listJobs = new ArrayList<>();
        String query = "SELECT * FROM JOBS WHERE JOB_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Jobs r = new Jobs(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJobs.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listJobs;
    }

    @Override
    public List<Jobs> search(String key) {
        List<Jobs> listJobGrades = new ArrayList<>();
        String query = "SELECT * FROM JOBS WHERE JOB_TITLE LIKE ?";
        try {
            key = "%" + key + "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Jobs r = new Jobs(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJobGrades.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listJobGrades;
    }

    @Override
    public boolean update(Jobs j) {
        boolean result = false;
        String query = "UPDATE JOBS SET JOB_TITLE = ?, MIN_SALARY = ?, MAX_SALARY = ? WHERE JOB_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getJobTitle());
            preparedStatement.setInt(2, j.getMinSal());
            preparedStatement.setInt(3, j.getMaxSal());
             preparedStatement.setString(4, j.getJobId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        String query = "DELETE FROM JOBS WHERE JOB_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
