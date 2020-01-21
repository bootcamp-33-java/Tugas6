/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Country;

/**
 *
 * @author Galih Satriya
 */
public interface ICountryController {

    public List<Country> getAll();
    public List<Country> getById(String id);
    public List<Country> search(String Key);
    public String insert(String id,String name,String regionId);
    public String update(String id, String name, String regionId);
    public String delete(String id);
    public Iterable<Country> getByName(String Val);
}
