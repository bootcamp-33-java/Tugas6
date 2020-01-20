/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author BWP
 */
public class RegoinDAO implements IRegionDAO {

    private Connection connection;

    public RegoinDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<>();
        String query = "SELECT * FROM REGIONS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
                listRegion.add(r);

            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listRegion;
    }

    @Override
    public boolean insert(Region r) {
        boolean result = false;
        String query = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getId());
            preparedStatement.setString(2, r.getName());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Region> getById(int key) {
        List<Region> listRegion = new ArrayList<>();
        String query = "SELECT * FROM REGIONS WHERE REGION_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                listRegion.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listRegion;
    }

    @Override
    public List<Region> search(String key) {
        List<Region> listRegion = new ArrayList<>();
        String query = "SELECT * FROM REGIONS WHERE REGION_NAME LIKE ? OR REGION_ID LIKE ?";
        try {
            key = "%"+key+"%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                listRegion.add(r);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return listRegion;
    }

    @Override
    public boolean update(Region r) {
        boolean result = false;
        String query = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getName());
            preparedStatement.setInt(2, r.getId());
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
        String query = "DELETE FROM REGIONS WHERE REGION_ID = ? ";
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
