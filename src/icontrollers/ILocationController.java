/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Location;

/**
 *
 * @author aqira
 */
public interface ILocationController {
    
    public List<Location> getAll();
    
    public List<Location> getById(String id);
    
    public List<Location> search (String key);
    
    public String insert (String id, String address, String postalCode, String city, String stateProvince, String countryId);
    
    public String update (String id, String address, String postalCode, String city, String stateProvince, String countryId);
    
    public String delete (String id);
}
