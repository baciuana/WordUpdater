package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;

public class TestWord {
	
	private static XWPFDocument doc = null;
    private static File docFile = null;


	public static void main(String[] args) throws FileNotFoundException, IOException {
		String filename = "C:\\sample2_1.docx";
		docFile = new File(filename);
        FileInputStream fis = null;
        if (!docFile.exists()) {
            throw new FileNotFoundException("The Word dcoument " + filename + " does not exist.");
        }
        
        
        try {

            // Open the Word document file and instantiate the XWPFDocument
            // class.
            fis = new FileInputStream(docFile);
            doc = new XWPFDocument(fis);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                    fis = null;
                } catch (IOException ioEx) {
                    System.out.println("IOException caught trying to close " +
                            "FileInputStream in the constructor of " +
                            "UpdateEmbeddedDoc.");
                }
            }
        }
        
        List<XWPFParagraph> paragraphs = doc.getParagraphs();
      

        for (XWPFParagraph para : paragraphs) {
        	System.out.println(para.getStyle());
        	System.out.println(para.isWordWrap());
        	System.out.println(para.getRuns());
            System.out.println("para text" + para.getText());
            System.out.println("---------------------------------------------------------");
            
            List<XWPFRun> runs = para.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                	String text = r.getText(0);
                    if (text != null && text.contains("-")) {
                        text = text.replace("-", "A");
                        r.setText(text, 0);
                    }
                }
            }
        }
        
        doc.write(new FileOutputStream("C:\\output.docx"));
		


	}

}
