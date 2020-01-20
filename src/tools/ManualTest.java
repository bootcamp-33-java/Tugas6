/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.RegoinDAO;
import idaos.IRegionDAO;
import models.Region;

/**
 *
 * @author BWP
 */
public class ManualTest {

    DBConnection connection = new DBConnection();
    IRegionDAO irdao = new RegoinDAO(connection.getConnection());

    public void getAll() {

        for (Region region : irdao.getAll()) {
            System.out.println(region.getId());
            System.out.println(region.getName());
        }
    }

    public void insert() {
        Region region = new Region(31, "Indonesia");
        System.out.println(irdao.insert(region));
    }

    public void getById() {
        for (Region region : irdao.getById(3)) {
            System.out.println(region.getId());
            System.out.println(region.getName());
        }
    }

    public void search() {
        for (Region region : irdao.search("1")) {
            System.out.println(region.getId());
            System.out.println(region.getName());
        }
    }

    public void update() {
        Region region = new Region(31, "Ambyar");
        System.out.println(irdao.update(region));

    }

    public void delete() {
        System.out.println(irdao.delete(31));
    }

    public static void main(String[] args) {
        ManualTest testing = new ManualTest();
//       testing.getAll();
//        testing.insert();
        testing.getById();
//        testing.search();
//        testing.delete();
//        testing.update();
    }
}
