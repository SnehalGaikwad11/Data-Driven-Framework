package Read;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {
	public static void main(String[] args) throws IOException   {
		
		FileInputStream file=new FileInputStream("/home/userq/Desktop//data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//XSSFSheet sheet=workbook.getSheet("Sheet1");//providing sheet name
		
		XSSFSheet sheet=workbook.getSheetAt(0);//providing index name
	    
		int rowcount= sheet.getLastRowNum(); //return the rowcount
		
		int colcount=sheet.getRow(0).getLastCellNum(); //return all column/cell count
	
		for(int i=0;i<rowcount;i++)
		{
			 
		XSSFRow currentrow=sheet.getRow(i);  //foccussed on current row
		//all the cell value one by one
		
		
		for(int j=0;j<colcount;j++)
		{
			 String value=currentrow.getCell(j).toString(); //read the value from cell
			 System.out.print("   "  +value);
		}
		
		System.out.println();
		}
		
		
		
	}
	
	
	

}
