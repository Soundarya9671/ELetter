package com.tyss.eletter.genericlibrary;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.tyss.eletter.objectrepository.LoginPage;
import com.tyss.eletter.objectrepository.LogoutPage;

public class Base {

	public WebDriver driver;
	public FileLib fib = new FileLib();
	public WebDriverWait wait;
	public Utility util = new Utility();
	public static WebDriver screenShotDriver;

	@BeforeClass

	public void configBC() {
		if (fib.getPropertyKey("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driverExecutables/chromedriver.exe");
			driver = new ChromeDriver();
			screenShotDriver = driver;
		} else {
			System.setProperty("webdriver.gecko.driver", "./driverExecutables/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(fib.getPropertyKey("url"));
	}

	@BeforeMethod
	public void configBM() {
		LoginPage l = PageFactory.initElements(driver, LoginPage.class);
		String actTitle = driver.getTitle();
		String expTitle = "React";
		Assert.assertTrue(actTitle.contains(expTitle));
		Reporter.log("Login page is displayed", true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		String email = fib.getPropertyKey("email");
		String password = fib.getPropertyKey("password");
		l.login(email, password);
	}

	@AfterMethod
	public void configAM() {
		LogoutPage lp = PageFactory.initElements(driver, LogoutPage.class);
		lp.getLogout();
		Reporter.log("Logout", true);
	}

	@AfterClass
	public void configAC() {
		driver.quit();
		Reporter.log("Close browser", true);
	}
}
   