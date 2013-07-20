/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import contenedor.Lista;

/**
 *
 * @author M-01
 */
public class SeleccionUnica extends Pregunta{
    private String[] opciones;
    private int correcta;

    public SeleccionUnica(String enunciado, TipoDificultad dificultad, String[] opciones, int correcta, boolean activa ) {
        super(enunciado, dificultad, activa);
        this.opciones = opciones;
        this.correcta = correcta;
    }

    public SeleccionUnica(String enunciado, String[] opciones, int correcta, boolean activa ) {
        super(enunciado, activa);
        this.opciones = opciones;
        this.correcta = correcta;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public void setOpciones(String[] opciones, int correcta) {
        this.opciones = opciones;
        this.correcta = correcta;
    }

    public int getCorrecta() {
        return correcta;
    }

    public void setCorrecta(int correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return super.toString() + 
                " opciones=" + opciones + 
                ", correcta=" + correcta + "\n";
    }
    

    





}
