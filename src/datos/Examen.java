/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.awt.event.ItemEvent;
import java.util.Calendar;
import negocio.contenedor.ListaItemExamen;

/**
 *
 * @author M-01
 */
public class Examen {
    private int id;
    private Calendar fecha;
    private int totalPuntos;
    private double porcentaje;
    private TipoExamen tipoExamen;
    private ListaItemExamen cuerpoExamen;

    public Examen(int id, Calendar fecha, int totalPuntos, double porcentaje, TipoExamen tipoExamen) {
        this.id = id;
        this.fecha = fecha;
        this.totalPuntos = totalPuntos;
        this.porcentaje = porcentaje;
        this.tipoExamen = tipoExamen;
        cuerpoExamen = new ListaItemExamen();
    }

    public ListaItemExamen getCuerpoExamen() {
        return cuerpoExamen;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public TipoExamen getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(TipoExamen tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public int getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(int totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Examen other = (Examen) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Examen " + "id=" + id + ", fecha=" + fecha + 
                ", totalPuntos=" + totalPuntos + ", porcentaje=" + porcentaje + 
                ", tipoExamen=" + tipoExamen + "\n";
    }

    public boolean agregar(ItemExamen ie){
        if (cuerpoExamen.getTotalPuntos() + ie.getValoracion() <= totalPuntos)
            return cuerpoExamen.agregar(ie);
        return false;
    }
    
    
    public boolean modificar(ItemExamen ie){
        
        ItemExamen ieAnterior = (ItemExamen) cuerpoExamen.consultar(ie.getPregunta());
        if (cuerpoExamen.getTotalPuntos() - ieAnterior.getValoracion() + ie.getValoracion() <= totalPuntos)
            return cuerpoExamen.modificar(ie);
        return false;
    }
    
   
    
}
