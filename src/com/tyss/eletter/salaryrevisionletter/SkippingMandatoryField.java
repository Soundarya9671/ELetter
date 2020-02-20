package com.tyss.eletter.salaryrevisionletter;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

		/* To click Salary Revision Letter */
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

		/* To enter Increment in Effect Date */
		driver.findElement(By.id("incrementInEffectDate")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 2));

		/* To enter Salary Increment From */
		driver.findElement(By.id("salaryIncrementFrom")).sendKeys(fib.getExcelData("SalaryRevisionLetter", 1, 3));

		try {

			error = driver.findElement(By.xpath("//div[contains(text(),'Please')]")).getText();

		} catch (Exception e) {

			logger.info("Cannot generate Salary Revision Letter by skipping Salary Increment To --> Test is PASS");

		}
	}
}
