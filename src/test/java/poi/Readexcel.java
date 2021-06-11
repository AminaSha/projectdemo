package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {
	private static final String POIWRITE_XLSX = "C:\\AMINA\\New folder\\DETAILS_DATA.xlsx";
	
	public String readExcelFun(int row,int cell,String sheetname) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(POIWRITE_XLSX));
		  
	    // Create Workbook instance holding reference to .xlsx file
	    XSSFWorkbook workbook = new XSSFWorkbook(file);

	    // Get first/desired sheet from the workbook
	    XSSFSheet sheet = workbook.getSheet(sheetname);
	    
	    Row obj1=sheet.getRow(row);
	    org.apache.poi.ss.usermodel.Cell objcell=obj1.getCell(cell);
	     
	    String returnValue="";
	    
	        
	        // Check the cell type and format accordingly
	        switch (objcell.getCellType()) {
	        case NUMERIC:
	           // System.out.print(objcell.getNumericCellValue() + "\t");
	            returnValue= Double.toString(objcell.getNumericCellValue());
	           
	            
	        case STRING:
	            //System.out.print(objcell.getStringCellValue() + "\t");
	            returnValue=objcell.getStringCellValue();
	           
	        }
	        return  returnValue;
	    

	}

	}


