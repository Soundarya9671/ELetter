package com.tyss.eletter.consultantofferletter;

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

public class PreviewConsultantOfferLetter {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();
	static {

		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}
	static Logger logger = Logger.getLogger(PreviewConsultantOfferLetter.class.getName());
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

		/* To click on Consultant Offer Letter */
		driver.findElement(By.linkText("Consultant Offer Letter")).click();

		String consultantOffer = driver.findElement(By.xpath("//h3[text()='Consultant Offer Letter']")).getText();
		if (consultantOffer.contains("Consultant"))
			logger.info("Consultant Offer Letter form is displayed");
		else
			logger.info("Consultant Offer Letter form is not displayed");

		/* To select Ms from Salutation dropdown */
		WebElement salutation = driver.findElement(By.id("salutation"));
		util.selectByVisibleText(salutation, fib.getExcelData("ConsultantOfferLetter", 2, 0));

		/* To enter Employee name */
		driver.findElement(By.id("employeeName")).sendKeys(fib.getExcelData("ConsultantOfferLetter", 1, 1));

		/* To enter Designation */
		driver.findElement(By.id("designation")).sendKeys(fib.getExcelData("ConsultantOfferLetter", 1, 2));

		/* To enter CompanyLocation */
		driver.findElement(By.id("companyLocation")).sendKeys(fib.getExcelData("ConsultantOfferLetter", 1, 3));

		/* To enter Notice period month */
	    WebElement notice = driver.findElement(By.id("noticePeriod"));
		notice.sendKeys(fib.getExcelData("ConsultantOfferLetter", 1, 4));

		/* To enter Joined date */
		String joinD = fib.getExcelData("ConsultantOfferLetter", 1, 5);
		WebElement joindate = driver.findElement(By.id("joiningDate"));
		joindate.sendKeys(joinD);

		/* To enter Reporting date */
		String reportingDate = fib.getExcelData("ConsultantOfferLetter", 1, 6);
		WebElement reportDate = driver.findElement(By.id("reportingDate"));
		reportDate.sendKeys(reportingDate);

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
