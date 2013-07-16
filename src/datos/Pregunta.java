/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;

/**
 *
 * @author M-01
 */
public class Pregunta implements Serializable{
    protected int id;
    protected String enunciado;
    protected boolean activa;
    protected TipoDificultad dificultad;

    public Pregunta(String enunciado, TipoDificultad dificultad) {
        this.enunciado = enunciado;
        this.dificultad = dificultad;
        this.activa = true;
    }

    public Pregunta(String enunciado) {

        this.enunciado = enunciado;
        this.dificultad = TipoDificultad.Media;
        this.activa = true;
    }

    public Pregunta(int id) {
        this.id = id;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public TipoDificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(TipoDificultad dificultad) {
        this.dificultad = dificultad;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pregunta" + "id=" + id + 
                ", enunciado=" + enunciado + 
                ", activa=" + activa + 
                ", dificultad=" + dificultad ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Pregunta) {
            final Pregunta other = (Pregunta) obj;
            if (this.id != other.id) {
                return false;
            }
            return true;
        }
        return false;
    }

    
}
