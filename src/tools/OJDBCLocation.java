/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.LocationDAO;
import idaos.ILocationDAO;
import models.Location;

/**
 *
 * @author aqira
 */
public class OJDBCLocation {

    DBConnection connection = new DBConnection();
    ILocationDAO ildao = new LocationDAO(connection.getConnection());

    public void getAll() {
        System.out.println(ildao.getAll().size());
        for (Location location : ildao.getAll()) {
            System.out.print(location.getId() + "  | ");
            System.out.print(location.getAddress() + " |  ");
            System.out.print(location.getPostalCode() + " |  ");
            System.out.print(location.getCity() + " |  ");
            System.out.print(location.getStateProvince() + " |  ");
            System.out.println(location.getCountryId() + "  | ");
        }
    }

    public void insert() {
        Location location = new Location(9997, "Indonesia", "40000", "a", "b", "IT");
        System.out.println(ildao.insert(location));
    }

    public void getById() {
        for (Location location : ildao.getById(1000)) {
            System.out.print(location.getId() + "  | ");
            System.out.print(location.getAddress() + " |  ");
            System.out.print(location.getPostalCode() + " |  ");
            System.out.print(location.getCity() + " |  ");
            System.out.print(location.getStateProvince() + " |  ");
            System.out.println(location.getCountryId() + "  | ");
        }
    }

    public void search() {
        for (Location location : ildao.search("null")) {
            System.out.print(location.getId() + "  | ");
            System.out.print(location.getAddress() + " |  ");
            System.out.print(location.getPostalCode() + " |  ");
            System.out.print(location.getCity() + " |  ");
            System.out.print(location.getStateProvince() + " |  ");
            System.out.println(location.getCountryId() + "  | ");
        }
    }

    public void delete() {

        System.out.println(ildao.delete(9997));
    }

    public void update() {
        Location location = new Location(9999,"Bandung","222","z","z","IT");
    }

    public static void main(String[] args) {
        OJDBCLocation testing = new OJDBCLocation();

//        testing.getAll(); //pass
//        testing.insert(); //pass
//        testing.getById(); //pass
        testing.search(); //notyet
//        testing.delete(); //pass
//        testing.update(); //pass
    }
}
