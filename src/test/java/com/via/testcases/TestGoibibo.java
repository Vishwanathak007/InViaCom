package com.via.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
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
	
	//Sikuli Code
	Screen screen=new Screen();
	Pattern from_city=new Pattern("C:\\Workspace\\InViaCom\\sikuli_images\\go-ibibo\\from_city.png");
	Pattern to_city=new Pattern("C:\\Workspace\\InViaCom\\sikuli_images\\go-ibibo\\to_city.png");		
	

	public static void main(String[] args) throws InterruptedException
	{			
		//Selenium Code
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/trains/");	
		Thread.sleep(2000);				
	}
	
	//ExcelData
	public void excelData() throws IOException
	{
		Workbook wb=new XSSFWorkbook(new FileInputStream("C:\\Workspace\\InViaCom\\data.xlsx"));
		Sheet sheet=wb.getSheet("Sheet1");
		 fromCity=sheet.getRow(1).getCell(0).toString();
		 toCity=sheet.getRow(1).getCell(0).toString();
    }
	
	//SearchTrainMethod
	public static void searchTrains()
	{		
		txtFromCity.sendKeys("fromCity");
		txtToCity.sendKeys(toCity);
	}

}
