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
public class principal extends estandar{
    Date fecha;
    departamento iddertamento;
    int idhorario;
    String num_cama;
    entidad identidad;
    String observacion;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public departamento getIddertamento() {
        return iddertamento;
    }

    public void setIddertamento(departamento iddertamento) {
        this.iddertamento = iddertamento;
    }

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public String getNum_cama() {
        return num_cama;
    }

    public void setNum_cama(String num_cama) {
        this.num_cama = num_cama;
    }

    public entidad getIdentidad() {
        return identidad;
    }

    public void setIdentidad(entidad identidad) {
        this.identidad = identidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
