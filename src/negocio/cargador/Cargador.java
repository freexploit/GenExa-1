/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cargador;

import datos.Pregunta;
import datos.SeleccionUnica;
import datos.TipoDificultad;
import datos.VerdaderoFalso;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.contenedor.ListaPreguntas;

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
        String encabezados[] ={"Tipo", "Id", "Enunciado", "Dificultad", "Opciones", "Correcta", "F/V"};
        DefaultTableModel dtm = new DefaultTableModel(encabezados, lp.getCantidad());
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
    }    
    
}
