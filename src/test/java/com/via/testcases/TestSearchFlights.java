package com.via.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;

public class TestSearchFlights {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, FindFailed {
		
		
		//Selenium Code
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://in.via.com/");
		
		WebElement btnNoThanks=driver.findElement(By.id("wzrk-cancel"));
		btnNoThanks.click();
		Thread.sleep(3000);		
		
		//From
		WebElement txtFrom=driver.findElement(By.xpath(".//*[@id='source']"));
		txtFrom.sendKeys("Bangalore");
		driver.findElement(By.xpath(".//ul[@id='ui-id-1']/li/span[contains(text(),'Bangalore')]")).click();
		Thread.sleep(2000);
		System.out.println("From Journey Selected...");
		
		//To
		WebElement txtTo=driver.findElement(By.xpath(".//*[@id='destination']"));
		txtTo.sendKeys("Goa");
		driver.findElement(By.xpath(".//ul[@id='ui-id-2']/li/span[contains(text(),'Goa')]")).click();
		Thread.sleep(5000);
		System.out.println("To Journey Selected...");
		
		//departure date
		//Thread.sleep(3000);	
		//driver.findElement(By.xpath(".//*[@id='depart-cal']/div[3]/div[2]/div[4]/div[7]")).click();		
		
		//Departure calender code
		List<WebElement> allDatesJuly=driver.findElements(By.xpath(".//*[@id='depart-cal']/div[3]/div[2]/div[@class='vc-row']/child::div"));
		System.out.println("Select Depart date...");
		for (WebElement date: allDatesJuly) {           
            if (date.getText().contains("23")){
            	System.out.println("Depart date selected..");
            	date.click();
            	System.out.println("Depart date is Clicked...");
                break;
            }
           
        }
		
		//SearchBtn
		driver.findElement(By.xpath(".//*[@id='search-flight-btn']")).click();
	}

}
