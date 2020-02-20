package com.tyss.eletter.salaryrevisionletter;

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

public class Sendmail {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();

	static {

		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}
	static Logger logger = Logger.getLogger(Sendmail.class.getName());

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
		
		/*To click Salary Revision Letter*/
		driver.findElement(By.linkText("Salary Revision Letter")).click();
		
		String salaryRevision = driver.findElement(By.xpath("//h3[text()='Salary Revision Letter']")).getText();
		if (salaryRevision.contains("Salary"))
			logger.info("Salary Revision Letter form is displayed");
		else
			logger.info("Salary Revision Letter form is not displayed");

		/* To enter Employee name */
		driver.findElement(By.id("employeeName")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 0));
		
		/* To enter Employee Id */
		driver.findElement(By.id("employeeId")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 1));

		/*To enter Increment in Effect Date*/
		driver.findElement(By.id("incrementInEffectDate")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 2));
		
		/*To enter Salary Increment From*/
		driver.findElement(By.id("salaryIncrementFrom")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 3));
		
		/*To enter Salary Increment To*/
		driver.findElement(By.id("salaryIncrementTo")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 4));
		
		/* To click on Generate button */
		driver.findElement(By.id("generate")).submit();
		
		/*To click on Send mail button*/
		driver.findElement(By.xpath("//button[text()='Send Mail']")).click();
		
		/*To enter email id in to textbox*/
		driver.findElement(By.id("to")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 6));
		
		/*To enter email id in cc textbox*/
		driver.findElement(By.id("cc")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 7));
		
		/*To enter Subject*/
		driver.findElement(By.id("subject")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 8));
		
		/*To enter Content*/
		driver.findElement(By.id("content")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 9));
		
		/*To upload file*/
	    WebElement fileupload = driver.findElement(By.id("myInput"));
	    fileupload.sendKeys(fib.getExcelData("BDPolicyLetter", 1, 13));
		 
	    /*To click on Send button*/
        driver.findElement(By.xpath("//button[text()='Send']")).submit();
        
        WebElement successMsg =  driver.findElement(By.xpath("//div[text()='Email sent successfully']"));
        wait.until(ExpectedConditions.elementToBeClickable(successMsg));
        
        Boolean success = successMsg.isDisplayed();
        
        if(success)
        	logger.info("Mail sent successfully ---> Test is PASS");
        else
        	logger.info("Mail is not sent --> Test is FAIL");
		
		
	}
}
