/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Veroko
 */
public class Partido {

    private int partido_fk;
    private String nombre_partido;
    
    public Partido() {
    }

    public int getPartido_fk() {
        return partido_fk;
    }

    public void setPartido_fk(int partido_fk) {
        this.partido_fk = partido_fk;
    }

    public String getNombre_partido() {
        return nombre_partido;
    }

    public void setNombre_partido(String nombre_partido) {
        this.nombre_partido = nombre_partido;
    }

    
    
}
