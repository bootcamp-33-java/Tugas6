/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Country;

/**
 *
 * @author Galih Satriya
 */
public interface ICountryDAO {

    public List<Country> getAll();

    public List<Country> getById(String id);

    public List<Country> search(String key);

    public boolean insert(Country r);

    public boolean update(Country r);

    public boolean delete(String id);
}
