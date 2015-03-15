/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_gestion;
import java.sql.SQLException;  
import java.util.ArrayList;  
import lib_clases.*;
import lib_datos.*;
public class gestion {

    BaseDatos_principal BD = null;
    public gestion() {
        BaseDatos_principal BD = new BaseDatos_principal();
    }
    
    public void Insertar(entidad Entidad, principal Principal, dprincipal Dprincipal) throws SQLException {  
        BD.Insert(Entidad, Principal, Dprincipal);
    }  
    public void Actualizar(entidad Entidad, principal Principal, dprincipal Dprincipal)throws SQLException {  
        BD.Update(Entidad, Principal, Dprincipal);
    }  
    public ArrayList<entidad> ListarEntidad() throws SQLException{ return BD.Listar_Entidades();}
    public ArrayList<dprincipal> Listar_principal(int identidad) throws SQLException{ return BD.Listar_principal(identidad);}
 
}
