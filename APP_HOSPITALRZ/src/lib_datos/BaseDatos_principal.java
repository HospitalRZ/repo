/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_datos;

import lib_clases.*;
import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.Date;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;  
/**
 *
 * @author Jeibe-PC
 */
public class BaseDatos_principal {
 public void Insert(entidad Entidad, principal Principal, dprincipal Dprincipal) throws SQLException 
 {
        Connection con = null;  
        CallableStatement stmt = null;  
        ResultSet rs = null; 
    try 
    {
        con = new NpgSqlConnection().getConection(); 
        stmt = con.prepareCall("{call hrz.entidad_insert (?,?,?,?)}");  
        stmt.setString(1,Entidad.getIdentificacion());  
        stmt.setString(2,Entidad.getDescripcion());  
        stmt.setInt(3,Entidad.getIdtentidad().getId());  
        stmt.setInt(4,Entidad.getIdestado());  
        rs = stmt.executeQuery();  
            if (rs.next())  
            {  
                Entidad.setId(rs.getInt(1));  
            }
        stmt = con.prepareCall("{call hrz.principal_insert (?,?,?,?,?,?,?)}");  
        stmt.setDate(1, (Date) Principal.getFecha());  
        stmt.setInt(2,Principal.getIddertamento().getId());  
        stmt.setInt(3,Principal.getIdhorario());  
        stmt.setString(4,Principal.getNum_cama());
        stmt.setInt(5, Entidad.getId());
        stmt.setString(6, Principal.getObservacion());
        stmt.setInt(7, Principal.getIdestado());
        rs = stmt.executeQuery();  
            if (rs.next())  
            {  
                Principal.setId(rs.getInt(1));  
            }
        stmt = con.prepareCall("{call hrz.dprincipal_insert (?,?,?,?)}"); 
        stmt.setInt(1, Principal.getId());
        stmt.setInt(2, Dprincipal.getIddieta().getId());
        stmt.setInt(3, Dprincipal.getIdestado());
        stmt.setBoolean(4, Dprincipal.getActivado());
        rs = stmt.executeQuery();  
            if (rs.next())  
            {  
                Dprincipal.setId(rs.getInt(1));  
            }
    }
    catch (SQLException ex) {  
           throw new SQLException(ex);  
        }  
        finally {                      
            NpgSqlUtilities.closeConnection(con,stmt,rs);  
        }  
          
    
 }  
 
 public void Update(entidad Entidad,principal Principal, dprincipal Dprincipal) throws SQLException 
 {
        Connection con = null;  
        CallableStatement stmt = null;  
        ResultSet rs = null;   
        try 
        {
            con = new NpgSqlConnection().getConection();  
            stmt = con.prepareCall("{call hrz.principal_update (?,?,?,?,?,?,?,?)}");  
            stmt.setInt(1,Principal.getId());  
            stmt.setDate(2, (Date) Principal.getFecha());  
            stmt.setInt(3,Principal.getIddertamento().getId());  
            stmt.setInt(4,Principal.getIdhorario());  
            stmt.setString(5,Principal.getNum_cama());  
            stmt.setInt(6,Principal.getIdentidad().getId());  
            stmt.setString(7,Principal.getObservacion());  
            stmt.setInt(8,Principal.getIdestado());  
            stmt.executeUpdate();  
            stmt = con.prepareCall("{call hrz.dprincipal_update (?,?,?,?,?)}"); 
            stmt.setInt(1,Dprincipal.getId());  
            stmt.setInt(2, Dprincipal.getIdprincipal().getId());  
            stmt.setInt(3,Dprincipal.getIddieta().getId());  
            stmt.setBoolean(4,Dprincipal.getActivado());  
            stmt.setInt(5,Dprincipal.getIdestado());  
            stmt.executeUpdate(); 
            
        }
        catch (SQLException ex) {  
           throw new SQLException(ex);  
        }  
        finally {                      
            NpgSqlUtilities.closeConnection(con,stmt,rs);  
        }
 }
 public ArrayList<entidad> Listar_Entidades() throws SQLException
 {
        Connection con = null;  
        CallableStatement stmt = null;  
        ArrayList<entidad> Entidades = null;  
        ResultSet rs = null; 
        try {  
            con = new NpgSqlConnection().getConection();  
            stmt = con.prepareCall("{call hrz.entidad_select_all()}");  
            Entidades = new ArrayList<>();  
            rs = stmt.executeQuery();    
            while (rs.next()) {  
                entidad Entidad = new entidad();  
                Entidad.setId(rs.getInt("id"));
                Entidad.setDescripcion(rs.getString("descripcion"));
                Entidad.setIdentificacion(rs.getString("identificacion"));
                tentidad Tentidad = new tentidad();
                Tentidad.setId(rs.getInt("idtentidad"));
                Entidad.setIdtentidad(Tentidad);
                Entidad.setIdestado(rs.getInt("estado"));
                Entidades.add(Entidad);  
            }  
        }  
        catch(SQLException ex) {  
            throw new SQLException(ex);  
        }  
        finally {  
            NpgSqlUtilities.closeConnection(con,stmt,rs);  
        }  
          
        return Entidades; 
 }
 
 public ArrayList<dprincipal> Listar_principal(int identidad) throws SQLException
 {
     Connection con = null;  
        CallableStatement stmt = null;  
        ArrayList<dprincipal> Dprincipales = null;  
        ResultSet rs = null; 
        try {  
            con = new NpgSqlConnection().getConection();  
            stmt = con.prepareCall("{call hrz.principal_select(?)}");
            stmt.setInt(1, identidad);
            Dprincipales = new ArrayList<>();  
            rs = stmt.executeQuery();    
            while (rs.next()) {  
               principal Principal = new principal();
               Principal.setId(rs.getInt("id"));
               Principal.setFecha((Date) rs.getDate("fecha"));
               departamento Departamento = new departamento();
               Departamento.setId(rs.getInt("iddepartmento"));
               Principal.setIddertamento(Departamento);
               Principal.setIdhorario(rs.getInt("idhorario"));
               Principal.setNum_cama(rs.getString("ncama"));
               entidad Entidad = new entidad();
               Entidad.setId(rs.getInt("identidad"));
               Principal.setIdentidad(Entidad);
               Principal.setObservacion(rs.getString("observacion"));
               Principal.setIdestado(rs.getInt("idestado"));
               stmt = con.prepareCall("{call hrz.dprincipal_select(?)}");
               stmt.setInt(1, Principal.getId());
               rs = stmt.executeQuery(); 
               while (rs.next()) 
               {
                   dprincipal Dprincipal = new dprincipal();
                   Dprincipal.setId(rs.getInt("id"));
                   Dprincipal.setIdprincipal(Principal);
                   dieta Dieta = new dieta();
                   Dieta.setId(rs.getInt("iddieta"));
                   Dprincipal.setIddieta(Dieta);
                   Dprincipal.setActivado(rs.getBoolean("activado"));
                   Dprincipales.add(Dprincipal);
                   
               }
            }  
        }  
        catch(SQLException ex) {  
            throw new SQLException(ex);  
        }  
        finally {  
            NpgSqlUtilities.closeConnection(con,stmt,rs);  
        }  
          
        return Dprincipales; 
 
 } 
}