package Data_driven;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFExcel
{
	ChromeDriver driver;

	@Test(dataProvider = "testdata")
	public void DemoTest(String username, String password) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

		driver = new ChromeDriver();

		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
		Thread.sleep(5000);

//		Assert.assertEquals(driver.getTitle().matches(""), "Invalid credentials");
//		System.out.println("Login successfully");

	}

	@AfterMethod
	void ProgramTermination()
	{
		driver.quit();
	}

	
	//It helps you to write data-driven tests which essentially
	//means that same test method can be run multiple times with different data-sets.
	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed()
	{
		ReadExcelFile config = new ReadExcelFile("/home/userq/Desktop//FacebookLogin.xlsx");
		int rows = config.getRowCount(0);
		Object[][] credentials = new Object[rows][2];
		for (int i = 0; i < rows; i++) 
		{    
			//0th row 0th column
			credentials[i][0] = config.getData(0, i, 0);
			//0th row 1th column
			credentials[i][1] = config.getData(0, i, 1);
		}
		return credentials;

	}
}