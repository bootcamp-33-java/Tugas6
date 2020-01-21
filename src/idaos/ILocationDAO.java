/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Location;

/**
 *
 * @author aqira
 */
public interface ILocationDAO {
    
    public List<Location> getAll();

    public List<Location> getById(int id);

    public List<Location> search(String key);

    public boolean insert(Location l);

    public boolean update(Location l);

    public boolean delete(int id);
}
