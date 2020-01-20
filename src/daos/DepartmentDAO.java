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
import java.util.ArrayList;
import java.util.List;
import models.Department;
import models.Location;
/**
 *
 * @author Insane
 */
public class DepartmentDAO implements IDepartmentDAO{
    
    private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public List<Department> getAll() {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)); 
                d.setId(resultSet.getInt(1));
                d.setName(resultSet.getString(2));
                d.setManagerId(resultSet.getInt(3));
                d.setLocationId(resultSet.getInt(4));
                listDepartment.add(d);
            }
       } catch (Exception e) {
           e.getStackTrace();
        }
        return listDepartment; 
    }

    @Override
    public List<Department> getById(int id) {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {//memeriksa apakah 
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)); 
                //r.setId(resultSet.getInt(1));
                //r.setName(resultSet.getString(2));
                listDepartment.add(d);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listDepartment;
    }

    @Override
    public List<Department> search(String key) {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID LIKE(?) OR DEPARTMENT_NAME (?) ORDER BY DEPARTMENT_ID ASC";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1,"%" + key + "%");
            preparedStatement.setString(2,"%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)); 
                listDepartment.add(d);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listDepartment;
    }

    @Override
    public boolean insert(Department d) {
        boolean result = false;
        String query = "INSERT INTO DEPARTMENTS(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, l.get());
            preparedStatement.setString(2, l.getStradd() );
            preparedStatement.setInt(3, l.getPoscode());
            preparedStatement.setString(4, l.getCity() );
            preparedStatement.setString(5, l.getStaprov() ); 
            preparedStatement.setString(6, l.getCounid() ); 
            preparedStatement.executeQuery();
            result = true;
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Department d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
