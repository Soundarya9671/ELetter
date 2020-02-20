package com.tyss.eletter.hrpolicyletter;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.tyss.eletter.genericlibrary.FileLib;
import com.tyss.eletter.genericlibrary.Utility;

public class EditHRPolicyLetter {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();
	static String error;

	static {

		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}
	static Logger logger = Logger.getLogger(EditHRPolicyLetter.class.getName());
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get(fib.getPropertyKey("url"));
		String title = driver.getTitle();
		if (title.contains("React")) {
			logger.info("Home page is displayed");
		} else {
			logger.info("Home page is not displayed");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/* To enter Email */
		driver.findElement(By.id("email")).sendKeys(fib.getPropertyKey("email"), Keys.ENTER);

		/* To enter Password */
		driver.findElement(By.id("password")).sendKeys(fib.getPropertyKey("password"));

		/* To click on Login button */
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		/* To click on HR Policy Letter Letter */
		driver.findElement(By.linkText("HR Policy Letter")).click();
		String hrPolicy = driver.findElement(By.xpath("//h3[text()='HR Policy Letter']")).getText();

		if (hrPolicy.contains("HR Policy"))
			logger.info("HR Policy Letter form is displayed");
		else
			logger.info("HR Policy Letter form is not displayed");
		
		/*To select Ms from Salutation dropdown*/
		WebElement salutation = driver.findElement(By.id("salutation"));
		util.selectByVisibleText(salutation, fib.getExcelData("HRPolicyLetter", 2, 0));
		
		/*To enter Employee Name*/
		 driver.findElement(By.id("employeeName")).sendKeys(fib.getExcelData("HRPolicyLetter", 1, 1));
		
		 /*To enter Employee Id*/
		driver.findElement(By.id("employeeId")).sendKeys(fib.getExcelData("HRPolicyLetter", 1, 2));
			
		/* To enter Designation */
		driver.findElement(By.id("designation")).sendKeys(fib.getExcelData("HRPolicyLetter", 1, 3));
		
		/* To enter Join date */
		String joinD = fib.getExcelData("HRPolicyLetter", 1, 4);
		WebElement joindate = driver.findElement(By.id("joiningDate"));
		joindate.sendKeys(joinD);
		
		/*To enter Address*/
		driver.findElement(By.id("address")).sendKeys(fib.getExcelData("HRPolicyLetter", 1, 5));
		
	    /*To click on Generate button*/
        driver.findElement(By.id("generate")).submit();
      
	    /*To click on Edit button*/
        driver.findElement(By.xpath("//button[text()='Edit']")).click();
        
        /*Editing employee name*/
        WebElement edit = driver.findElement(By.id("employeeName"));
        edit.sendKeys(Keys.chord(Keys.CONTROL,"a"),fib.getExcelData("HRPolicyLetter", 1, 6));
       
        /*To click on Generate button*/
        driver.findElement(By.id("generate")).submit();
        
        String editedName = driver.findElement(By.xpath("//strong[text()='Chandana']")).getText();
        
        if(editedName.contains("Chandana"))
        	logger.info("Modified details is displayed--> Test is PASS");
        else
        	logger.info("Modified details is not displayed-->Test is FAIL");
	}
}
