package com.via.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TestSearchFlights {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		
		//Sikuli code
		Screen screen =new Screen();
		Pattern selectBng=new Pattern("C:\\Workspace\\InViaCom\\sikuli_images\\Screenshot_1.png");
		Pattern selectGoa=new Pattern("C:\\Workspace\\InViaCom\\sikuli_images\\Screenshot_2.png");
		
		//Selenium Code
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://in.via.com/");
		
		WebElement btnNoThanks=driver.findElement(By.id("wzrk-cancel"));
		btnNoThanks.click();
		Thread.sleep(3000);		
		
		WebElement txtFrom=driver.findElement(By.xpath(".//*[@id='source']"));
		txtFrom.sendKeys("Bang");
		screen.click(selectBng);
		
		WebElement txtTo=driver.findElement(By.xpath(".//*[@id='destination']"));
		txtTo.sendKeys("Goa");
		screen.click(selectGoa);
		
		//departure date
		Thread.sleep(3000);	
		driver.findElement(By.xpath(".//*[@id='depart-cal']/div[3]/div[2]/div[4]/div[6]")).click();		
		
		//Return Date
		Thread.sleep(3000);	
		WebElement dateRet=driver.findElement(By.xpath(".//*[@id='round-trip-panel']/div[5]"));
		dateRet.click();
		driver.findElement(By.xpath(".//*[@id='return-cal']/div[3]/div[2]/div[4]/div[7]")).click();
	}

}
