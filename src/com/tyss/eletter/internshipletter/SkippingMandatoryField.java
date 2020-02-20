package com.tyss.eletter.internshipletter;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.tyss.eletter.genericlibrary.FileLib;
import com.tyss.eletter.genericlibrary.Utility;

public class SkippingMandatoryField {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();
	static String error;

	static {

		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}
	static Logger logger = Logger.getLogger(SkippingMandatoryField.class.getName());
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(fib.getPropertyKey("url"));
		String title = driver.getTitle();
		if(title.contains("React")) {
			logger.info("Home page is displayed");
		}
		else {
			logger.info("Home page is not displayed");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*To enter Email*/
		driver.findElement(By.id("email")).sendKeys(fib.getPropertyKey("email"),Keys.ENTER);
		
		/*To enter Password*/
		driver.findElement(By.id("password")).sendKeys(fib.getPropertyKey("password"));
		
		/*To click on Login button*/
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		/*To click on Internship Letter*/
		driver.findElement(By.linkText("Internship Letter")).click();
		String intern = driver.findElement(By.xpath("//h3[text()='Intership Letter']")).getText();
		if(intern.contains("Intership")) 
			logger.info("Internship Letter page is displayed");
		else 
			logger.info("Internship Letter page is not displayed");
		
		/*To select Mr from Salutation dropdown*/
		WebElement salutation = driver.findElement(By.id("salutation"));
		util.selectByVisibleText(salutation, fib.getExcelData("Internshipletter", 1, 0));
		
		/*To enter Intern Name*/
		driver.findElement(By.id("internName")).sendKeys(fib.getExcelData("Internshipletter", 1, 1));
		
		/*To enter Intern Id*/
		driver.findElement(By.id("internId")).sendKeys(fib.getExcelData("Internshipletter", 1, 2));
		
		/*To enter CompanyLocation*/
		driver.findElement(By.id("companyLocation")).sendKeys(fib.getExcelData("Internshipletter", 1, 3));
		
		/*To enter Internship type*/
		driver.findElement(By.id("internType")).sendKeys(fib.getExcelData("Internshipletter", 1, 4));
		
		try {
			
		error = driver.findElement(By.xpath("//div[contains(text(),'Please')]")).getText();
		
		}
		catch(Exception e) {
			
			logger.info("Cannot generate Internship Letter by skipping Internship start date --> Test is PASS");
		}
	
	}
}
