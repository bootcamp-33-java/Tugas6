/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.CountryDAO;
import daos.RegionDAO;
//import daos.RegionDAO;
import idaos.ICountryDAO;
//import idaos.IRegionDAO;
import models.Country;
import models.Region;
//import models.Region;

public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId() + " " + region.getName());
//
//        Region r = new Region(1, "Region New");
//        System.out.println(r.getId() + " " + r.getName());

        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());
//        GetAll Regions-----------
        int i;
        RegionDAO irdao = new RegionDAO(connection.getConnection());
        for (Region region : irdao.getData(0, "b")) {
            System.out.println(region.getId());
            System.out.println(region.getName());
        }
//          GetById Regions----------
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        for (Region region : irdao.getById(2)) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
//          Search Regions-----------
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        for (Region region : irdao.search("A")) {
//           System.out.println(region.getId());
//            System.out.println(region.getName());
//          Insert Regions-----------
//                RegionDAO irdao = new RegionDAO(connection.getConnection());
//            Region region =new Region(99,"semarang"); 
//            System.out.println(irdao.save(region));
//            System.out.println(region.getName());
//          Update Regions------------
//                IRegionDAO irdao = new RegionDAO(connection.getConnection());
//            Region region =new Region(31,"Salatiga"); 
//            System.out.println(irdao.update(region));
//           Delete Regions-----------
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        System.out.println(irdao.delete(31));
//----------------------------------------------------------------------------

//        GetAll Countries-----------
//        ICountryDAO icdao = new CountryDAO(connection.getConnection());
//        for (Country country : icdao.getAll()) {
//            System.out.println(country.getCid());
//            System.out.println(country.getRid());
//            System.out.println(country.getName());
////          GetById Countries----------
//        ICountryDAO icdao = new CountryDAO(connection.getConnection());
//        for (Country country : icdao.getById("AR")) {
//            System.out.println(country.getCid());
//            System.out.println(country.getRid());
//            System.out.println(country.getName());
//          Search Countries-----------
//        ICountryDAO icdao = new CountryDAO(connection.getConnection());
//        for (Country country : icdao.search("A")) {
//           System.out.println(country.getCid());
//           System.out.println(country.getRid());
//            System.out.println(country.getName());
//          Insert Countries-----------
//                IRegionDAO irdao = new RegionDAO(connection.getConnection());
//            Region region =new Region(32,"Jogjaku"); 
//            System.out.println(irdao.insert(region));
//            System.out.println(region.getName());
//          Update Countries------------
//                IRegionDAO irdao = new RegionDAO(connection.getConnection());
//            Region region =new Region(31,"Salatiga"); 
//            System.out.println(irdao.update(region));
//           Delete Countries-----------
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        System.out.println(irdao.delete(31));
    }
}
