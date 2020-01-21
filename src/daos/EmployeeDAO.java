/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Employee;

/**
 *
 * @author Bagus Widyantoro Putro
 */
public class EmployeeDAO implements IEmployeeDAO{

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> listEmployees = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee r = new Employee(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getFloat(9), resultSet.getInt(10), resultSet.getInt(11));
                listEmployees.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listEmployees;
    }

    @Override
    public boolean insert(Employee j) {
        boolean result = false;
        String query = "INSERT INTO EMPLOYEES VALUES (?,?,?,?,?,TO_DATE(?, 'mm/dd/yyyy'),?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, j.getId());
            preparedStatement.setString(2, j.getFirstName());
            preparedStatement.setString(3, j.getLastName());
            preparedStatement.setString(4, j.getEmail());
            preparedStatement.setString(5, j.getPhoneNumber());
            //preparedStatement.setString(5, "");
            preparedStatement.setString(6, j.getHireDate());
            preparedStatement.setString(7, j.getJobID());
            preparedStatement.setInt(8, j.getSalary());
            preparedStatement.setFloat(9, j.getCommisionPCT());
            preparedStatement.setInt(10, j.getManagerID());
            preparedStatement.setInt(11, j.getDepartmentID());
            preparedStatement.executeQuery();
            result = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Employee> getById(int key) {
        List<Employee> listEmployees = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee r = new Employee(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getFloat(9), resultSet.getInt(10), resultSet.getInt(11));
                listEmployees.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listEmployees;
    }

    @Override
    public List<Employee> search(String key) {
        List<Employee> listEmployees = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE ? OR LAST_NAME LIKE ? "
                + "OR EMPLOYEE_ID LIKE ? OR EMAIL LIKE ? OR PHONE_NUMBER LIKE ? OR HIRE_DATE LIKE ? "
                + "OR JOB_ID LIKE ? OR SALARY LIKE ? OR COMMISSION_PCT LIKE ? OR MANAGER_ID LIKE ? "
                + "OR DEPARTMENT_ID LIKE ? ORDER BY EMPLOYEE_ID 1";
        try {
            key = "%" + key + "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 1; i <= 11; i++) {
                preparedStatement.setString(i, key);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee r = new Employee(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getFloat(9), resultSet.getInt(10), resultSet.getInt(11));
                listEmployees.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listEmployees;
    }

    @Override
    public boolean update(Employee j) {
        boolean result = false;
        String query = "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ? "
                + ", HIRE_DATE = TO_DATE(?, 'mm/dd/yyyy'), JOB_ID = ?, SALARY = ?, COMMISSION_PCT = ?, MANAGER_ID = ?, DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getFirstName());
            preparedStatement.setString(2, j.getLastName());
            preparedStatement.setString(3, j.getEmail());
            preparedStatement.setString(4, j.getPhoneNumber());
            preparedStatement.setString(5, j.getHireDate());
            preparedStatement.setString(6, j.getJobID());
            preparedStatement.setInt(7, j.getSalary());
            preparedStatement.setFloat(8, j.getCommisionPCT());
            preparedStatement.setInt(9, j.getManagerID());
            preparedStatement.setInt(10, j.getDepartmentID());
            preparedStatement.setInt(11, j.getId());
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
        String query = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ? ";
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
