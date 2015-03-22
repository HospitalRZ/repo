/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib_clases;

import java.util.Date;

/**
 *
 * @author LUIS
 */
public class entidad extends estandar{
    String identificacion;
    String descripcion;
    tentidad idtentidad;
    Date fechanacimiento;

    public String getIdentificacion() {
        return identificacion;
    }
    public Date getFechanaci()
    {
        return fechanacimiento;
    }
    public void setFechaNaci( Date fecha)
    {
        this.fechanacimiento =  fecha;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public tentidad getIdtentidad() {
        return idtentidad;
    }

    public void setIdtentidad(tentidad idtentidad) {
        this.idtentidad = idtentidad;
    }
    
}
