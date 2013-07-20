/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;

/**
 *
 * @author LuisBrenes
 */
public class Categoría implements Serializable{
    
    private int id;
    private String nombre;

    public Categoría(int ID, String nombre) {
        this.id = ID;
        this.nombre = nombre;
    }
    
    public Categoría(String nombre) {
        this.id = -1;
        this.nombre = nombre;
    }
    
    public Categoría(int ID) {
        this.id = ID;
    }
    
    public Categoría(int ID) {
        this.id = ID;
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
    
    @Override
    public String toString(){
        return (String.valueOf(this.getID()) +"-"+ this.getNombre() );
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Categoría) {
            final Categoría other = (Categoría) obj;
            if (this.id != other.id) {
                return false;
            }
            return true;
        }
        return false;
    }
}
