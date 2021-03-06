/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_gestion;
import java.sql.SQLException;  
import java.util.ArrayList;  
import java.util.Date;
import lib_clases.*;
import lib_datos.*;
public class gestion {

    BaseDatos_principal BD = null;
    public gestion() {
         BD = new BaseDatos_principal();
    }
    
    public void Insertar(entidad Entidad, principal Principal, ArrayList<dprincipal> Dprincipal) throws SQLException {  
        BD.Insert(Entidad, Principal, Dprincipal);
    }  
    public void Actualizar(entidad Entidad, principal Principal, ArrayList<dprincipal> Dprincipal)throws SQLException {  
        BD.Update(Entidad, Principal, Dprincipal);
    }  
    public ArrayList<entidad> ListarEntidad(int idhorario,Date fecha,int depa) throws SQLException{ return BD.Listar_Entidades(idhorario,fecha,depa);}
    public principal Listar_principal(int identidad) throws SQLException{ return BD.Listar_principal(identidad);}
    public entidad listapersona(String iden) throws SQLException
    {
        return BD.ListaPersona(iden);
    }
    public ArrayList<dprincipal> Lista_dprincipal(principal p) throws SQLException{
    return BD.Listar_dprincipal(p);
    }
    
    public void listar_all(int iddepartamento, Date fecha) throws SQLException
    {
        ArrayList<principal> lprin = BD.Listar_principal_all(iddepartamento,fecha );
        for (principal pr : lprin) {
            pr.setIdhorario(1);
            pr.setFecha(fecha);
            Insertar(pr.getIdentidad(),pr, Lista_dprincipal(pr));
            pr.setIdhorario(2);
            Insertar(pr.getIdentidad(),pr, Lista_dprincipal(pr));
            pr.setIdhorario(3);
            Insertar(pr.getIdentidad(),pr, Lista_dprincipal(pr));
        }
    }
     public ArrayList<departamento> ListarDepartamentos_Entidad(int identidad) throws SQLException{
         return BD.Listar_departamento_entidad(identidad);
     }
 
}
