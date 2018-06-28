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
public class Voto {
    
    private int id;
    private int persona_fk;
    private int candidato_fk;

    public Voto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersona_fk() {
        return persona_fk;
    }

    public void setPersona_fk(int persona_fk) {
        this.persona_fk = persona_fk;
    }

    public int getCandidato_fk() {
        return candidato_fk;
    }

    public void setCandidato_fk(int candidato_fk) {
        this.candidato_fk = candidato_fk;
    }
    
    
    
}
