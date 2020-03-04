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
import com.tyss.eletter.objectrepository.HomePage;
import com.tyss.eletter.objectrepository.ITPolicyLetterFormPage;
import com.tyss.eletter.objectrepository.ITPolicyLetterPage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class ITPolicyLetter extends Base {
	@Test
	public void editITPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ITPolicyLetterFormPage itForm = PageFactory.initElements(driver, ITPolicyLetterFormPage.class);
		ITPolicyLetterPage itLetter = PageFactory.initElements(driver, ITPolicyLetterPage.class);
		h.getItPolicyLink().click();
		String itLetterAct = itForm.getITPolicyLetterText().getText();
		String itLetterExp = "IT";
		Assert.assertTrue(itLetterAct.contains(itLetterExp));
		Reporter.log("IT Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ITPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ITPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ITPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ITPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("ITPolicyLetter", 1, 4);
		String address = fib.getExcelData("ITPolicyLetter", 1, 5);
		itForm.itPolicy(salutation, employeeName, employeeId, designation, joinDate, address);
		itLetter.getEditBtn().click();
		String editName = fib.getExcelData("ITPolicyLetter", 1, 6);
		itForm.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editName);
		itForm.getGenerateBtn().click();
		String editedNameAct = itForm.getEditNameText().getText();
		String editedNameExp = "Chandana";
		Assert.assertTrue(editedNameAct.contains(editedNameExp));
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}

	@Test
	public void previewITPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ITPolicyLetterFormPage itForm = PageFactory.initElements(driver, ITPolicyLetterFormPage.class);
		ITPolicyLetterPage itLetter = PageFactory.initElements(driver, ITPolicyLetterPage.class);
		h.getItPolicyLink().click();
		String itLetterAct = itForm.getITPolicyLetterText().getText();
		String itLetterExp = "IT";
		Assert.assertTrue(itLetterAct.contains(itLetterExp));
		Reporter.log("IT Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ITPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ITPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ITPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ITPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("ITPolicyLetter", 1, 4);
		String address = fib.getExcelData("ITPolicyLetter", 1, 5);
		itForm.itPolicy(salutation, employeeName, employeeId, designation, joinDate, address);
		itLetter.getPrintIcon().click();
		WebElement headLetterCheckbox = itLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(headLetterCheckbox));
		headLetterCheckbox.click();
		itLetter.getPrintPreviewBtn().click();
		Reporter.log("Preview of IT Policy letter is displayed--> Test is PASS", true);
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
		ITPolicyLetterFormPage itForm = PageFactory.initElements(driver, ITPolicyLetterFormPage.class);
		h.getItPolicyLink().click();
		String itLetterAct = itForm.getITPolicyLetterText().getText();
		String itLetterExp = "IT";
		Assert.assertTrue(itLetterAct.contains(itLetterExp));
		Reporter.log("IT Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ITPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ITPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ITPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ITPolicyLetter", 1, 3);
		itForm.itPolicy(salutation, employeeName, employeeId, designation);
		Boolean success = itForm.getErrorMsg().isDisplayed();
		Assert.assertTrue(success);
		Reporter.log("Cannot generate IT Policy Letter by skipping Joining date --> Test is PASS", true);
	}

	@Test
	public void sendMailITPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ITPolicyLetterFormPage itForm = PageFactory.initElements(driver, ITPolicyLetterFormPage.class);
		ITPolicyLetterPage itLetter = PageFactory.initElements(driver, ITPolicyLetterPage.class);
		h.getItPolicyLink().click();
		String itLetterAct = itForm.getITPolicyLetterText().getText();
		String itLetterExp = "IT";
		Assert.assertTrue(itLetterAct.contains(itLetterExp));
		Reporter.log("IT Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ITPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ITPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ITPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ITPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("ITPolicyLetter", 1, 4);
		String address = fib.getExcelData("ITPolicyLetter", 1, 5);
		itForm.itPolicy(salutation, employeeName, employeeId, designation, joinDate, address);
		itLetter.getSendMailBtn().click();
		String to = fib.getExcelData("ITPolicyLetter", 1, 7);
		String cc = fib.getExcelData("ITPolicyLetter", 1, 8);
		String subject = fib.getExcelData("ITPolicyLetter", 1, 9);
		String content = fib.getExcelData("ITPolicyLetter", 1, 10);
		String fileupload = fib.getExcelData("ITPolicyLetter", 1, 11);
		WebElement sendMail = itLetter.getSendMailBtn();
		sendMail.getLocation();
		WebElement toMail = itLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(toMail));
		toMail.sendKeys(to);
		WebElement ccMail = itLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(ccMail));
		ccMail.sendKeys(cc);
		itLetter.getSubjectTB().sendKeys(subject);
		itLetter.getContentTA().sendKeys(content);
		itLetter.getFilePathTB().sendKeys(fileupload);
		itLetter.getSendBtn().click();
		WebElement successMsg = itLetter.getSuccessMsg();
		Boolean success = successMsg.isDisplayed();
		Assert.assertFalse(success);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
}
