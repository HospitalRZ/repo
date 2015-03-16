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
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class NpgSqlConnection {
    
     private Connection con = null;  
          
        public Connection getConection() throws SQLException{  
            try{  
                Class.forName("org.postgresql.Driver");  
                con = DriverManager.getConnection("jdbc:postgresql://localhost/hrz?" + "user=postgres&password=12345");  
            }  
            catch (SQLException e){  
                throw new SQLException(e);  
            }  
            catch(ClassNotFoundException e){  
                throw new SQLException(e);  
            }  
            catch(Exception e){  
                throw new SQLException(e);  
            }  
            return this.con;  
        }  
}
