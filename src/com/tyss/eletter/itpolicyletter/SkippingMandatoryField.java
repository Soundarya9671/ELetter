package com.tyss.eletter.itpolicyletter;

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

		/* To click on Project Policy Letter */
		driver.findElement(By.linkText("IT Policy Letter")).click();

		String policy = driver.findElement(By.xpath("//h3[text()='IT Policy Letter']")).getText();
		if (policy.contains("Policy"))
			logger.info("IT Policy Letter form is displayed");
		else
			logger.info("IT Policy Letter form is not displayed");

		/* To select Ms from Salutation dropdown */
		WebElement salutation = driver.findElement(By.id("salutation"));
		util.selectByVisibleText(salutation, fib.getExcelData("ITPolicyLetter", 2, 0));

		/* To enter Employee name */
		driver.findElement(By.id("employeeName")).sendKeys(fib.getExcelData("ITPolicyLetter", 1, 1));

		/* To enter Employee Id */
		driver.findElement(By.id("employeeId")).sendKeys(fib.getExcelData("ITPolicyLetter", 1, 2));

		/* To enter Designation */
		driver.findElement(By.id("designation")).sendKeys(fib.getExcelData("ITPolicyLetter", 1, 3));

		/* To enter Address */
		driver.findElement(By.id("address")).sendKeys(fib.getExcelData("ITPolicyLetter", 1, 5));

		try {

			error = driver.findElement(By.xpath("//div[contains(text(),'Please')]")).getText();

		} catch (Exception e) {

			logger.info("Cannot generate IT Policy Letter by skipping Joining date --> Test is PASS");
		}
	}

}
