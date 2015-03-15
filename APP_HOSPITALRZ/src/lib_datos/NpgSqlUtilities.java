/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_datos;

/**
 *
 * @author juliovicente
 */
import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class NpgSqlUtilities {
    public static void closeConnection(Connection conn, CallableStatement stmt, ResultSet rs) throws SQLException {  
        close(conn, stmt, rs);  
    }  
  
    public static void closeConnection(Connection conn, CallableStatement stmt) throws SQLException {  
        close(conn, stmt, null);  
    }  
  
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) throws SQLException {  
        close(conn, stmt, rs);  
    }  
  
    public static void closeConnection(Connection conn, PreparedStatement stmt) throws SQLException {  
        close(conn, stmt, null);  
    }  
      
    public static void closeConnection(Connection conn) throws SQLException {  
        close(conn, null, null);  
    }  
          
    private static void close(Connection conn, CallableStatement stmt, ResultSet rs) throws SQLException {  
        try {  
            if (rs != null) {  
                rs.close();  
            }  
            if (stmt != null) {  
                stmt.close();  
            }  
            if (conn != null) {  
                conn.close();  
            }  
        }   
        catch (Exception e) {  
            throw new SQLException(e);  
        }  
        finally{  
            rs = null;  
            stmt = null;  
            conn = null;  
        }  
  
    }   
      
    private static void close(Connection conn, PreparedStatement  stmt, ResultSet rs) throws SQLException {  
        try {  
            if (rs != null) {  
                rs.close();  
            }  
            if (stmt != null) {  
                stmt.close();  
            }  
            if (conn != null) {  
                conn.close();  
            }  
        }   
        catch (Exception e) {  
            throw new SQLException(e);  
        }  
        finally{  
            rs = null;  
            stmt = null;  
            conn = null;  
        }  
    }
}
