package dataprocess;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ProcessFiles {
	
	public ProcessFiles(File xlsFile, File docSample){
		XlsInterpreter xlsInterpreter = new XlsInterpreter(xlsFile);
		for (Integer nr : xlsInterpreter.getVehicule().keySet()){
			//System.out.println(docSample.getParent() + "\\" + nr + ".docx");
//			File customerFile = new File(docSample.getParent() + "\\" + nr + ".docx");
//			
//			try {
//				Files.copy(docSample.toPath(), customerFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			DocWriter docWriter = new DocWriter(xlsInterpreter.getSerie(), xlsInterpreter.getVehicule().get(nr), docSample);
		}
	}

}
