/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.administrador;

import contenedor.Lista;
import datos.Categoría;
import datos.Pregunta;
import datos.SeleccionUnica;
import datos.TipoDificultad;
import datos.VerdaderoFalso;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.cargador.Cargador;
import negocio.cargador.PdfCreator;
import negocio.contenedor.ListaCategorías;
import negocio.contenedor.ListaPreguntas;
import org.apache.pdfbox.exceptions.COSVisitorException;

/**
 *
 * @author M-01
 */
public class AdmGenExa {

    private ListaPreguntas listaP;
    private ListaCategorías listaC;
    
    public AdmGenExa() {
        listaP = new ListaPreguntas();
        
        
        listaC = new ListaCategorías();
       
    }
    
    //Regresa la lista de Preguntas
    public ListaPreguntas getListaP() {
        return listaP;
    }
    //Recibe un objeto tipo Pregunta y lo agrega a listaP
    private boolean agregar(Pregunta p){
        if (listaP.agregar(p) ){
            try {
                listaP.grabar("preguntas.dat");
            } catch (FileNotFoundException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    //Recibe un objeto tipo Pregunta y reemplaza su equivalente en ID en listaP
    private boolean modificar(Pregunta p){
        if (listaP.modificar(p) ){
            try {
                listaP.grabar("preguntas.dat");
            } catch (FileNotFoundException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    //Recibe un objeto tipo Categoría y lo agrega a listaC
    private boolean agregar(Categoría c){
        if (listaC.agregar(c) ){
            try {
                listaC.grabar("categorías.dat");
            } catch (FileNotFoundException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    //Recibe un objeto tipo Categoría y reemplaza su equivalente en ID en listaC
    private boolean modificar(Categoría c){
        if (listaC.modificar(c) ){
            try {
                listaC.grabar("categorías.dat");
            } catch (FileNotFoundException ex) {
                return false;
            } catch (IOException ex) {
                return false;
            }
            return true;
        }
        return false;
    }

    //Recibe los parámetros necesarios para agregar una pregunta tipo Pregunta (Desarrollo)
    //Luego llama al metodo para agregar la Pregunta creada con esos parámetros.
    public boolean agregarPregunta(String enunciado, TipoDificultad tipoDificultad, boolean activa) {
        Pregunta p =  new Pregunta(enunciado, tipoDificultad, activa);
        return agregar(p);
    }

    //Recibe los parámetros necesarios para agregar una pregunta tipo VerdaderoFalso
    //Luego llama al metodo para agregar la Pregunta creada con esos parámetros.
    public boolean agregarPregunta(String enunciado, TipoDificultad tipoDificultad, boolean respuesta, boolean activa) {
        Pregunta p =  new VerdaderoFalso(enunciado, tipoDificultad, respuesta, activa);        
        return agregar(p);
    }
 
    //Recibe los parámetros necesarios para agregar una pregunta tipo SeleccionUnica
    //Luego llama al metodo para agregar la Pregunta creada con esos parámetros.
    public boolean agregarPregunta(String enunciado, TipoDificultad tipoDificultad, String[] opciones, int correcta, boolean activa) {
        Pregunta p =  new SeleccionUnica(enunciado, tipoDificultad, opciones, correcta, activa);
        return agregar(p);
    }
    
    //Regresa un objeto tipo Pregunta si corresponde el ID con el de algún Objeto Pregunta en la lista
    public Object consultarPregunta(int ID){
        return listaP.consultar(ID);
    }

    
    //Cosulta el tipo de pregunta: 0 para Pregunta, 1 para VerdaderoFalso, 2 para SeleccionUnica, -1 sino existe.
    public int consultarTipoPregunta(int ID){
    
        Object consulta = consultarPregunta( ID );
        
        if(consulta == null){
            return -1;}
        
        if ( consulta instanceof VerdaderoFalso){
            return 1;}
        
        if ( consulta instanceof SeleccionUnica){
            return 2;}
      
        return 0;
    }
    //BUSCA LA PREGUNTA EXISTENTE Y LE AÑADE LA INFO NUEVA. SIRVE PARA VERDADERO O FALSO ÚNICAMENTE
    public boolean modificarPreguntaVF(int ID, String enunciado, TipoDificultad tipoDificultad, boolean respuesta, boolean activa) {
        
       VerdaderoFalso p = (VerdaderoFalso)listaP.consultar(ID);
       p.setId(ID);
       p.setEnunciado(enunciado);
       p.setDificultad(tipoDificultad);
       p.setRespuesta(respuesta);
       p.setActiva(activa);
       return modificar(p);
    }
    //BUSCA LA PREGUNTA EXISTENTE Y LE AÑADE LA INFO NUEVA. SIRVE PARA DESARROLLO ÚNICAMENTE
    public boolean modificarPreguntaDesarrollo(int ID, String enunciado, TipoDificultad tipoDificultad, boolean activa) {
        
        Pregunta p = (Pregunta)listaP.consultar(ID);
        p.setId(ID);
        p.setEnunciado(enunciado);
        p.setDificultad(tipoDificultad);
        p.setActiva(activa);
        return modificar(p);
    }
    
    //BUSCA LA PREGUNTA EXISTENTE Y LE AÑADE LA INFO NUEVA. SIRVE PARA SELECCIÓN ÚNICA ÚNICAMENTE
    public boolean modificarPreguntaSU(int ID, String enunciado, TipoDificultad tipoDificultad,String[] opciones, int respuesta, boolean activa) {
        
       SeleccionUnica p = (SeleccionUnica)listaP.consultar(ID);
       p.setId(ID);
       p.setEnunciado(enunciado);
       p.setDificultad(tipoDificultad);
       p.setCorrecta(respuesta);
       p.setActiva(activa);
       return modificar(p);
    }
    //Recibe los parámetros necesarios para agregar una Categoría
    //Luego llama al metodo para agregar la Categoría creada con esos parámetros.
    public boolean agregarCategoría(String nombre) {
        Categoría c = new Categoría(nombre);
        return agregar(c);
    }

    //BUSCA LA PREGUNTA EXISTENTE Y LE AÑADE LA INFO NUEVA. SIRVE PARA DESARROLLO ÚNICAMENTE
    public boolean modificarCategoría(int ID, String nombre) {
        
        Categoría c = (Categoría)listaC.consultar(ID);
        if(c!=null){
            c.setNombre(nombre);
        }
        return modificar(c);
    }

    //Regresa un objeto tipo Categoría si corresponde el ID con el de algún Objeto Pregunta en la lista
    public Object consultarCategoría(int ID){
        return listaC.consultar(ID);
    }
    
    //Regresa la lista de Categorías
    public ListaCategorías getListaC() {
        return listaC;
    }
    public void guardarPDF(File file)  {
        try {
            PdfCreator p = new PdfCreator();
            p.createPdf(file,listaP);
        } catch (IOException ex) {
            Logger.getLogger(AdmGenExa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (COSVisitorException ex) {
            Logger.getLogger(AdmGenExa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public int cargarArchivo(File file){
        try {
            Lista l=new Lista();
            l=l.cargar(file.getAbsolutePath());
            if(l instanceof ListaPreguntas){
                listaP=(ListaPreguntas) l;
                return 1;
            } 
            if(l instanceof ListaCategorías){
                listaC=(ListaCategorías) l;
                return -1;
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdmGenExa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdmGenExa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdmGenExa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
        
        
    
    }

}
