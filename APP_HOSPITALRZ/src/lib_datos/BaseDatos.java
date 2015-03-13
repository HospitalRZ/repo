/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_datos;

import java.sql.CallableStatement;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList; 
import java.sql.DriverManager; 
import java.sql.Statement;
import java.util.List;
/**
 *
 * @author Jeibe-PC
 */
public class BaseDatos {
    private Connection conexion;
    private boolean transaccionIniciada;
    private ResultSet resultado=null;
    private CallableStatement sentencia=null;
    static String driver="org.postgresql.Driver";
    static String bd="bdMulticomercioJb";
    static String user="postgres";
    static String password="myfb10JEIBE";
    static String server="jdbc:postgresql://localhost:5432/"+bd;
    public BaseDatos() {
        
    }
    
    public Connection getConexion() {
        return conexion;
    }
    public void Conectar() {
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(server,user,password);        
        }
        catch(Exception e){
            System.out.println("Imposible realizar conexion con la BD");
            e.printStackTrace();
        }
    }   
    public void Desconectar() {
         try
        {
            conexion.close();
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos 111 ");
        }
    }
    
    public void previo(String strSql, Object[] parametros)
        {
           
        }

     public void previo(String strSql)
        {
            
        }
    
      public Object ejecutarEscalar(String sentencia) throws SQLException
        {
          Statement st;
            ResultSet rs = null;

            if (this.conexion != null) {
              st = this.conexion.createStatement();
              rs = st.executeQuery(sentencia);
            }
            return rs;
        }
      
    public Object ejecutarEscalar(String wProcedimiento, Object[] wParametros) throws Exception {
        CallableStatement cs;
    Object valor = null;
    int parSalida =-1;
    int i=1;
    try {
      cs = this.getConexion().prepareCall(wProcedimiento);
      if (wParametros != null) {
        for (Object par : wParametros) {
//      if (par.isEntrada() == true) {
            cs.setObject(i, par);
//            cs.setObject(par.getNombre(), par.getValor());
//          } else {
//            parSalida = i;
//            cs.registerOutParameter(i, par.getTipo());
//          }
          i += 1;
        }
      }
      cs.executeUpdate();
      if (parSalida > 0) {
        valor = cs.getObject(parSalida);
        //valor = cs.getObject("xxx");
      }
    } catch (Exception e) {
      throw e;
    } finally {
      cs = null;
    }
    return valor;
    }
    
     public void ejecutar(String strSql) throws SQLException
        {
            Statement st;

    if (this.conexion != null) {
      st = this.conexion.createStatement();
      st.executeUpdate(strSql);
    }
        }
    
    public void ejecutar(String sentencia, Object[] parametros) throws SQLException {
        Statement st;
        if (this.conexion != null) {
          st = this.conexion.createStatement();
          st.executeUpdate(sentencia);
        }
    }
    
    public void ComenzarTransaccion()
    {
        if (this.transaccion == null || this.transaccion.Connection == null)
        {
            this.transaccion = this.conexion.BeginTransaction();
        }
    }

    public void CancelarTransaccion()
    {
        if (this.transaccion != null)
        {
            this.transaccion.Rollback();
        }
    }
    
    public void ConfirmarTransaccion()
    {
        if (this.transaccion != null)
        {
            this.transaccion.Commit();
        }
    }x

    public void Cancelar() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

     public void cerrar() {
         try
        {
            conexion.close();
        }catch(Exception e)
        {
            System.out.println("Problema para cerrar la Conexión a la base de datos 111 ");
        }
     }
   
}