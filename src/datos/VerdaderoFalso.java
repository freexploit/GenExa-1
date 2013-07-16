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
                          boolean respuesta) {
        super(enunciado, dificultad);
        this.respuesta = respuesta;
    }

    public VerdaderoFalso(String enunciado, 
                          boolean respuesta ) {
        super(enunciado);
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
