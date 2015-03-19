/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_gestion;

import java.sql.SQLException;
import java.util.ArrayList;
import lib_clases.departamento;
import lib_clases.permiso;
import lib_clases.usuario;
import lib_datos.BaseUsuario;

/**
 *
 * @author Usuario
 */
public class gestionUsuario {

    BaseUsuario bd;
    public gestionUsuario() {
        bd= new BaseUsuario();
    }
    
    public int logear(usuario us) throws SQLException
    {
        return bd.logear(us);
    }
    public ArrayList<usuario> listarU() throws SQLException
    {
        return bd.listar();
    }
    public ArrayList<departamento> listarDepartamento() throws SQLException
    {
        return bd.listaDepartamento();
    }
    
    public void IngresaPermiso(ArrayList<permiso> permisos) throws SQLException
    {
        bd.InsertarPermiso(permisos);
    }
    
    
}
