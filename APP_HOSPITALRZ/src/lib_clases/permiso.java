/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_clases;

/**
 *
 * @author PROGRAMADOR
 */
public class permiso extends estandar{
    departamento iddepartamento;
    usuario idusuario;
    
    public void setIdDepartamento(departamento p)
    {
        iddepartamento =  p;
    }
    public void setIdUsuario(usuario u)
    {
        idusuario = u;
    }
    public departamento getIdDepartamento()
    {
        return iddepartamento;
    }
    public usuario IdUsuario()
    {
        return idusuario;
    }
}
