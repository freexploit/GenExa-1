/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.ui;

import datos.Categoría;
import datos.TipoDificultad;
import interfaz.DiPreguntaDesarrollo;
import interfaz.DiPreguntaSU;
import interfaz.DiPreguntaVF;
import interfaz.FrGenExa;
import java.io.File;
import negocio.administrador.AdmGenExa;
import negocio.cargador.Cargador;
import negocio.contenedor.ListaCategorías;
import negocio.contenedor.ListaPreguntas;

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
        return adm.consultarPregunta( ID );
    }
    
    public int consultarTipoPregunta(int ID)
    {
        return adm.consultarTipoPregunta(ID);
    }
    
    //AGREGAR NUEVA PREGUNTA VERDADERO O FALSO
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
     
    //AGREGAR NUEVA PREGUNTA DESARROLLO
    public void agregarPregunta(DiPreguntaDesarrollo ventana) {
         boolean res;
         
         String enunciado = ventana.getTxtEnunciado().getText().trim();
         TipoDificultad dificultad = (TipoDificultad)ventana.getCbDificultad().getSelectedItem();
         boolean activa = false;

         if(ventana.getChkActiva().isSelected() == true){
            activa = true;
         }

         res = adm.agregarPregunta(enunciado, dificultad, activa); 
     }
     
    //AGREGAR NUEVA PREGUNTA VERDADERO O FALSO
    public void agregarPregunta(DiPreguntaSU ventana) {
        boolean res;


        String enunciado = ventana.getTxtEnunciado().getText().trim();
        TipoDificultad dificultad = (TipoDificultad)ventana.getCbDificultad().getSelectedItem();
        boolean activa = false;

        String Opcion1 = ventana.getTxtOpcion1().getText().trim();
        String Opcion2 = ventana.getTxtOpcion2().getText().trim();
        String Opcion3 = ventana.getTxtOpcion3().getText().trim();
        String Opcion4 = ventana.getTxtOpcion4().getText().trim();

        String[] opciones = {Opcion1, Opcion2, Opcion3, Opcion4};
        int respuesta = ventana.getCbRespuesta().getSelectedIndex();

        if(ventana.getChkActiva().isSelected() == true){
           activa = true;
        }

        res = adm.agregarPregunta(enunciado, dificultad, opciones, respuesta, activa); 

    }
     
    //REÚNE LA INFORMACIÓN PARA MODIFICAR NUEVA PREGUNTA VERDADERO O FALSO
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

       res = adm.modificarPreguntaVF(ID, enunciado, dificultad, respuesta, activa); 

    }
    
    //REÚNE LA INFORMACIÓN PARA MODIFICAR NUEVA PREGUNTA DESARROLLO
    public void modificarPregunta(DiPreguntaDesarrollo ventana) {

       ventana.setVisible(true);
       boolean res;
       int ID = Integer.parseInt(ventana.getTxtID().getText());
       String enunciado = ventana.getTxtEnunciado().getText().trim();
       TipoDificultad dificultad = (TipoDificultad)ventana.getCbDificultad().getSelectedItem();
       boolean activa = false;

       if(ventana.getChkActiva().isSelected() == true){
           activa = true;
       }

       res = adm.modificarPreguntaDesarrollo(ID, enunciado, dificultad, activa); 

    }
        
    //REÚNE LA INFORMACIÓN PARA MODIFICAR NUEVA PREGUNTA SELECCION UNICA
    public void modificarPregunta(DiPreguntaSU ventana) {

        ventana.setVisible(true);
        boolean res;
        int ID = Integer.parseInt(ventana.getTxtID().getText());
        String enunciado = ventana.getTxtEnunciado().getText().trim();
        int respuesta = ventana.getCbRespuesta().getSelectedIndex();
        String[] opciones = new String[4];

        opciones[0] = ventana.getTxtOpcion1().toString().trim();
        opciones[1] = ventana.getTxtOpcion2().toString().trim();
        opciones[2] = ventana.getTxtOpcion3().toString().trim();
        opciones[3] = ventana.getTxtOpcion4().toString().trim();

        TipoDificultad dificultad = (TipoDificultad)ventana.getCbDificultad().getSelectedItem();
        boolean activa = false;

        if(ventana.getChkActiva().isSelected() == true){
            activa = true;
        }

        res = adm.modificarPreguntaSU(ID, enunciado, dificultad, opciones, respuesta, activa); 

    }
    
    public ListaPreguntas getListaPreguntas(){
        return adm.getListaP();
    }

    
    public void agregarCategoría(FrGenExa aThis) {
        adm.agregarCategoría(aThis.getTxtNuevaCategoría().getText().trim());
    }

    public void modificarCategoría(FrGenExa aThis) {
        adm.modificarCategoría(Integer.parseInt(aThis.getTxtIDCategoría().getText().trim()), aThis.getTxtModificarCategoría().getText().trim());
    }

    public void consultarCategoría(FrGenExa aThis) {
        Categoría c = (Categoría) adm.consultarCategoría( Integer.parseInt(aThis.getTxtIDCategoría().getText().trim()) );
        if(c != null){
            aThis.getTxtIDCategoría().setText(String.valueOf(c.getID()));
            aThis.getTxtModificarCategoría().setText(c.getNombre());
        }
    }

    public ListaCategorías getListaCategorías() {
        return adm.getListaC();
    }
   

    public void crearPDF(File pdf) {
        
        adm.guardarPDF(pdf);
    }
    
    
}
