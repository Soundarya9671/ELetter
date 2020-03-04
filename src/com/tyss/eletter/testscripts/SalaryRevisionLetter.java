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
import com.tyss.eletter.objectrepository.SalaryRevisionFormPage;
import com.tyss.eletter.objectrepository.SalaryRevisionLetterPage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class SalaryRevisionLetter extends Base {
	@Test
	public void editSalaryRevisionLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		SalaryRevisionFormPage salaryForm = PageFactory.initElements(driver, SalaryRevisionFormPage.class);
		SalaryRevisionLetterPage salaryletter = PageFactory.initElements(driver, SalaryRevisionLetterPage.class);
		h.getSalaryRevisionLink().click();
		String salaryRevisionAct = salaryForm.getSalaryRevisionLetterText().getText();
		String salaryRevisionExp = "Salary";
		Assert.assertTrue(salaryRevisionAct.contains(salaryRevisionExp));
		Reporter.log("Salary Revision Letter form is displayed", true);
		String employeeName = fib.getExcelData("SalaryRevisionLetter", 1, 0);
		String employeeId = fib.getExcelData("SalaryRevisionLetter", 1, 1);
		String incrementInEffect = fib.getExcelData("SalaryRevisionLetter", 1, 2);
		String incrementFrom = fib.getExcelData("SalaryRevisionLetter", 1, 3);
		String incrementTo = fib.getExcelData("SalaryRevisionLetter", 1, 4);
		salaryForm.salaryRevision(employeeName, employeeId, incrementInEffect, incrementFrom, incrementTo);
		salaryletter.getEditBtn().click();
		String editText = fib.getExcelData("SalaryRevisionLetter", 1, 5);
		salaryForm.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editText);
		salaryForm.getGenerateBtn().click();
		String editedNameAct = salaryForm.getEditText().getText();
		String editedNameExp = "Chandana";
		Assert.assertTrue(editedNameAct.contains(editedNameExp));
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}
	@Test
	public void previewSalaryRevisionLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		SalaryRevisionFormPage salaryForm = PageFactory.initElements(driver, SalaryRevisionFormPage.class);
		SalaryRevisionLetterPage salaryletter = PageFactory.initElements(driver, SalaryRevisionLetterPage.class);
		h.getSalaryRevisionLink().click();
		String salaryRevisionAct = salaryForm.getSalaryRevisionLetterText().getText();
		String salaryRevisionExp = "Salary";
		Assert.assertTrue(salaryRevisionAct.contains(salaryRevisionExp));
		Reporter.log("Salary Revision Letter form is displayed", true);
		String employeeName = fib.getExcelData("SalaryRevisionLetter", 1, 0);
		String employeeId = fib.getExcelData("SalaryRevisionLetter", 1, 1);
		String incrementInEffect = fib.getExcelData("SalaryRevisionLetter", 1, 2);
		String incrementFrom = fib.getExcelData("SalaryRevisionLetter", 1, 3);
		String incrementTo = fib.getExcelData("SalaryRevisionLetter", 1, 4);
		salaryForm.salaryRevision(employeeName, employeeId, incrementInEffect, incrementFrom, incrementTo);
		salaryletter.getPrintIcon().click();
		WebElement headLetterCheckbox = salaryletter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(headLetterCheckbox));
		headLetterCheckbox.click();
		salaryletter.getPrintPreviewBtn().click();
		Reporter.log("Preview of Salary Revision Letter is displayed--> Test is PASS", true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();

	}
	@Test
	public void sendMailSalaryRevisionLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		SalaryRevisionFormPage salaryForm = PageFactory.initElements(driver, SalaryRevisionFormPage.class);
		SalaryRevisionLetterPage salaryletter = PageFactory.initElements(driver, SalaryRevisionLetterPage.class);
		h.getSalaryRevisionLink().click();
		String salaryRevisionAct = salaryForm.getSalaryRevisionLetterText().getText();
		String salaryRevisionExp = "Salary";
		Assert.assertTrue(salaryRevisionAct.contains(salaryRevisionExp));
		Reporter.log("Salary Revision Letter form is displayed", true);
		String employeeName = fib.getExcelData("SalaryRevisionLetter", 1, 0);
		String employeeId = fib.getExcelData("SalaryRevisionLetter", 1, 1);
		String incrementInEffect = fib.getExcelData("SalaryRevisionLetter", 1, 2);
		String incrementFrom = fib.getExcelData("SalaryRevisionLetter", 1, 3);
		String incrementTo = fib.getExcelData("SalaryRevisionLetter", 1, 4);
		salaryForm.salaryRevision(employeeName, employeeId, incrementInEffect, incrementFrom, incrementTo);
		String to = fib.getExcelData("SalaryRevisionLetter", 1, 6);
		String cc = fib.getExcelData("SalaryRevisionLetter", 1, 7);
		String subject = fib.getExcelData("SalaryRevisionLetter", 1, 8);
		String content = fib.getExcelData("SalaryRevisionLetter", 1, 9);
		String fileupload = fib.getExcelData("SalaryRevisionLetter", 1, 10);
		salaryletter.getSendMailBtn().click();
		WebElement toMail = salaryletter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(toMail));
		toMail.sendKeys(to);
		WebElement ccMail = salaryletter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(ccMail));
		ccMail.sendKeys(cc);
		salaryletter.getSubjectTB().sendKeys(subject);
		salaryletter.getContentTA().sendKeys(content);
		salaryletter.getFilePathTB().sendKeys(fileupload);
		salaryletter.getSendBtn().click();
		WebElement successMsg = salaryletter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean success = successMsg.isDisplayed();
		Assert.assertTrue(success);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
	@Test
	public void skippingMandatoryFieldTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		SalaryRevisionFormPage salaryForm = PageFactory.initElements(driver, SalaryRevisionFormPage.class);
		h.getSalaryRevisionLink().click();
		String salaryRevisionAct = salaryForm.getSalaryRevisionLetterText().getText();
		String salaryRevisionExp = "Salary";
		Assert.assertTrue(salaryRevisionAct.contains(salaryRevisionExp));
		Reporter.log("Salary Revision Letter form is displayed", true);
		String employeeName = fib.getExcelData("SalaryRevisionLetter", 1, 0);
		String employeeId = fib.getExcelData("SalaryRevisionLetter", 1, 1);
		String incrementInEffect = fib.getExcelData("SalaryRevisionLetter", 1, 2);
		salaryForm.salaryRevision(employeeName, employeeId, incrementInEffect);
		Boolean errorMsg = salaryForm.getErrorMsg().isDisplayed();
		Assert.assertTrue(errorMsg);
		Reporter.log("Cannot generate Salary Revision Letter by skipping Salary Incremented from date --> Test is PASS",
				true);
	}
}
