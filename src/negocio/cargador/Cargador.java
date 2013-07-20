/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cargador;

import datos.Categoría;
import datos.Pregunta;
import datos.SeleccionUnica;
import datos.TipoDificultad;
import datos.TipoPregunta;
import datos.VerdaderoFalso;
import interfaz.DiPreguntaDesarrollo;
import interfaz.DiPreguntaSU;
import interfaz.DiPreguntaVF;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.contenedor.ListaCategorías;
import negocio.contenedor.ListaPreguntas;
//import negocio.contenedor.ListaExamen;

/**
 *
 * @author M-01
 */
public class Cargador {

    public static void cargarDificultad(JComboBox combo){
        DefaultComboBoxModel dcb = new DefaultComboBoxModel(TipoDificultad.values());
        combo.setModel(dcb);
    }
 
    
    public static void cargarPreguntas(JTable table, ListaPreguntas lp){
        String encabezados[] ={"Activa", "Tipo", "Id", "Enunciado", "Dificultad"};
        DefaultTableModel dtm = new DefaultTableModel(encabezados, lp.getCantidad());
        for (int i=0; i< lp.getCantidad(); i++){
            Pregunta p = (Pregunta) lp.getLista().get(i);
            if(p.isActiva()){
                dtm.setValueAt("✔", i, 0);
            }else{
                dtm.setValueAt("X", i, 0);
            }
            dtm.setValueAt(p.getClass().getName(), i, 1);
            dtm.setValueAt(p.getId(), i, 2);
            dtm.setValueAt(p.getEnunciado(), i, 3);
            dtm.setValueAt(p.getDificultad(), i, 4);
        }
        table.setModel(dtm);
    }    

    public static void cargarTipoPregunta(JComboBox combo) {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel(TipoPregunta.values());
        combo.setModel(dcb);
    }
    
    
    //CARGA LOS DATOS DE UNA PREGUNTA SELECCIONADA EN UNA VENTANA PARA EDITAR. SOLO PARA VERDADERO o FALSO
    public static void cargarPreguntaVF(DiPreguntaVF ventana, Object pregunta ){
        VerdaderoFalso p = (VerdaderoFalso)pregunta;
        ventana.setTxtID( String.valueOf(p.getId()) );
        ventana.setTxtEnunciado(p.getEnunciado());
        ventana.setChkActiva(p.isActiva());
        
        if(p.isRespuesta()){
            ventana.setCbRespuesta(0);
        }else{
            ventana.setCbRespuesta(1);
        }
        
        if(p.getDificultad() == TipoDificultad.Alta){
            ventana.setCbDificultad(2);
        }else{
            if(p.getDificultad() == TipoDificultad.Media){
                ventana.setCbDificultad(1);
            }else{
                ventana.setCbDificultad(0);
            }
        }

    }
    
    //CARGA LOS DATOS DE UNA PREGUNTA SELECCIONADA EN UNA VENTANA PARA EDITAR. SOLO SELECCION UNICA
    public static void cargarPreguntaDesarrollo(DiPreguntaDesarrollo ventana, Object pregunta ){
        Pregunta p = (Pregunta)pregunta;
        ventana.setTxtID( String.valueOf(p.getId()) );
        ventana.setTxtEnunciado(p.getEnunciado());
        ventana.setChkActiva(p.isActiva());
        
        if(p.getDificultad() == TipoDificultad.Alta){
            ventana.setCbDificultad(2);
        }else{
            if(p.getDificultad() == TipoDificultad.Media){
                ventana.setCbDificultad(1);
            }else{
                ventana.setCbDificultad(0);
            }
        }

    }

    //CARGA LOS DATOS DE UNA PREGUNTA SELECCIONADA EN UNA VENTANA PARA EDITAR. SOLO SELECCION UNICA
    public static void cargarPreguntaSU(DiPreguntaSU ventana, Object pregunta ){
        SeleccionUnica p = (SeleccionUnica)pregunta;
        ventana.setTxtID( String.valueOf(p.getId()) );
        ventana.setTxtEnunciado(p.getEnunciado());
        ventana.setChkActiva(p.isActiva());
        ventana.getCbRespuesta().setSelectedIndex(p.getCorrecta());
        String[] respuestas = new String[4];
        respuestas = p.getOpciones();
        
        ventana.getTxtOpcion1().setText(respuestas[0]);
        ventana.getTxtOpcion2().setText(respuestas[1]);
        ventana.getTxtOpcion3().setText(respuestas[2]);
        ventana.getTxtOpcion4().setText(respuestas[3]);
        
        if(p.getDificultad() == TipoDificultad.Alta){
            ventana.setCbDificultad(2);
        }else{
            if(p.getDificultad() == TipoDificultad.Media){
                ventana.setCbDificultad(1);
            }else{
                ventana.setCbDificultad(0);
            }
        }

    }
    
    public static void cargarCbCategoría(JComboBox cbCategoría) {
       /* DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        for (int i=0; i< lc.getCantidad(); i++){
            Categoría c = (Categoría) lc.getLista().get(i);
            dcb.addElement(c.getNombre());
        }
        cbCategoría.setModel(dcb);*/
    }
    
    public static void cargarCbMCategoría(JComboBox cbCategoría, ListaCategorías lc) {
       DefaultComboBoxModel dcb = new DefaultComboBoxModel();
        for (int i=0; i< lc.getCantidad(); i++){
            Categoría c = (Categoría) lc.getLista().get(i);
            dcb.addElement(c.getNombre());
        }
        cbCategoría.setModel(dcb);
    }
    
    public static void cargarTbCategorías(JTable table, ListaCategorías lc){
        String encabezados[] ={"Identificador (ID)", "Descripción"};
        DefaultTableModel dtm = new DefaultTableModel(encabezados, lc.getCantidad());
        for (int i=0; i< lc.getCantidad(); i++){
            Categoría c = (Categoría) lc.getLista().get(i);
            dtm.setValueAt(String.valueOf(c.getID()), i, 0);
            dtm.setValueAt(c.getNombre(), i, 1);
        }
        table.setModel(dtm);
    }    
}
