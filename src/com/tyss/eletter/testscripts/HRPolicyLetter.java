package com.tyss.eletter.testscripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tyss.eletter.genericlibrary.Base;
import com.tyss.eletter.objectrepository.HRPolicyLetterFormPage;
import com.tyss.eletter.objectrepository.HRPolicyLetterPage;
import com.tyss.eletter.objectrepository.HomePage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class HRPolicyLetter extends Base {

	@Test
	public void editHRPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		HRPolicyLetterFormPage hrForm = PageFactory.initElements(driver, HRPolicyLetterFormPage.class);
		HRPolicyLetterPage hrLetter = PageFactory.initElements(driver, HRPolicyLetterPage.class);
		h.getHrPolicyLink().click();
		String hrPolicyAct = hrForm.getHrPolicyLetterText().getText();
		String hrPolicyExp = "HR Policy";
		Assert.assertTrue(hrPolicyAct.contains(hrPolicyExp));
		Reporter.log("HR Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("HRPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("HRPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("HRPolicyLetter", 1, 2);
		String designation = fib.getExcelData("HRPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("HRPolicyLetter", 1, 4);
		String address = fib.getExcelData("HRPolicyLetter", 1, 5);
		hrForm.hrLetter(salutation, employeeName, employeeId, designation, joinDate, address);
		hrLetter.getEditBtn().click();
		WebElement editEmpName = hrForm.getEmployeeNameTB();
		String editName = fib.getExcelData("HRPolicyLetter", 1, 6);
		editEmpName.sendKeys(Keys.chord(Keys.CONTROL, "a"), editName);
		hrForm.getGenerateBtn().click();
		String editedNameAct = hrForm.getEditNameText().getText();
		String editedNameExp = "Chandana";
		Assert.assertTrue(editedNameAct.contains(editedNameExp));
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}
	@Test
	public void previewHRPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		HRPolicyLetterFormPage hrForm = PageFactory.initElements(driver, HRPolicyLetterFormPage.class);
		HRPolicyLetterPage hrLetter = PageFactory.initElements(driver, HRPolicyLetterPage.class);
		h.getHrPolicyLink().click();
		String hrPolicyAct = hrForm.getHrPolicyLetterText().getText();
		String hrPolicyExp = "HR Policy";
		Assert.assertTrue(hrPolicyAct.contains(hrPolicyExp));
		Reporter.log("HR Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("HRPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("HRPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("HRPolicyLetter", 1, 2);
		String designation = fib.getExcelData("HRPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("HRPolicyLetter", 1, 4);
		String address = fib.getExcelData("HRPolicyLetter", 1, 5);
		hrForm.hrLetter(salutation, employeeName, employeeId, designation, joinDate, address);
		hrLetter.getPrintIcon().click();
		WebElement checkBox = hrLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		checkBox.click();
		hrLetter.getPrintPreviewBtn().click();
	    Reporter.log("Preview of HR Policy Letter is displayed--> Test is PASS",true);
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
	}
	@Test
	public void skippingMandatoryFieldTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		HRPolicyLetterFormPage hrForm = PageFactory.initElements(driver, HRPolicyLetterFormPage.class);
		h.getHrPolicyLink().click();
		String hrPolicyAct = hrForm.getHrPolicyLetterText().getText();
		String hrPolicyExp = "HR Policy";
		Assert.assertTrue(hrPolicyAct.contains(hrPolicyExp));
		Reporter.log("HR Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("HRPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("HRPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("HRPolicyLetter", 1, 2);
		String designation = fib.getExcelData("HRPolicyLetter", 1, 3);
		String address = fib.getExcelData("HRPolicyLetter", 1, 5);
		hrForm.hrLetter(salutation, employeeName, employeeId, designation, address);
		Assert.assertTrue(hrForm.getErrorMsg().isDisplayed());
		Reporter.log("Cannot generate HR Policy Letter by skipping Joining date --> Test is PASS",true);

	}
	@Test
	public void sendMailHRPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		HRPolicyLetterFormPage hrForm = PageFactory.initElements(driver, HRPolicyLetterFormPage.class);
		HRPolicyLetterPage hrLetter = PageFactory.initElements(driver, HRPolicyLetterPage.class);
		h.getHrPolicyLink().click();
		String hrPolicyAct = hrForm.getHrPolicyLetterText().getText();
		String hrPolicyExp = "HR Policy";
		Assert.assertTrue(hrPolicyAct.contains(hrPolicyExp));
		Reporter.log("HR Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("HRPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("HRPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("HRPolicyLetter", 1, 2);
		String designation = fib.getExcelData("HRPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("HRPolicyLetter", 1, 4);
		String address = fib.getExcelData("HRPolicyLetter", 1, 5);
		hrForm.hrLetter(salutation, employeeName, employeeId, designation, joinDate, address);
		hrLetter.getSendMailBtn().click();
		String toMail = fib.getExcelData("HRPolicyLetter", 1, 7);
		String ccMail = fib.getExcelData("HRPolicyLetter", 1, 8);
		String subject = fib.getExcelData("HRPolicyLetter", 1, 9);
		String content = fib.getExcelData("HRPolicyLetter", 1, 10);
		String fileupload = fib.getExcelData("HRPolicyLetter", 1, 11);
		WebElement to = hrLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(to));
		to.sendKeys(toMail);
		WebElement cc = hrLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(cc));
		cc.sendKeys(ccMail);
		hrLetter.getSubjectTB().sendKeys(subject);
		hrLetter.getContentTA().sendKeys(content);
		hrLetter.getFilePathTB().sendKeys(fileupload);
		hrLetter.getSendBtn().click();
		WebElement successMsg = hrLetter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean result = successMsg.isDisplayed();
		Assert.assertTrue(result);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
}
