package com.tyss.eletter.exitletter;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.tyss.eletter.genericlibrary.FileLib;
import com.tyss.eletter.genericlibrary.Utility;

public class SkippingMandatoryField {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();
	static String error;

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
		
		
		driver.findElement(By.linkText("Exit Letter")).click();
		String exit = driver.findElement(By.xpath("//h3[text()='Exit Letter']")).getText();
		if(exit.contains("Exit")) 
			System.out.println("Exit letter page is displayed");
		else 
			System.out.println("Exit letter page is not displayed");
		
		/*To select Ms from Salutation dropdown*/
		WebElement salutation = driver.findElement(By.id("salutation"));
		util.selectByVisibleText(salutation, fib.getExcelData("Exitletter", 2, 0));
		
		/*To enter Employee name*/
		driver.findElement(By.id("employeeName")).sendKeys(fib.getExcelData("Exitletter", 1, 1));
		
		/*To enter Designation*/
		driver.findElement(By.id("designation")).sendKeys(fib.getExcelData("Exitletter", 1, 2));
		
		/*To enter CompanyLocation*/
		driver.findElement(By.id("companyLocation")).sendKeys(fib.getExcelData("Exitletter", 1, 3));
		
		/*To enter deduction salary*/
		WebElement salaryDeduction =  driver.findElement(By.id("salaryDeduction"));
		salaryDeduction.sendKeys(Keys.chord(Keys.CONTROL, "a"), fib.getExcelData("Exitletter", 1, 4));
		
		/*To enter deduction TDS*/
		WebElement deductionTDS = driver.findElement(By.id("deductionTDS"));
	    deductionTDS.sendKeys(Keys.chord(Keys.CONTROL, "a"), fib.getExcelData("Exitletter", 1, 5));
	    
		/*To enter salary*/
		WebElement salary = driver.findElement(By.id("salary"));
		salary.sendKeys(Keys.chord(Keys.CONTROL, "a"), fib.getExcelData("Exitletter", 1, 6));
		
		/*To enter fund due*/
		WebElement fundDue = driver.findElement(By.id("fundDue"));
		fundDue.sendKeys(Keys.chord(Keys.CONTROL, "a"), fib.getExcelData("Exitletter", 1, 7));
		
		/*To enter gratuity*/
		WebElement gratuity = driver.findElement(By.id("gratuity"));
		gratuity.sendKeys(fib.getExcelData("Exitletter", 1, 8));
		
		try {
			
		error = driver.findElement(By.xpath("//div[contains(text(),'Please')]")).getText();
		
		}
		catch(Exception e) {
			
			System.out.println("Cannot generate Exit Letter by skipping Joining date --> Test is PASS");
		}
	
	}
}