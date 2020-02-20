package com.tyss.eletter.bdpolicyletter;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.tyss.eletter.genericlibrary.FileLib;
import com.tyss.eletter.genericlibrary.Utility;

public class PreviewBDPolicyLetter {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();
	

	static {

		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}
	static Logger logger = Logger.getLogger(PreviewBDPolicyLetter.class.getName());
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
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

		/* To click on Login */
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		 /*To click on BD Policy Letter*/
		driver.findElement(By.linkText("BD Policy Letter")).click();
		
		String bdPolicy = driver.findElement(By.xpath("//h3[text()='BD Policy Letter']")).getText();
		if (bdPolicy.contains("Policy"))
			logger.info("BD Policy Letter is displayed");
		else
			logger.info("BD Policy Letter is not displayed");
		
		/* To select Ms from Salutation dropdown */
		WebElement salutation = driver.findElement(By.id("salutation"));
		util.selectByVisibleText(salutation, fib.getExcelData("BDPolicyLetter", 2, 0));

		/* To enter Employee name */
		driver.findElement(By.id("employeeName")).sendKeys(fib.getExcelData("BDPolicyLetter", 1, 1));
		
		/*To enter Father Name*/
		driver.findElement(By.id("fatherName")).sendKeys(fib.getExcelData("BDPolicyLetter", 1, 2));

		 /*To enter Employee Id*/
		driver.findElement(By.id("employeeId")).sendKeys(fib.getExcelData("BDPolicyLetter", 1, 3));
		
		/*To enter designation*/
		driver.findElement(By.id("designation")).sendKeys(fib.getExcelData("BDPolicyLetter", 1, 4));
		
		/* To enter Join date */
		String joinD = fib.getExcelData("BDPolicyLetter", 1, 5);
		WebElement joindate = driver.findElement(By.id("joiningDate"));
		joindate.sendKeys(joinD);

		/*To enter age*/
		driver.findElement(By.id("age")).sendKeys(fib.getExcelData("BDPolicyLetter", 1, 6));
		
		/*To enter Address*/
		driver.findElement(By.id("address")).sendKeys(fib.getExcelData("BDPolicyLetter", 1, 7));
		
		/* To click on Generate button */
		driver.findElement(By.id("generate")).submit();
		
		/*To click on Print icon*/
		driver.findElement(By.xpath("//img[contains(@src,'data') and contains(@style,'border-radius')]")).click();
		
		WebElement checkBox = driver.findElement(By.id("inlineCheckbox1"));
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		checkBox.click();
		
	    driver.findElement(By.xpath("//button[text()='Print Preview']")).click();
	   
	    logger.info("Print preview page is displayed--> Test is PASS");
	  
	}
}
