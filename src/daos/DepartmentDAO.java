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
    public List<Department> getData(int id, String key) {
        String query = (id == 0 && key.equals("")) ? "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC"
                : (key.equals(""))
                ? "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?"
                : "SELECT * FROM DEPARTMENTS WHERE REGEXP_LIKE(department_name,?,'i') OR REGEXP_LIKE(department_id,?,'i')";

        List<Department> departments = new ArrayList();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (key.equals("") && 0 != id) {
                preparedStatement.setInt(1, id);
            } else if (!key.equals("") && 0 == id) {
                preparedStatement.setString(1, key);
                preparedStatement.setString(2, key);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                departments.add(d);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return departments;
    }

    @Override
    public boolean save(Department d) {
        String query = (getData(d.getId(),"").isEmpty())
                ? "INSERT INTO DEPARTMENTS(DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID, DEPARTMENT_ID) VALUES (?, ?, ?, ?)"
                : "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ? WHERE DEPARTMENT_ID=?";
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

}
