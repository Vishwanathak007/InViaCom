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
		System.out.println("Website Opened...");
		
		//From
        driver.findElement(By.xpath(".//*[@id='hp-widget__sfrom']")).click();
        Thread.sleep(3000);        
        driver.findElement(By.xpath(".//ul[@id='ui-id-1']//span[contains(text(),'Bangalore')]")).click();
        System.out.println("From journey Selected...");
        
        //To
        driver.findElement(By.xpath(".//*[@id='hp-widget__sTo']")).click();
        Thread.sleep(3000);  
        driver.findElement(By.xpath(".//ul[@id='ui-id-2']//span[text()='Kolkata, India ']")).click();
        System.out.println("To Journey Selected...");
        
        //Date Depart
        List<WebElement> allDatesJuly=driver.findElements(By.xpath(".//div[@class='ui-datepicker-group ui-datepicker-group-first']//td"));
        System.out.println("Select Depart date...");
        for (WebElement date: allDatesJuly) {           
            if (date.getText().contains("27")) {
            	System.out.println("Selected the Depart date..."+date.getText());
            	date.click();
                break;
            }
        }
        
        Thread.sleep(2000);
        WebElement searchBtn=driver.findElement(By.xpath(".//*[@id='searchBtn']"));
        searchBtn.click();
	}

}
