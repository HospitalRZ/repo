/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_clases;

/**
 *
 * @author LUIS
 */
public class departamento extends estandar{
    String descripcion;
    entidad identidad;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public entidad getIdentidad() {
        return identidad;
    }

    public void setIdentidad(entidad identidad) {
        this.identidad = identidad;
    }
}
