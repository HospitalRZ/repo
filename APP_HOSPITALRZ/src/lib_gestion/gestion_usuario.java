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
/**
 *
 * @author juliovicente
 */
public class gestion_usuario {
    BaseDatos_usuario BD = null;

    public gestion_usuario() {
        BD = new BaseDatos_usuario();
    }
    public void Insertar(usuario Usuario) throws SQLException {  
        BD.Insert(Usuario);
    }  
    public void Actualizar(usuario Usuario)throws SQLException {  
        BD.Update(Usuario);
    }  
    public ArrayList<usuario> Listar() throws SQLException{ return BD.Listar();}

    
}
