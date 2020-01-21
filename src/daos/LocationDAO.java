/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import idaos.ILocationDAO;

/**
 *
 * @author aqira
 */
public class LocationDAO implements ILocationDAO {

    private Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Location> getAll() {

        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS ORDER BY location_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                l.setId(resultSet.getInt(1));
                l.setAddress(resultSet.getString(2));
                l.setPostalCode(resultSet.getString(3));
                l.setCity(resultSet.getString(4));
                l.setStateProvince(resultSet.getString(5));
                l.setCountryId(resultSet.getString(6));

                listLocation.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listLocation;
    }

    @Override
    public List<Location> getById(int id) {
        List<Location> listLocation = new ArrayList<Location>();
        String query = "SELECT * FROM LOCATIONS WHERE location_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                l.setId(resultSet.getInt(1));
                l.setAddress(resultSet.getString(2));
                l.setPostalCode(resultSet.getString(3));
                l.setCity(resultSet.getString(4));
                l.setStateProvince(resultSet.getString(5));
                l.setCountryId(resultSet.getString(6));

                listLocation.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listLocation;
    }

    @Override
    public List<Location> search(String key) {
        List<Location> listSearch = new ArrayList();
        String query = "SELECT * FROM locations WHERE location_id LIKE '%?%' OR street_address LIKE '%?%' OR postal_code LIKE '%?%' OR city LIKE '%?%' OR state_province LIKE '%?%' OR country_id LIKE '%?%'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, key);
            preparedStatement.setString(3, key);
            preparedStatement.setString(4, key);
            preparedStatement.setString(5, key);
            preparedStatement.setString(6, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));

                listSearch.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSearch;
    }

    @Override
    public boolean insert(Location l) {
        boolean result = false;
        String query = "INSERT INTO LOCATIONS(Location_id, street_address, postal_code,city,state_province,country_id) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, l.getId());
            preparedStatement.setString(2, l.getAddress());
            preparedStatement.setString(3, l.getPostalCode());
            preparedStatement.setString(4, l.getCity());
            preparedStatement.setString(5, l.getStateProvince());
            preparedStatement.setString(6, l.getCountryId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Location l) {
        boolean result = false;
        String query = "UPDATE locations SET state_address = '?', postal_code = '?', city = '?', state_province = '?', country_id = '?' "
                + "WHERE location_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, l.getAddress());
            preparedStatement.setString(2, l.getPostalCode());
            preparedStatement.setString(3, l.getCity());
            preparedStatement.setString(4, l.getStateProvince());
            preparedStatement.setString(5, l.getCountryId());
            preparedStatement.setInt(6, l.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM LOCATIONS WHERE Location_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }
}
