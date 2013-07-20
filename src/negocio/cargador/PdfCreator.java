/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cargador;

import contenedor.Lista;
import datos.Examen;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;

/**
 *
 * @author christopher
 */
public class PdfCreator {
    
   private PDDocument pdf;
   private    Lista list;
   private PDXObjectImage image = null;
   private PDPage page;

   public PdfCreator() throws IOException{
      
      pdf = new PDDocument();
      page = new PDPage();
      pdf.addPage(page);
   }

    public void createPdf(File file,Lista e) throws IOException, COSVisitorException {
        
        image = new PDJpeg(pdf, new FileInputStream("genexa.jpg"));
        PDPageContentStream content = new PDPageContentStream(pdf, page);
        PDFont font = PDType1Font.HELVETICA_BOLD;
        content.beginText();
        content.setFont(font, 12);
        content.moveTextPositionByAmount(100, 700);
        content.drawString(e.toString());
        content.endText();
        content.drawImage(image, 20, 20);
        content.close();
        String name = file.getName();
        if (name.matches("[a-z0-9]+.pdf")){
            pdf.save(file);    
        }else{
            name=name+".pdf";
            file.renameTo(new File(name));
            pdf.save(file);
        }
        
        
    }

    
}
