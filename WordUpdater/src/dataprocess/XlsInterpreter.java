package dataprocess;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import datamodel.Vehicul;

public class XlsInterpreter {
	
	private String serie;
	private Map<Integer, Vehicul> vehicule = new HashMap<>();
	
	
	public XlsInterpreter(File xlsFile) {
		
		//to do: progress bar
//		SwingUtils.setProgressBarText("Importing repair times data ...");
//		panel.addToLog("Importing repair times data");
//		SwingUtils.setProgressBarIndeterminate();
		
		try{
			InputStream myxls = new FileInputStream(xlsFile);
			Workbook wb =  WorkbookFactory.create(myxls);
			Sheet sheet = wb.getSheetAt(0);
			
			getData(sheet);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} catch (InvalidFormatException e){
			e.printStackTrace();
		}
		
		
	}
	
	private void getData(Sheet sheet){
		
		Row sheetRow = sheet.getRow(0);
		serie = sheetRow.getCell(0).getRichStringCellValue().toString();
		
		int rowIndex = 1;
		while(rowIndex <= sheet.getLastRowNum()) {
			sheetRow = sheet.getRow(rowIndex++);
			
			int nrAtestat = 0;
			if (sheetRow.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
				nrAtestat = Integer.parseInt(sheetRow.getCell(0).getRichStringCellValue().toString());
			}else{
				nrAtestat = (int)sheetRow.getCell(0).getNumericCellValue();
			}
			//nrAtestat = (int)sheetRow.getCell(0).getNumericCellValue();
			Vehicul vehicul = new Vehicul(nrAtestat);
			vehicul.setDataAtestat(sheetRow.getCell(1).getRichStringCellValue().toString());
			vehicul.setMarca(sheetRow.getCell(2).getRichStringCellValue().toString());
			vehicul.setModel(sheetRow.getCell(3).getRichStringCellValue().toString());
			if (sheetRow.getCell(4).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
				vehicul.setAn(sheetRow.getCell(4).getNumericCellValue() + "");
			}else{
				vehicul.setAn(sheetRow.getCell(4).getRichStringCellValue().toString());
			}
			
			if (sheetRow.getCell(5).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
				vehicul.setSerieSasiu(sheetRow.getCell(5).getNumericCellValue() + "");
			}else{
				vehicul.setSerieSasiu(sheetRow.getCell(5).getRichStringCellValue().toString());
			}
			
			if (sheetRow.getCell(6).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
				vehicul.setSerieMotor(sheetRow.getCell(6).getNumericCellValue() + "");
			}else{
				vehicul.setSerieMotor(sheetRow.getCell(6).getRichStringCellValue().toString());
			}
			
			vehicul.setCuloare(sheetRow.getCell(7).getRichStringCellValue().toString());
			vehicul.setProprietar(sheetRow.getCell(8).getRichStringCellValue().toString());
			vehicul.setNrInm(sheetRow.getCell(9).getRichStringCellValue().toString());
			
			vehicule.put(nrAtestat, vehicul);
			
		}
	}
	
	public String getSerie(){
		return serie;
	}
	
	public Map<Integer, Vehicul> getVehicule(){
		return vehicule;
	}

}
