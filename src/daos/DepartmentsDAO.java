/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IDepartmentsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Departments;

/**
 *
 * @author BWP
 */
public class DepartmentsDAO implements IDepartmentsDAO {

    private Connection connection;

    public DepartmentsDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Departments> getAll() {
        List<Departments> listDepartments = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Departments r = new Departments(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listDepartments.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listDepartments;
    }

    @Override
    public boolean insert(Departments j) {
        boolean result = false;
        String query = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, j.getDepatmentID());
            preparedStatement.setString(2, j.getDepartmentName());
            preparedStatement.setInt(3, j.getManagerID());
            preparedStatement.setInt(4, j.getLocationID());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Departments> getById(int key) {
        List<Departments> listDepartments = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Departments r = new Departments(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listDepartments.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listDepartments;
    }

    @Override
    public List<Departments> search(String key) {
        List<Departments> listJobGrades = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE ?";
        try {
            key = "%" + key + "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Departments r = new Departments(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJobGrades.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listJobGrades;
    }

    @Override
    public boolean update(Departments j) {
        boolean result = false;
        String query = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID= ?, LOCATION_ID = ? WHERE DEPARTMENT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getDepartmentName());
            preparedStatement.setInt(2, j.getManagerID());
            preparedStatement.setInt(3, j.getLocationID());
             preparedStatement.setInt(4, j.getDepatmentID());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
