/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author M-01
 */
public class VerdaderoFalso extends Pregunta{
    
    private boolean respuesta;
    
    public VerdaderoFalso(String enunciado, 
                          TipoDificultad dificultad, 
                          boolean respuesta, boolean activa) {
        super(enunciado, dificultad, activa);
        this.respuesta = respuesta;
    }

    public VerdaderoFalso(String enunciado, 
                          boolean respuesta, boolean activa ) {
        super(enunciado, activa);
        this.respuesta = respuesta;
    }
  
    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return super.toString() +
               " respuesta=" + respuesta + '\n';
    }
    
    
    
}
