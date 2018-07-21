package com.via.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMakeMyTrip {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		//From
        driver.findElement(By.xpath(".//*[@id='hp-widget__sfrom']")).click();
        Thread.sleep(3000);        
        driver.findElement(By.xpath(".//ul[@id='ui-id-1']/li/div/p/span[contains(text(),'Bangalore')]")).click();
        
        //To
        driver.findElement(By.xpath(".//*[@id='hp-widget__sTo']")).click();
        Thread.sleep(3000);  
        driver.findElement(By.xpath(".//ul[@id='ui-id-2']/li/div/p/span[text()='Kolkata, India ']")).click();
        
        //Date Depart
        List<WebElement> allDatesJuly=driver.findElements(By.xpath(".//*[@id='dp1532169396467']/descendant::div[@class='ui-datepicker-group ui-datepicker-group-first']/descendant::td/a"));
        for (WebElement date: allDatesJuly) {           
            if (date.getText().equals("22")) {
            	date.click();
                break;
            }
        }
	}

}
