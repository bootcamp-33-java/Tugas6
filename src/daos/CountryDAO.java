/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ICountryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author BWP
 */
public class CountryDAO implements ICountryDAO {

    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Country> getAll() {
        List<Country> listCountry = new ArrayList<>();
        String query = "SELECT * FROM COUNTRIES";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country r = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                listCountry.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listCountry;
    }

    @Override
    public boolean insert(Country j) {
        boolean result = false;
        String query = "INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getCountryID());
            preparedStatement.setString(2, j.getCountryName());
            preparedStatement.setInt(3, j.getRegionID());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Country> getById(String key) {
        List<Country> listCountry = new ArrayList<>();
        String query = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country r = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                listCountry.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listCountry;
    }

    @Override
    public List<Country> search(String key) {
        List<Country> listJobGrades = new ArrayList<>();
        String query = "SELECT * FROM COUNTRIES WHERE COUNTRY_NAME LIKE ?";
        try {
            key = "%" + key + "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country r = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                listJobGrades.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listJobGrades;
    }

    @Override
    public boolean update(Country j) {
        boolean result = false;
        String query = "UPDATE COUNTRIES SET COUNTRY_NAME = ?, REGION_ID = ? WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getCountryName());
            preparedStatement.setInt(2, j.getRegionID());
            preparedStatement.setString(3, j.getCountryID());
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
        String query = "DELETE FROM COUNTRIES WHERE COUNTRY_ID = ? ";
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
