package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author FIKRI-PC
 */
public class RegionDAO implements IRegionDAO {

    private Connection connection;

    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAll() {
        List<Region> listRegion = new ArrayList<>();
//        String query = ;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM REGIONS ORDER BY 1");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
//                r.setId(resultSet.getInt(1));
//                r.setName(resultSet.getString(2));
                listRegion.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRegion;
    }
//    public List<Region> getData(int id){
//        List<Region> listRegion = new ArrayList<>();
//        String query = ((id==null))
//                    ? "SELECT * FROM REGIONS ORDER BY 1"
//                    : "SELECT * FROM REGIONS WHERE region_id = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
////                r.setId(resultSet.getInt(1));
////                r.setName(resultSet.getString(2));
//                listRegion.add(r);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listRegion;
//    
//    } 

    @Override
    public List<Region> search(String key) {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM REGIONS WHERE REGEXP_LIKE(region_name,?,'i') OR REGEXP_LIKE(region_id,?,'i')";
//        "SELECT * FROM REGIONS WHERE REGEXP_LIKE(region_name,?,'i') OR REGEXP_LIKE(region_id,?,'i')"
        try {
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
    public List<Region> getById(int id) {
        List<Region> listRegion = new ArrayList<>(id);
        String query = "SELECT * FROM REGIONS WHERE region_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));

                listRegion.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRegion;
    }

    @Override
    public boolean insert(Region r) {
        boolean result = false;
        String query = "INSERT INTO REGIONS(region_id, region_name) VALUES (?,?)";
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
    public boolean update(Region r) {
        boolean result = false;
        String query = "UPDATE REGIONS SET  region_name=? WHERE region_id=?";
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

    public boolean save(Region r) {
        boolean result = false;
        String query = (getById(r.getId()).isEmpty())
                ? "INSERT INTO REGIONS(region_name, region_id) VALUES (?,?)"
                : "UPDATE REGIONS SET region_name=? WHERE region_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, r.getName());
            preparedStatement.setInt(2, r.getId());
            preparedStatement.executeQuery();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM REGIONS WHERE region_id=?";
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

    @Override
    public List<Region> getData(int id, String key) {
        String query = (id == 0 && key.equals("")) ? "SELECT * FROM REGIONS"
                : (key.equals(""))
                ? "SELECT * FROM REGIONS WHERE region_id = ?"
                : "SELECT * FROM REGIONS WHERE REGEXP_LIKE(region_name,?,'i') OR REGEXP_LIKE(region_id,?,'i')";

        List<Region> regions = new ArrayList();

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
                Region r = new Region(resultSet.getInt(1), resultSet.getString(2));
                regions.add(r);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return regions;
    }
}
