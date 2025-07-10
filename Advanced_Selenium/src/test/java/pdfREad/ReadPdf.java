package pdfREad;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdf {

	public static void main(String[] args) throws Throwable {
		File file = new File ("../Advanced_Selenium/pdf1.pdf");
		PDDocument doc = PDDocument.load(file);
		int totalPage=doc.getNumberOfPages();
		System.out.println(totalPage);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		String pdftext = pdfData.getText(doc);
		System.out.println(pdftext);
		
		pdfData.setStartPage(1);

	}

}
