package com.shashi.itext.write;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfStamperExample {
	
	


  public static void main(String[] args) {
    try {
      PdfReader pdfReader = new PdfReader("template/xyz.pdf");      // i am using a Template to buid a Sample report

      PdfStamper pdfStamper = new PdfStamper(pdfReader,
            new FileOutputStream("output/Generated_report_1.pdf"));

   

      for(int i=1; i<= pdfReader.getNumberOfPages(); i++){

          PdfContentByte content = pdfStamper.getUnderContent((i));
          
      
     
          if(i==1)
          {
        	  new PdfStamperExample().addContent(content);
          }
          
         
          
          else
          {
        	  new PdfStamperExample().addDeclaration(content);
          }
          content.showTextAligned(PdfContentByte.ALIGN_LEFT,"Page No: " + i,430,15,0);
        
         
      }
      
      

      pdfStamper.close();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
  public void addContent(PdfContentByte content)   //Sets all the Things Dynamic (Probably from Database)
  {
	  BaseFont bf;
	try {
		  // Image image = Image.getInstance("C:/Users/dell/Desktop/logo.png");
		 //  image.setAbsolutePosition(100f, 700f);                                    //Add the Raxa Logo that will be static
		bf = BaseFont.createFont(BaseFont.HELVETICA,
		          BaseFont.WINANSI, BaseFont.EMBEDDED);
		content.beginText();
	      content.setFontAndSize(bf, 12);
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"----Instruction goes Here----",50,670,0);
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"----Instruction goes Here----",50,630,0);
	      content.setFontAndSize(bf, 15);
	     
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"Shashikant Vaishnav",220,483,0);

	      content.setFontAndSize(bf, 12);
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"22 SEP 1991",220,463,0);
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"INDIAN",420,463,0);
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"AJ153245689",180,443,0);
	      content.endText();
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      

    //  content.addImage(image);
  }
  public void addDeclaration(PdfContentByte content)     // Add the Second page  decelaration
  {
	  BaseFont bf;
	  
	  try {
		bf = BaseFont.createFont(BaseFont.HELVETICA,
		          BaseFont.WINANSI, BaseFont.EMBEDDED);
		content.beginText();
	      content.setFontAndSize(bf, 12);
	     // content.stroke();
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"Rajat vaishnav",110,770,0);
	      content.showTextAligned(PdfContentByte.ALIGN_LEFT,"15 APRIL 2013",420,680,0);
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
  }
