/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import datos.Pregunta;
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
public class GenExa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          /*Probando elfuncionamiento del metodo equals en un objeto*/
/*
        Pregunta p1 = new Pregunta(12, "uno");
        
        VerdaderoFalso p2 = new VerdaderoFalso(1, "uno", true);
        
        if (p1.equals(p2))
            System.out.println("son iguales");
        else
            System.out.println("son distintos");
*/        
        
          /* prueba de funcionamiento de la lista de preguntas*/        
/*      
        ListaPreguntas lp = new ListaPreguntas();
        lp.agregar(p1);
        lp.agregar(p2);
        System.out.println(" la lista de preguntas tiene \n"+lp.toString());
*/        

        /* probando la grabacion de la lista de preguntas..*/
/*        try {
            lp.grabar("preguntas.dat");
            System.out.println("todo ok");
            
        } catch (FileNotFoundException ex) {
            System.out.println("no encontro el archivo");
        } catch (IOException ex) {
            System.out.println("problemas con el archivo" + ex.getMessage());
        }
*/        
        /* probando la carga de la lista de preguntas..*/
        ListaPreguntas lp = new ListaPreguntas();
        try {
            lp= (ListaPreguntas) lp.cargar("preguntas.dat");
            System.out.println("la lista que cargo tiene \n"+lp.toString() );
        } catch (FileNotFoundException ex) {
            System.out.println("no encuentra el archivo de carga");
        } catch (IOException ex) {
            System.out.println("problemas leyendo el archivo");
        } catch (ClassNotFoundException ex) {
            System.out.println("error en el casting: no hay una lista de preguntas en el archivo");
        }
    }
}
