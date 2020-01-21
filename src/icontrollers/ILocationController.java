/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Location;


public interface ILocationController {
   
    public List<Location> getAll();
   
    public List<Location> getLocid (String locid);
   
    public List<Location> search(String key);
   
    public String insert(String locid, String stradd, String poscode,String city, String staprov, String counid);
    
    public String update (String locid, String stradd, String poscode,String city, String staprov, String counid);
   
    public String delete(String locid);

    public void insert(String text, String text0);

    public void update(String text, String text0);

    public Iterable<Location> getById(String val);

    public Iterable<Location> getByName(String val);

    public Iterable<Location> getByLocid(String val);

    public Iterable<Location> getByStradd(String val);

    public void insert(String text, String text0, String text1, String text2);
    
}
