package Data_driven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{
	 //load particular excel file
	 XSSFWorkbook wb; 
	 XSSFSheet sheet;
	 
	 public ReadExcelFile(String excelPath)
	 {
	 try
	 {
	 File file=new File(excelPath);
	 FileInputStream fis= new FileInputStream(file);
	 wb=new XSSFWorkbook(fis);
	 }catch(Exception e)
	 {
	    System.out.println(e.getMessage());
	 }
	 }	
	 
	 public String getData(int sheetNumber,int row,int column)
	 {
	 sheet=wb.getSheetAt(sheetNumber);
	 String data=sheet.getRow(row).getCell(column).getStringCellValue();
	   return data;
	 }
	 public int getRowCount(int sheetIndex)
	 {
	 int row=wb.getSheetAt(sheetIndex).getLastRowNum();
	 row=row+1;
	 return row;
	 }
	 }
	


