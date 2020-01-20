/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.IDepartmentDAO;
import java.sql.Connection;
import java.util.List;
import models.Department;
/**
 *
 * @author Insane
 */
public class DepartmentController implements IDepartmentController {
    
    private IDepartmentDAO iddao;
    
    public DepartmentController(Connection connection) {
        iddao = new DepartmentDAO(connection);
    }
}
