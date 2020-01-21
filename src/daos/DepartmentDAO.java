/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IDepartmentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Department;

/**
 *
 * @author Insane
 */
public class DepartmentDAO implements IDepartmentDAO {

    private Connection connection;
    boolean result = false;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Department> getAll() {
        List<Department> listDepartment = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setManagerId(resultSet.getInt(3));
                d.setLocationId(resultSet.getInt(4));
                listDepartment.add(d);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return listDepartment;
    }

    @Override
    public List<Department> getById(int id) {
        List<Department> listDepartment = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {//memeriksa apakah 
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                //r.setId(resultSet.getInt(1));
                //r.setName(resultSet.getString(2));
                listDepartment.add(d);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return listDepartment;
    }

    @Override
    public List<Department> search(String key) {
        List<Department> listDepartment = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID LIKE(?) OR DEPARTMENT_NAME (?) ORDER BY DEPARTMENT_ID ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listDepartment.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listDepartment;
    }

    @Override
    public boolean insert(Department d) {

        String query = "INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, d.getId());
            preparedStatement.setString(2, d.getName());
            preparedStatement.setInt(3, d.getManagerId());
            preparedStatement.setInt(4, d.getLocationId());
            preparedStatement.executeQuery();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Department d) {

        String query = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ? WHERE DEPARTMENT_ID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d.getName());
            preparedStatement.setInt(2, d.getManagerId());
            preparedStatement.setInt(3, d.getLocationId());
            preparedStatement.setInt(4, d.getId());
            preparedStatement.executeQuery();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {

        String query = "DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Department> getByName(String name) {
List<Department> listDepartment = new ArrayList<>();
        String query = "SELECT * FROM DEPARTMENTS WHERE department_name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {//memeriksa apakah 
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listDepartment.add(d);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return listDepartment;    }

}
