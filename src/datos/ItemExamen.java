/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author M-01
 */
public class ItemExamen {
    private Pregunta pregunta;
    private int valoracion;

    public ItemExamen(Pregunta pregunta, int valoracion) {
        this.pregunta = pregunta;
        this.valoracion = valoracion;
    }

    // constructor auxiliar para las busquedas por identificacion
    public ItemExamen(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    
    

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "ItemExamen: " + "pregunta=" + pregunta + ", valoracion=" + valoracion + '\n';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemExamen other = (ItemExamen) obj;
        if (this.pregunta!= other.pregunta && 
           (this.pregunta == null || !this.pregunta.equals(other.pregunta))) {
            return false;
        }
        return true;
    }

    
    
    
    
}
