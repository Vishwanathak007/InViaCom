package com.via.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class TestGoibibo {
	
	static WebDriver driver;
	static String fromCity;
	static String toCity;	
	
	@FindBy(xpath=".//div[@class='formWrap padT15']/div[1]/input")
	static WebElement txtFromCity;
	
	@FindBy(xpath=".//div[@class='formWrap padT15']/div[2]/input")
	static WebElement txtToCity;
	
	@FindBy(xpath=".//input[contains(@class,'widgetCalenderTxt')]")
	static WebElement calender_txt;	
	
	//Sikuli Code
	static Screen screen=new Screen();
	static Pattern from_city_gkk=new Pattern("C:\\Workspace\\InViaCom\\sikuli_images\\go-ibibo\\from_city.png");
	static Pattern to_city_bng=new Pattern("C:\\Workspace\\InViaCom\\sikuli_images\\go-ibibo\\to_city.png");		
	
   //Main Method
	public static void main(String[] args) throws InterruptedException, IOException, FindFailed
	{			
		//Selenium Code
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/trains/");	
		Thread.sleep(2000);	
		excelData();
		searchTrains();
		
	}
	
	//SearchTrainMethod
		public static void searchTrains() throws FindFailed, InterruptedException
		{		        		
			//txtFromCity.sendKeys(fromCity);
			//txtToCity.sendKeys(toCity);
			driver.findElement(By.xpath(".//div[@class='formWrap padT15']/div[1]/input")).sendKeys(fromCity);
			Thread.sleep(2000);
			screen.click(from_city_gkk);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//div[@class='formWrap padT15']/div[2]/input")).sendKeys(toCity);
			Thread.sleep(2000);
			screen.click(to_city_bng);
			Thread.sleep(2000);	
			
			WebElement selectClass=driver.findElement(By.xpath(".//select[@name='gi_className']")); 
			Select select=new Select(selectClass);
			select.selectByValue("SL");
			
			journeyDate("12");
			
			WebElement searchBtn=driver.findElement(By.xpath(".//*[@id='gi_search_btn']"));
			searchBtn.click();
		}
	
	//ExcelData
	public static void excelData() throws IOException
	{
		Workbook wb=new XSSFWorkbook(new FileInputStream("C:\\Workspace\\InViaCom\\data.xlsx"));
		Sheet sheet=wb.getSheet("Sheet1");
		fromCity=sheet.getRow(1).getCell(0).toString();
	    toCity=sheet.getRow(1).getCell(1).toString();
	    System.out.println(fromCity+" "+toCity);
    }
	
	//Date Select
	public static void journeyDate(String jDate) throws InterruptedException
	{
		driver.findElement(By.xpath(".//input[contains(@class,'widgetCalenderTxt')]")).click();
		//calender_txt.click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".//span[contains(@class,'DayPicker-NavButton--next')]")).click();
		Thread.sleep(2000);
		List<WebElement> allDates=driver.findElements(By.xpath(".//div[contains(@class,'DayPicker-Day')]"));
		for(WebElement date : allDates)
		{			
			if(date.getText().equals(jDate))
			{
				System.out.println(date.getText());
				date.click();
			}
		}
		
	}	
	

}
