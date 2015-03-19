/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_hospitalrz;

import lib_presentacion.Permisos;
import lib_presentacion.frm_login;
import lib_presentacion.frm_proceso;

/**
 *
 * @author juliovicente
 */
public class APP_HOSPITALRZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //frm_login frm = new frm_login();
        //Permisos frm = new Permisos();
        frm_proceso frm = new frm_proceso(1);
        frm.show();
    }
    
}
