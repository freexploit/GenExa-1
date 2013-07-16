/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.contenedor;

import contenedor.Lista;
import datos.Pregunta;
import java.io.Serializable;

/**
 *
 * @author M-01
 */
public class ListaPreguntas extends Lista {

    /**
     * agregar recibe una pregunta sin su id
     * @param obj
     * @return 
     */
    @Override
    public boolean agregar(Object obj) {
        Pregunta p = (Pregunta)obj;
        p.setId( getCantidad()+1);
        return super.agregar(p);
    }

    /**
     * 
     * @param obj  es la llave de la pregunta
     * @return 
     */
    @Override
    public Object consultar(Object obj) {
        Integer id = (Integer)obj;
        
        Pregunta p = new Pregunta(id);
        
        return super.consultar(p);
    }

     @Override
    public boolean eliminar(Object obj) {
        return false;
    }
    
    
    
    
    
}
