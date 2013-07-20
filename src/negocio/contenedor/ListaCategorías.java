/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.contenedor;

import contenedor.Lista;
import datos.Categoría;
import java.io.Serializable;

/**
 *
 * @author M-01
 */
public class ListaCategorías extends Lista {
    
    /**
     * agregar recibe una pregunta sin su id
     * @param obj
     * @return 
     */
    @Override
    public boolean agregar(Object obj) {
        Categoría c = (Categoría)obj;
        c.setID( getCantidad()+1);
        return super.agregar(c);
    }

    /**
     * 
     * @param obj  es la llave de la pregunta
     * @return 
     */
    @Override
    public Object consultar(Object obj) {
        Integer id = (Integer)obj;
        
        Categoría c = new Categoría(id);
        
        return super.consultar(c);
    }

     @Override
    public boolean eliminar(Object obj){
        
        boolean res =  ( obj instanceof Categoría ? super.eliminar(obj) : false) ;
        return res;        

    }
    
    
    
    
}
