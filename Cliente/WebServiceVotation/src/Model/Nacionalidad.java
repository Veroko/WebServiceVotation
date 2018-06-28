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
public class Nacionalidad {
    
    private int id;
    private String nom_nacionalidad;
    
    public Nacionalidad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_nacionalidad() {
        return nom_nacionalidad;
    }

    public void setNom_nacionalidad(String nom_nacionalidad) {
        this.nom_nacionalidad = nom_nacionalidad;
    }
    
}
