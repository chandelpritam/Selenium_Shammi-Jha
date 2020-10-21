package IntializeDrivers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFUtility {

	public static PDDocument document;
    public static String Path ="user.dir"+"/Screenshots";   
	public static void addImagetoPDF(HashMap<Integer,String> mapper, int counter,String Scenario) throws IOException

	{
		document = new PDDocument();
		try
		{
			document.save(Path+"/"+Scenario+".pdf");
		}
		catch(Exception e){
			
		}

	File file = new File(Path+"/"+Scenario+".pdf");
	File pdf = new File(Path+"/"+Scenario+".pdf");
	if(pdf.exists())
	{
		pdf.delete();
		//System.out.println("Deleted the previous execution PDF");
	}

	PDDocumentInformation pdd = document.getDocumentInformation();
	pdd.setTitle("Execution document");

	try {
		for(int i =0;i<counter;i++)
		{
			PDPage balnkPage = new PDPage();
			document.addPage(balnkPage);
			PDImageXObject pdImage = PDImageXObject.createFromFile(Path + "\\" +i+".png" ,document);// adding the screenshot1.png in loop)
			PDPageContentStream contents = new PDPageContentStream(document, balnkPage);
			 if(i==1) {
				 contents.beginText();
				 contents.setFont(PDType1Font.TIMES_ROMAN, 10);
				 contents.newLineAtOffset(25, 500);
				 String text =Path;
				 contents.showText(text);
				 contents.endText();
				 contents.drawImage(pdImage, 0, 0, pdImage.getWidth()/3, pdImage.getHeight()/2);
				 
				 contents.beginText();  
	             contents.setFont(PDType1Font.TIMES_ROMAN, 10);
	             contents.newLineAtOffset(25, 500);
	             contents.showText(mapper.get(i));     
	             contents.endText();
	             contents.close(); 
			 }
		
		}
	}
		catch(Exception e) {
	  	  
	  	  e.printStackTrace();
	  	 
	    }
	    
	//Saving the document
	document.save(Path + "/" + Scenario + ".pdf");
	System.out.println("PDF created of this test method");  
	document.close();

	//Closing the document
		
		
	}

}
