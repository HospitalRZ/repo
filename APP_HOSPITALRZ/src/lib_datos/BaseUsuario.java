/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author
 */
public class BaseUsuario {

    public ArrayList<usuario> listar() throws SQLException {
        Connection con = null;
        ArrayList<usuario> lusu = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.usuario_lista ()}");
            lusu = new ArrayList<usuario>();
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario user = new usuario();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("descripcion"));
                user.setPassword(rs.getString("passwd"));
                user.setIdestado(rs.getInt("idestado"));
                lusu.add(user);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }
        return lusu;
    }

    public ArrayList<departamento> listaDepartamento() throws SQLException {
        Connection con = null;
        ArrayList<departamento> lusu = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.departamento_lista ()}");
            lusu = new ArrayList<departamento>();
            rs = stmt.executeQuery();
            while (rs.next()) {
                departamento user = new departamento();
                user.setId(rs.getInt("id"));
                user.setDescripcion(rs.getString("descripcion"));
                user.setIdentidad(new entidad());
                user.setIdestado(rs.getInt("idestado"));
                lusu.add(user);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }
        return lusu;
    }

    public int logear(usuario user) throws SQLException {
        Connection con = null;
        int size = 0;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.usuario_select (?,?)}");
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                size = (rs.getInt("id"));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }
        return size;
    }
    
    public void InsertarPermiso(ArrayList<permiso> per ) throws SQLException
    {
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            for (permiso p : per) {
                stmt = con.prepareCall("{call hrz.permiso_insert (?,?,?)}");
            stmt.setInt(1, p.IdUsuario().getId());
            stmt.setInt(2, p.getIdDepartamento().getId());
            stmt.setInt(3, p.getIdestado());
            stmt.executeQuery();          
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }
        
    }

}
