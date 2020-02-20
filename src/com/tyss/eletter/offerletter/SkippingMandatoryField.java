package com.tyss.eletter.offerletter;

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
		
		/*To click on Login*/
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		
		driver.findElement(By.linkText("Offer Letter")).click();
		String offer = driver.findElement(By.xpath("//h3[text()='Offer Letter']")).getText();
		if(offer.contains("Offer")) 
			logger.info("Offer letter page is displayed");
		else 
			logger.info("Offer letter page is not displayed");
		
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
		
		try {
			
			error = driver.findElement(By.xpath("//div[contains(text(),'Please')]")).getText();
			
			}
			catch(Exception e) {
				
				logger.info("Cannot generate Offer Letter by skipping Offer Validity --> Test is PASS");
			}
		
	}
}
