/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.ui;

import contenedor.Lista;
import negocio.contenedor.ListaPreguntas;
import datos.TipoDificultad;
import interfaz.FrGenExa;
import java.util.ArrayList;
import java.util.List;
import negocio.administrador.AdmGenExa;
import negocio.cargador.Cargador;

import interfaz.DiPreguntaVF;

/**
 *
 * @author M-01
 */
public class UIGenExa {
    private AdmGenExa adm;

    public UIGenExa(FrGenExa ventana) {
        adm = new AdmGenExa();
        Cargador.cargarPreguntas(ventana.getTbPreguntas(), adm.getListaP());
    }
    
    public Object consultarPregunta(int ID)
    {
        return adm.consultar( ID );
    }
    
     public void agregarPregunta(DiPreguntaVF ventana) {
         boolean res;
         
         String enunciado = ventana.getTxtEnunciado().getText().trim();
         TipoDificultad dificultad = (TipoDificultad)ventana.getCbDificultad().getSelectedItem();
         boolean activa = false;
         boolean respuesta = false;

         if(ventana.getCbRespuesta().getSelectedIndex() == 0){
            respuesta = true;
         }
         
         if(ventana.getChkActiva().isSelected() == true){
            activa = true;
         }
         
         res = adm.agregarPregunta(enunciado, dificultad, respuesta, activa); 
         
     }
     
    public void modificarPregunta(DiPreguntaVF ventana) {

         ventana.setVisible(true);
         boolean res;
         int ID = Integer.parseInt(ventana.getTxtID().getText());
         String enunciado = ventana.getTxtEnunciado().getText().trim();
         TipoDificultad dificultad = (TipoDificultad)ventana.getCbDificultad().getSelectedItem();
         boolean activa = false;
         boolean respuesta = false;

         if(ventana.getCbRespuesta().getSelectedIndex() == 0){
            respuesta = true;
         }
         
         if(ventana.getChkActiva().isSelected() == true){
            activa = true;
         }

         res = adm.modificarPregunta(ID, enunciado, dificultad, respuesta, activa); 
         
     }
    
    public void agregarPregunta(FrGenExa ventana) {
        
      /*  ventana.getLblMensaje().setText("");
        // extraer los campos de captura
        String enunciado = ventana.getTAEnunciado().getText().trim();
        int tipo = ventana.getCbTipoPregunta().getSelectedIndex();  //0-Desarrollo 1-SelUnica 2-F/V
        TipoDificultad dificultad = (TipoDificultad)ventana.getCbDificultad().getSelectedItem();
        
        if (! enunciado.isEmpty()){
            // procesa la accion y por lo tanto crear la pregunta
            boolean res= false;
            switch(tipo){
                case 0: // desarrollo
                    res= adm.agregarPregunta(enunciado, dificultad); 
                    break;
                case 1: // seleccion unica
                    // sujeto a cambio
                    Lista opciones = new Lista(); // mientras saca el valor de la ventana
                    int correcta =0;
                    //
                    res= adm.agregarPregunta(enunciado, dificultad, opciones, correcta); 
                     break;
                case 2: // falso / verdadero
                    //sujeto a cambio
                    boolean respuesta = true; // mientras saca el valor de la ventana
                    //
                    res= adm.agregarPregunta(enunciado, dificultad, respuesta); 
                    break;
            }
            // publicar el resultado..
            //ventana.getLblMensaje().setText(  res ? "Pregunta Agregada" : "Pregunta No Agregada" );
            Cargador.cargarPreguntas(ventana.getTbPreguntas(), adm.getListaP());            
        }
        else
            //reportar el error
           // ventana.getLblMensaje().setText("El enunciado no debe ser vacío");*/
    }

    public void modificarPregunta(FrGenExa aThis) {
        
    }

    public void desactivar(FrGenExa aThis) {
        
    }
    
    public ListaPreguntas getListaPreguntas(){
        return adm.getListaP();
    }
    
    
    
}
