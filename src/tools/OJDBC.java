/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import models.Region;

/**
 *
 * @author BWP
 */
public class OJDBC {

    public static void main(String[] args) {
//        DBConnection db = new DBConnection();
//        System.out.println(db.getConnection());
        Region region = new Region();
        region.setId(0);
        region.setName("region");
        System.out.println(region.getId() + " " + region.getName());

        Region r = new Region(1, "Region New");
        System.out.println(r.getId() + " " + r.getName());
    }

}
