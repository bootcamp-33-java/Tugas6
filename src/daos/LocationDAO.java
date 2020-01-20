/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Location;

/**
 *
 * @author BWP
 */
public class LocationDAO implements ILocationDAO {

    private Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Location> getAll() {
        List<Location> listLocation = new ArrayList<>();
        String query = "SELECT * FROM LOCATIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location r = new Location(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                listLocation.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listLocation;
    }

    @Override
    public boolean insert(Location j) {
        boolean result = false;
        String query = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, j.getLocationID());
            preparedStatement.setString(2, j.getStateProvince());
            preparedStatement.setString(3, j.getPostalCode());
            preparedStatement.setString(4, j.getCity());
            preparedStatement.setString(5, j.getStateProvince());
            preparedStatement.setString(6, j.getCountryID());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Location> getById(int key) {
        List<Location> listLocation = new ArrayList<>();
        String query = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location r = new Location(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                listLocation.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listLocation;
    }

    @Override
    public List<Location> search(String key) {
        List<Location> listLocation = new ArrayList<>();
        String query = "SELECT * FROM LOCATIONS WHERE LOCATION_NAME LIKE ? OR POSTAL_CODE LIKE ? OR CITY LIKE ? OR STATE_PROVINCE LIKE ? OR COUNTRY_ID LIKE ?";
        try {
            key = "%" + key + "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i <= 5; i++) {
                preparedStatement.setString(1, key);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location r = new Location(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                listLocation.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listLocation;
    }

    @Override
    public boolean update(Location j) {
        boolean result = false;
        String query = "UPDATE LOCATIONS SET LOCATION_NAME = ?, POSTAL_CODE = ?,"
                + " CITY = ?,STATE_PROVINCE = ?, COUNTRY_ID = ?,  WHERE LOCATION_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, j.getLocationID());
            preparedStatement.setString(2, j.getStreetAddreess());
            preparedStatement.setString(3, j.getPostalCode());
            preparedStatement.setString(4, j.getCity());
            preparedStatement.setString(5, j.getStateProvince());
            preparedStatement.setString(6, j.getStreetAddreess());
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
        String query = "DELETE FROM LOCATIONS WHERE LOCATION_ID = ? ";
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
