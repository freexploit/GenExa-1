/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.administrador;

import contenedor.Lista;
import datos.Pregunta;
import datos.SeleccionUnica;
import datos.TipoDificultad;
import datos.VerdaderoFalso;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.contenedor.ListaPreguntas;

/**
 *
 * @author M-01
 */
public class AdmGenExa {

    private ListaPreguntas listaP;
    
    public AdmGenExa() {
        listaP = new ListaPreguntas();
        try {
            listaP.cargar("preguntas.dat");
        } 
        catch (FileNotFoundException ex) {} 
        catch (IOException ex) {} 
        catch (ClassNotFoundException ex) {}
    }

    public ListaPreguntas getListaP() {
        return listaP;
    }
    
    private boolean agregar(Pregunta p){
        if (listaP.agregar(p) ){
            try {
                listaP.grabar("preguntas.dat");
            } catch (FileNotFoundException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean agregarPregunta(String enunciado, TipoDificultad tipoDificultad) {
        Pregunta p =  new Pregunta(enunciado, tipoDificultad);
        return agregar(p);
    }

    public boolean agregarPregunta(String enunciado, TipoDificultad tipoDificultad, boolean respuesta) {
        Pregunta p =  new VerdaderoFalso(enunciado, tipoDificultad, respuesta);        
        return agregar(p);
    }
 
    public boolean agregarPregunta(String enunciado, TipoDificultad tipoDificultad, 
                                   Lista opciones, int correcta) {
        Pregunta p =  new SeleccionUnica(enunciado, tipoDificultad, opciones, correcta);
        return agregar(p);
    }
    
}