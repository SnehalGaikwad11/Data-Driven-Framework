package Read;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookLoginTest 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		//Getting data from Excel sheet
		FileInputStream file=new FileInputStream("/home/userq/Desktop//Data2.xlsx");
		
		//Getting workbook instances for XLsx file
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//Get first sheet from the  workbook
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//Get first row from the sheet
		int noOfRows=sheet.getLastRowNum();	
		System.out.println("No of Records in Excel Sheet:"+noOfRows);
		
		for(int  row=1;row<=noOfRows;row++)
		{
			XSSFRow current_row=sheet.getRow(row);
			
//			String Phone=current_row.getCell(0).getStringCellValue();
//			String Password=current_row.getCell(1).getStringCellValue();
//			
//			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Phone);
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Password);
//			Thread.sleep(1000);
//			
//			driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
//			Thread.sleep(3000);
//			Thread.sleep(1000);
//			driver.close();
//			
	

			
			String First_name=current_row.getCell(0).getStringCellValue();	
			String Surname=current_row.getCell(1).getStringCellValue();		
            String Mobile_number=current_row.getCell(2).getStringCellValue();		
            String New_password=current_row.getCell(3).getStringCellValue();
		    //String  Birthday=current_row.getCell(4).getStringCellValue();		
			String Gender=current_row.getCell(4).getStringCellValue();		
			
			//Entering contact Info
			driver.findElement(By.name("firstname")).sendKeys(First_name);
			driver.findElement(By.name("lastname")).sendKeys(Surname);
			driver.findElement(By.name("reg_email__")).sendKeys(Mobile_number);
			driver.findElement(By.name("reg_passwd__")).sendKeys(New_password);
			
			
			
			 //static drop down
		    Select s = new Select(driver.findElement(By.id("day")));
		    Thread.sleep(1000);
		    s.selectByVisibleText("11");

		    Select s1 = new Select(driver.findElement(By.id("month")));
		    Thread.sleep(1000);
		    s1.selectByValue("11");

		    Select s2 = new Select(driver.findElement(By.id("year")));
		    Thread.sleep(1000);
		    s2.selectByValue("1996");
		    
		    //radio button
		        driver.findElement(By.xpath("//input[@id='u_0_5']")).click();//for selecting female

			
			
			//Click on Sign up button

			driver.findElement(By.id("u_0_15")).click();
			Thread.sleep(1000);
			System.out.println("User Successfully Sign up");

			driver.close();


			
		}
		}

	}

			

			
			
			

			
	
