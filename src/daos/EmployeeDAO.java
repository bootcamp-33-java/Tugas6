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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Employee;

/**
 *
 * @author Bagus Widyantoro Putro
 */
public class EmployeeDAO implements IEmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean save(Employee employee) {
        boolean result = false;
        String query = (getData(employee.getId(),"").isEmpty())
                ? "INSERT INTO EMPLOYEES(FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER,"
                + "HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID"
                + ", DEPARTMENT_ID, EMPLOYEE_ID) VALUES (?,?,?,?,TO_DATE(?, 'mm/dd/yyyy'),?,?,?,?,?,?)"
                : "UPDATE EMPLOYEES SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PHONE_NUMBER = ? "
                + ", HIRE_DATE = TO_DATE(?, 'mm/dd/yyyy'), JOB_ID = ?, SALARY = ?,"
                + " COMMISSION_PCT = ?, MANAGER_ID = ?, DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getHireDate());
            preparedStatement.setString(6, employee.getJobID());
            preparedStatement.setInt(7, employee.getSalary());
            preparedStatement.setFloat(8, employee.getCommisionPCT());
            preparedStatement.setInt(9, employee.getManagerID());
            preparedStatement.setInt(10, employee.getDepartmentID());
            preparedStatement.setInt(11, employee.getId());
            preparedStatement.executeQuery();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public List<Employee> getData(int id, String key) {
        List<Employee> employees = new ArrayList<>();

        String query = (id == 0 && key.equals(""))
                ? "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER,"
                + "TO_CHAR(HIRE_DATE, 'mm/dd/yyyy'), JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID"
                + ", DEPARTMENT_ID FROM EMPLOYEES ORDER BY EMPLOYEE_ID" //getALL
                : (key.equals(""))
                        ? "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?" //get by ID
                        : "SELECT * FROM EMPLOYEES WHERE REGEXP_LIKE (FIRST_NAME,?,'i') OR REGEXP_LIKE (LAST_NAME,?,'i')" 
                        + "OR REGEXP_LIKE (EMPLOYEE_ID,?,'i') OR REGEXP_LIKE (EMAIL,?,'i') OR REGEXP_LIKE (PHONE_NUMBER,?,'i')OR REGEXP_LIKE (HIRE_DATE,?,'i')"
                        + "OR REGEXP_LIKE (JOB_ID,?,'i') OR REGEXP_LIKE (SALARY,?,'i') OR REGEXP_LIKE (COMMISSION_PCT,?,'i')OR REGEXP_LIKE (MANAGER_ID,?,'i')"
                        + "OR REGEXP_LIKE (DEPARTMENT_ID,?,'i') ORDER BY EMPLOYEE_ID"; //Search
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            if (key.equals("") && id != 0) { //getID
                preparedStatement.setInt(1, id);
            } else if (!key.isEmpty() && id == 0) { //search
                for (int i = 1; i <= 11; i++) {
                    preparedStatement.setString(i, key);
                }
            }//getall biarkan syaja
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee r = new Employee(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),
                        resultSet.getFloat(9), resultSet.getInt(10), resultSet.getInt(11));
                employees.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
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
