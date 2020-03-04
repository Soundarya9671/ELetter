package com.tyss.eletter.genericlibrary;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplement implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {

		Date d = new Date();
		System.out.println(d);

   @SuppressWarnings("deprecation")
		int date = d.getDate();
       
		//To capture date

		String[] dateArray = d.toString().split(" ");

		String month = dateArray[1];
		String year = dateArray[5];
		String time = dateArray[3].replaceAll(":", "-");
		String method = result.getMethod().getMethodName();

		EventFiringWebDriver fire = new EventFiringWebDriver(Base.screenShotDriver);

		File src = fire.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenShot/" + method + "_" + date + "_" + month + "_" + year + "_" + time + ".png");
		try {

			FileUtils.copyFile(src, dest);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
