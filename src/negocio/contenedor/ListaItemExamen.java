/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.contenedor;

import contenedor.Lista;
import datos.ItemExamen;
import datos.Pregunta;

/**
 *
 * @author M-01
 */
public class ListaItemExamen extends Lista{
    private int totalPuntos;

  
    public ListaItemExamen() {
        super();
        totalPuntos = 0;
    }

    public int getTotalPuntos() {
        return totalPuntos;
    }

    /**
     * agrega un nuevo item de examen si y solo si no se encuentra repetido.
     * Si lo agrega incrementa el total de puntos registrados.
     * @param obj: ItemExamen
     * @return  true/false
     */
    @Override
    public boolean agregar(Object obj) {
        boolean res =  ( obj instanceof ItemExamen ? super.agregar(obj) : false) ;
        totalPuntos += (res ? ((ItemExamen)obj).getValoracion() : 0);
        return res;
    }
     
    /**
     * recibe una pregunta y devuelve en caso de hallarlo un item de Examen
     * @param obj :Pregunta
     * @return  el objeto ItemExamen o null si no lo encuentra
     */
    @Override
    public Object consultar(Object obj) {
        Pregunta id = (Pregunta)obj;
        
        ItemExamen ie = new ItemExamen(id);
        
        return super.consultar(ie);
    }
    
    /**
     * supone que recibe un item de examen debidamente modificado, donde lo 
     * unico que permite cambio es la valoracion
     * @param obj: ItemExamen
     * @return  true/false si la modificacion tuvo efecto
     */
    @Override
    public boolean modificar(Object obj){
        
        ItemExamen ie = (ItemExamen) consultar(obj);
        if (ie != null){
            totalPuntos = totalPuntos - ie.getValoracion()+ ((ItemExamen)obj).getValoracion();
            return  super.modificar(obj) ;
        }
        return false;
    }
    
      /**
     * supone que recibe un item de examen que se quiere eliminar
     * @param obj: ItemExamen
     * @return  true/false si la modificacion tuvo efecto
     */  
    @Override
    public boolean eliminar(Object obj){
        
        boolean res =  ( obj instanceof ItemExamen ? super.eliminar(obj) : false) ;
        totalPuntos -= (res ? ((ItemExamen)obj).getValoracion() : 0);
        return res;        

    }
    
    
    
}
