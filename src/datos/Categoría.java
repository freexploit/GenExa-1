/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author LuisBrenes
 */
public class Categoría {
    
    private int id;
    private String nombre;

    public Categoría(int ID, String nombre) {
        this.id = ID;
        this.nombre = nombre;
    }
    
    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
