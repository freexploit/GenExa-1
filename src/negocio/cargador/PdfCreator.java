/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cargador;

import contenedor.Lista;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author christopher
 */
public class PdfCreator {
    
   private PDDocument pdf;
   private    Lista list;

   PdfCreator(){
      
      pdf = new PDDocument();
      PDPage page = new PDPage();
      pdf.addPage(pag);
   }

    public boolean createPdf(Lista lista) {
        this.list = lista;

    }

    
}
