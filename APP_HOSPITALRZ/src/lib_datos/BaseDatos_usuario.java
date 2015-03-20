/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_datos;
import lib_clases.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDatos_usuario {
    public void Insert(usuario Usuario) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            if (Usuario.getId() == 0) {
                stmt = con.prepareCall("{call hrz.usuario_insert (?,?,?)}");
                stmt.setString(1, Usuario.getLogin());
                stmt.setString(2, Usuario.getPassword());
                stmt.setInt(3, Usuario.getIdestado());
                rs = stmt.executeQuery();
            }
            
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }

    }
     public void Update(usuario Usuario) throws SQLException {
        Connection con = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.usuario_update (?,?,?,?)}");
            stmt.setInt(1, Usuario.getId());
            stmt.setString(2, Usuario.getLogin());
            stmt.setString(3, Usuario.getPassword());
            stmt.setInt(4, Usuario.getIdestado());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }
    }
     public ArrayList<usuario> Listar() throws SQLException
     {
            Connection con = null;
            CallableStatement stmt = null;
            ArrayList<usuario> Lista = null;
            ResultSet rs = null;
        try {    
            Lista = new ArrayList<usuario>();
            con = new NpgSqlConnection().getConection();
            stmt = con.prepareCall("{call hrz.usuario_lista()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario Usuario = new usuario();
                Usuario.setId(rs.getInt("id"));
                Usuario.setLogin(rs.getString("descripcion"));
                Usuario.setPassword(rs.getString("passwd"));
                Usuario.setIdestado(rs.getInt("idestado"));
                Lista.add(Usuario);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        } finally {
            NpgSqlUtilities.closeConnection(con, stmt, rs);
        }

        return Lista;
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
                objeto.setDescripcion("departamento");
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
