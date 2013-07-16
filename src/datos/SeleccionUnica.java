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
    private Lista opciones;
    private int correcta;

    public SeleccionUnica(String enunciado, 
                          TipoDificultad dificultad,
                          Lista opciones, int correcta ) {
        super(enunciado, dificultad);
        this.opciones = opciones;
        this.correcta = correcta;
    }

    public SeleccionUnica(String enunciado,
                          Lista opciones, int correcta ) {
        super(enunciado);
        this.opciones = opciones;
        this.correcta = correcta;
    }

    public Lista getOpciones() {
        return opciones;
    }

    public void setOpciones(Lista opciones) {
        this.opciones = opciones;
    }

    public void setOpciones(Lista opciones, int correcta) {
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
