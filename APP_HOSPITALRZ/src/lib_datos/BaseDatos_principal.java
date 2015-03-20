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

    public void Insert(entidad Entidad, principal Principal, ArrayList<dprincipal> Dprincipales) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            if (Entidad.getId() == 0) {
                stmt = con.prepareCall("{call hrz.entidad_insert (?,?,?,?)}");
                stmt.setString(1, Entidad.getIdentificacion());
                stmt.setString(2, Entidad.getDescripcion());
                stmt.setInt(3, Entidad.getIdtentidad().getId());
                stmt.setInt(4, Entidad.getIdestado());
                rs = stmt.executeQuery();
                if (rs.next()) {
                    Entidad.setId(rs.getInt(1));
                }
            }
            stmt = con.prepareCall("{call hrz.principal_insert (?,?,?,?,?,?,?)}");
            stmt.setDate(1, new java.sql.Date((Principal.getFecha().getTime())));
            stmt.setInt(2, Principal.getIddertamento().getId());
            stmt.setInt(3, Principal.getIdhorario());
            stmt.setString(4, Principal.getNum_cama());
            stmt.setInt(5, Entidad.getId());
            stmt.setString(6, Principal.getObservacion());
            stmt.setInt(7, Principal.getIdestado());
            rs = stmt.executeQuery();
            if (rs.next()) {
                Principal.setId(rs.getInt(1));
            }

            for (dprincipal Dprincipal : Dprincipales) {
                stmt = con.prepareCall("{call hrz.dprincipal_insert (?,?,?,?)}");
                stmt.setInt(1, Principal.getId());
                stmt.setInt(2, Dprincipal.getIddieta().getId());
                stmt.setBoolean(3, Dprincipal.getActivado());
                stmt.setInt(4, Dprincipal.getIdestado());
                rs = stmt.executeQuery();
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }

    }

    public void Update(entidad Entidad, principal Principal, ArrayList<dprincipal> Dprincipal) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.principal_update (?,?,?,?,?,?,?,?)}");
            stmt.setInt(1, Principal.getId());
            stmt.setDate(2, new java.sql.Date((Principal.getFecha().getTime())));
            stmt.setInt(3, Principal.getIddertamento().getId());
            stmt.setInt(4, Principal.getIdhorario());
            stmt.setString(5, Principal.getNum_cama());
            stmt.setInt(6, Principal.getIdentidad().getId());
            stmt.setString(7, Principal.getObservacion());
            stmt.setInt(8, Principal.getIdestado());
            stmt.executeQuery();
            for (dprincipal pr : Dprincipal) {
                stmt = con.prepareCall("{call hrz.dprincipal_update (?,?,?,?,?)}");
                stmt.setInt(1, pr.getId());
                stmt.setInt(2, Principal.getId());
                stmt.setInt(3, pr.getIddieta().getId());
                stmt.setBoolean(4, pr.getActivado());
                stmt.setInt(5, Principal.getIdestado());
                stmt.executeQuery();
            }
            

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }
    }

    public ArrayList<entidad> Listar_Entidades(int idhorario, java.util.Date fecha) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        ArrayList<entidad> Entidades = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.entidad_select(?,?)}");
            stmt.setInt(1, idhorario);
            stmt.setDate(2, new java.sql.Date(fecha.getTime()));
            Entidades = new ArrayList<>();
            rs = stmt.executeQuery();
            while (rs.next()) {
                entidad Entidad = new entidad();
                Entidad.setId(rs.getInt("id"));
                Entidad.setDescripcion(rs.getString("descripcion"));
                Entidad.setIdentificacion(rs.getString("identificacion"));
                Entidades.add(Entidad);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }

        return Entidades;
    }

    public principal Listar_principal(int identidad) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        principal Principal = null;
        //CallableStatement stmt1 = null;  
        //ArrayList<dprincipal> Dprincipales = null;
        ResultSet rs = null;
        //ResultSet rs1 = null; 
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.principal_select(?)}");
            stmt.setInt(1, identidad);
            //Dprincipales = new ArrayList<>();
            rs = stmt.executeQuery();
            while (rs.next()) {
                Principal = new principal();
                Principal.setId(rs.getInt("id"));
                Principal.setFecha((Date) rs.getDate("fecha"));
                departamento Departamento = new departamento();
                Departamento.setId(rs.getInt("iddepartamento"));
                Principal.setIddertamento(Departamento);
                Principal.setIdhorario(rs.getInt("idhorario"));
                Principal.setNum_cama(rs.getString("ncama"));
                entidad Entidad = new entidad();
                Entidad.setId(rs.getInt("identidad"));
                Entidad.setDescripcion(rs.getString("descripcion"));
                Entidad.setIdentificacion(rs.getString("identificacion"));
                Principal.setIdentidad(Entidad);
                Principal.setObservacion(rs.getString("observacion"));
                Principal.setIdestado(rs.getInt("idestado"));

//               
//               
//               stmt1 = con.prepareCall("{call hrz.dprincipal_select(?)}");
//               stmt1.setInt(1, Principal.getId());
//               rs1 = stmt1.executeQuery(); 
//               while (rs1.next()) 
//               {
//                   dprincipal Dprincipal = new dprincipal();
//                   Dprincipal.setId(rs1.getInt("id"));
//                   Dprincipal.setIdprincipal(Principal);
//                   dieta Dieta = new dieta();
//                   Dieta.setId(rs1.getInt("iddieta"));
//                   Dprincipal.setIddieta(Dieta);
//                   Dprincipal.setActivado(rs1.getBoolean("activado"));
//                   Dprincipales.add(Dprincipal);
//                   
//               }
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }

        return Principal;

    }

    
    public void Listar_principal_all(int iddepartamento,java.util.Date fecha) throws SQLException
    {
        Connection con = null;
            CallableStatement stmt1 = null;
            ArrayList<dprincipal> Dprincipales = null;
            ArrayList<principal> lprincipal = null;
            ResultSet rs1 = null;
        try {    
            Dprincipales = new ArrayList<dprincipal>();
            lprincipal = new ArrayList<principal>();
            con = new NpgSqlConnection().getConection();
            stmt1 = con.prepareCall("{call hrz.principal_tselect_all(?,?)}");
            stmt1.setInt(1,1);
            
            stmt1.setDate(2, new java.sql.Date(fecha.getTime()));
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                dprincipal Dprincipal = new dprincipal();
                Dprincipal.setId(rs1.getInt("id"));
                //Dprincipal.setIdprincipal(idprincipal);
                dieta Dieta = new dieta();
                Dieta.setId(rs1.getInt("iddieta"));
                Dprincipal.setIddieta(Dieta);
                Dprincipal.setActivado(rs1.getBoolean("activado"));
                Dprincipales.add(Dprincipal);

            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt1, rs1);
        }

        
    }
    public ArrayList<dprincipal> Listar_dprincipal(principal idprincipal) throws SQLException {
        Connection con = null;
            CallableStatement stmt1 = null;
            ArrayList<dprincipal> Dprincipales = null;
            ResultSet rs1 = null;
        try {    
            Dprincipales = new ArrayList<dprincipal>();
            con = new NpgSqlConnection().getConection();
            stmt1 = con.prepareCall("{call hrz.dprincipal_select(?)}");
            stmt1.setInt(1, idprincipal.getId());
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                dprincipal Dprincipal = new dprincipal();
                Dprincipal.setId(rs1.getInt("id"));
                Dprincipal.setIdprincipal(idprincipal);
                dieta Dieta = new dieta();
                Dieta.setId(rs1.getInt("iddieta"));
                Dprincipal.setIddieta(Dieta);
                Dprincipal.setActivado(rs1.getBoolean("activado"));
                Dprincipales.add(Dprincipal);

            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt1, rs1);
        }

        return Dprincipales;

    }

    public entidad ListaPersona(String identi) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        entidad Entidad = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.entidad_selecti(?)}");
            stmt.setString(1, identi);
            Entidad = new entidad();
            rs = stmt.executeQuery();
            while (rs.next()) {
                Entidad.setId(rs.getInt("id"));
                Entidad.setDescripcion(rs.getString("descripcion"));
                Entidad.setIdentificacion(rs.getString("identificacion"));
                tentidad Tentidad = new tentidad();
                Tentidad.setId(rs.getInt("idtentidad"));
                Entidad.setIdtentidad(Tentidad);
                Entidad.setIdestado(rs.getInt("idestado"));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }
        return Entidad;
    }
    
    public ArrayList<departamento> Listar_departamento() throws SQLException {
        Connection con = null;
            CallableStatement stmt1 = null;
            ArrayList<departamento> ListaDepartamento = null;
            ResultSet rs1 = null;
        try {    
            ListaDepartamento = new ArrayList<departamento>();
            con = new NpgSqlConnection().getConection();
            stmt1 = con.prepareCall("{call hrz.departamento_select(?)}");
            stmt1.setInt(1, 0);
            rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                departamento departamento = new departamento();
                departamento.setId(rs1.getInt("id"));
                departamento.setDescripcion(rs1.getString("descripcion"));
                ListaDepartamento.add(departamento);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt1, rs1);
        }

        return ListaDepartamento;

    }
    public ArrayList<departamento> Listar_departamento_entidad(int identidad) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        ArrayList<departamento> Departamento = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.departamento_entidad_select(?)}");
            stmt.setInt(1, identidad);
            Departamento = new ArrayList<>();
            rs = stmt.executeQuery();
            while (rs.next()) {
                departamento objeto = new departamento();
                objeto.setId(rs.getInt("id"));
                objeto.setDescripcion(rs.getString("descripcion"));
                Departamento.add(objeto);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }

        return Departamento;
    }
}
