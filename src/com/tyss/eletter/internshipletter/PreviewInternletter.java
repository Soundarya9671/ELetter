package com.tyss.eletter.internshipletter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tyss.eletter.genericlibrary.FileLib;
import com.tyss.eletter.genericlibrary.Utility;

public class PreviewInternletter {
	static Utility util = new Utility();
	static FileLib fib = new FileLib();
	static String error;

	static {

		System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		Date d = new Date();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
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
		
		/*To click on Login button*/
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		/*To click on Internship Letter*/
		driver.findElement(By.linkText("Internship Letter")).click();
		String exit = driver.findElement(By.xpath("//h3[text()='Intership Letter']")).getText();
		if(exit.contains("Intership")) 
			System.out.println("Internship Letter page is displayed");
		else 
			System.out.println("Internship Letter page is not displayed");
		
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
		
		/*To enter Internship start date*/
        WebElement start = driver.findElement(By.id("startDate"));		
        String startdate = fib.getExcelData("Internshipletter", 1, 5);
        start.sendKeys(startdate);
     
        /*To enter Internship end date*/
        WebElement end = driver.findElement(By.id("endDate"));		
        String enddate = fib.getExcelData("Internshipletter", 1, 6);
        end.sendKeys(enddate);
        
        /*To click on Generate button*/
        driver.findElement(By.id("generate")).submit();
       
        String internLetter = driver.findElement(By.xpath("//u[text()='INTERNSHIP CERTIFICATE']")).getText();
		
		if(internLetter.contains("INTERNSHIP"))
			System.out.println("Internship certificate page is displayed");
		
		else
			System.out.println("Internship certificate page is not displayed");
		
		/*To click on Print icon*/
		driver.findElement(By.xpath("//img[contains(@src,'data') and contains(@style,'border-radius')]")).click();
		
		WebElement checkBox = driver.findElement(By.id("inlineCheckbox1"));
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		checkBox.click();
		
	    driver.findElement(By.xpath("//button[text()='Print Preview']")).click();
	   
	    System.out.println("Print preview page is displayed--> Test is PASS");
	    
	}
}
