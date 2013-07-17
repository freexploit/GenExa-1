/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cargador;

import datos.Pregunta;
import datos.SeleccionUnica;
import datos.TipoDificultad;
import datos.TipoPregunta;
import datos.Categoría;
import datos.TipoDificultad;

import datos.VerdaderoFalso;
import interfaz.DiPreguntaVF;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    
        /*public static void cargarExámenes(JTable table, ListaExamenes le){
        String encabezados[] ={ "Id", "Enunciado", "Dificultad", "Opciones", "Correcta", "F/V"};
        DefaultTableModel dtm = new DefaultTableModel(encabezados, le.getCantidad());
        for (int i=0; i< lp.getCantidad(); i++){
            Pregunta p = (Pregunta) lp.getLista().get(i);
            dtm.setValueAt(p.getClass().getName(), i, 0);
            dtm.setValueAt(p.getId(), i, 1);
            dtm.setValueAt(p.getEnunciado(), i, 2);
            dtm.setValueAt(p.getDificultad(), i, 3);
            if (p instanceof SeleccionUnica){
                dtm.setValueAt(  ((SeleccionUnica)p).getOpciones().getCantidad(), i, 4);
                dtm.setValueAt(  ((SeleccionUnica)p).getCorrecta(), i, 5);
            }
            if (p instanceof VerdaderoFalso){
                dtm.setValueAt(  ((VerdaderoFalso)p).isRespuesta(), i, 6);
            }
        }
        table.setModel(dtm);
    }  */

    public static void cargarTipoPregunta(JComboBox combo) {
        DefaultComboBoxModel dcb = new DefaultComboBoxModel(TipoPregunta.values());
        combo.setModel(dcb);
    }
    
    public static void cargarPreguntas(DiPreguntaVF ventana, Object pregunta ){
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

    public static void cargarCategoría(JComboBox cbCategoría) {
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
