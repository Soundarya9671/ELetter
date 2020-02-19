package com.tyss.eletter.offerletter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tyss.eletter.genericlibrary.FileLib;
import com.tyss.eletter.genericlibrary.Utility;

public class EditOfferLetter {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();
	
	static {

		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		Date d = new Date();
		WebDriver driver = new ChromeDriver();
		driver.get(fib.getPropertyKey("url"));
		String title = driver.getTitle();
		if(title.contains("React")) {
			System.out.println("Home page is displayed");
		}
		else {
			System.out.println("Home page is not displayed");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*To enter Email*/
		driver.findElement(By.id("email")).sendKeys(fib.getPropertyKey("email"),Keys.ENTER);
		
		/*To enter Password*/
		driver.findElement(By.id("password")).sendKeys(fib.getPropertyKey("password"));
		
		/*To click on Login*/
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		
		driver.findElement(By.linkText("Offer Letter")).click();
		String offer = driver.findElement(By.xpath("//h3[text()='Offer Letter']")).getText();
		if(offer.contains("Offer")) 
			System.out.println("Offer letter page is displayed");
		else 
			System.out.println("Offer letter page is not displayed");
		
		/*To select Ms from Salutation dropdown*/
		WebElement salutation = driver.findElement(By.id("salutation"));
		util.selectByVisibleText(salutation, fib.getExcelData("Offerletter", 2, 0));
		
		/*To enter Employee name*/
		driver.findElement(By.id("employeeName")).sendKeys(fib.getExcelData("Offerletter", 1, 1));
		
		/*To enter Father Name*/
		driver.findElement(By.id("fatherName")).sendKeys(fib.getExcelData("Offerletter", 1, 2));
		
		/*To enter age*/
		driver.findElement(By.id("age")).sendKeys(fib.getExcelData("Offerletter", 1, 3));
		
		/*To enter designation*/
		driver.findElement(By.id("designation")).sendKeys(fib.getExcelData("Offerletter", 1, 4));
		
		/*To enter CompanyLocation*/
		driver.findElement(By.id("companyLocation")).sendKeys(fib.getExcelData("Offerletter", 1, 5));
		
		/*To enter salary*/
		WebElement salary = driver.findElement(By.id("salary"));
		salary.sendKeys(Keys.chord(Keys.CONTROL, "a"), fib.getExcelData("Offerletter", 1, 6));
		
		/*To enter Offer validity*/
		driver.findElement(By.id("offerValidity")).sendKeys(fib.getExcelData("Offerletter", 1, 7));
		
		/*To enter Address*/
		driver.findElement(By.id("address")).sendKeys(fib.getExcelData("Offerletter", 1, 8));
		
		/* To click on Generate button */
		driver.findElement(By.id("genrate")).submit();
		
		/*To click on Edit button*/
		driver.findElement(By.xpath("//button[text()='Edit']")).click();
		
		/*To edit Employee name*/
		driver.findElement(By.id("employeeName")).sendKeys(Keys.chord(Keys.CONTROL,"a"),fib.getExcelData("Offerletter", 1, 9));
		
		/* To click on Generate button */
		driver.findElement(By.id("genrate")).submit();
		
		 String editedName = driver.findElement(By.xpath("//strong[text()='Chandana']")).getText();
	        
        if(editedName.contains("Chandana"))
        	
        	System.out.println("Modified details is displayed--> Test is PASS");
        else
        	
        	System.out.println("Modified details is not displayed-->Test is FAIL");
		
	}
}
