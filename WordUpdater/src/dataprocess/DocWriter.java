package dataprocess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import datamodel.Vehicul;

public class DocWriter {
	
	private String serie;
	private Vehicul vehicul;
	private XWPFDocument doc = null;
	
	
	public DocWriter(String serie, Vehicul vehicul, File sampleDoc){
		this.serie = serie;
		this.vehicul = vehicul;
		
		FileInputStream fis = null;
	    	        
	        
        try {
            fis = new FileInputStream(sampleDoc);
            doc = new XWPFDocument(fis);
        } catch(FileNotFoundException ex){
        	ex.printStackTrace();
        } catch(IOException ex2) {
        	ex2.printStackTrace();
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
        	
        	
            System.out.println("para text" + para.getText());
            System.out.println("---------------------------------------------------------");
            
            List<XWPFRun> runs = para.getRuns();
            if (runs.size() > 0){
	            String firstText = runs.get(0).getText(0);
	            if (firstText != null){
		            if (firstText.trim().equals("Seria")){
		            	//change Seria row
		            	for (int i = 1; i < runs.size(); i++){
		            		String text = runs.get(i).getText(0);
		            		if (text.trim().equals("---")){
		            			runs.get(i).setText(text.replace("---", serie), 0);
		            		}else if (text.trim().equals("----")){
		            			//text = vehicul.getNrAterstat() + "";
		            			runs.get(i).setText(text.replace("----", vehicul.getNrAterstat() + ""), 0);
		            		}else if (text.trim().equals("--.--")){
		            			//text = vehicul.getDataAtestat() + "";
		            			runs.get(i).setText(text.replace("--.--", vehicul.getDataAtestat()), 0);
		            		}
		            	}
		            }
	            }
            }
//            for (XWPFRun r : runs) {
//            	String text = r.getText(0);
//                if (text != null && text.contains("-")) {
//                    text = text.replace("-", "A");
//                    r.setText(text, 0);
//                }
//            }
           
        }
        
        try {
			doc.write(new FileOutputStream(sampleDoc.getParent() + "\\" + vehicul.getNrAterstat() + ".docx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
