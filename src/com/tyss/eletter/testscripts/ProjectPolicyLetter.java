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
import com.tyss.eletter.objectrepository.ProjectPolicyFormPage;
import com.tyss.eletter.objectrepository.ProjectPolicyLetterPage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class ProjectPolicyLetter extends Base {
	@Test
	public void editProjectPolicyLetterTest() {
		ProjectPolicyFormPage projectForm = PageFactory.initElements(driver, ProjectPolicyFormPage.class);
		ProjectPolicyLetterPage projectLetter = PageFactory.initElements(driver, ProjectPolicyLetterPage.class);
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getProjectPolicyLink().click();
		String policyAct = projectForm.getProjectPolicyLetterText().getText();
		String policyExp = "Project";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("NDA Project Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ProjectPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ProjectPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ProjectPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ProjectPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("ProjectPolicyLetter", 1, 4);
		String address = fib.getExcelData("ProjectPolicyLetter", 1, 5);
		projectForm.offerLetter(salutation, employeeName, employeeId, designation, joinDate, address);
		projectLetter.getEditBtn().click();
		String editName = fib.getExcelData("ProjectPolicyLetter", 1, 6);
		projectForm.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editName);
		projectForm.getGenerateBtn().click();
		String editAct = projectForm.getEditNameText().getText();
		String editExp = "Chandana";
		Assert.assertTrue(editAct.contains(editExp));
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}

	@Test
	public void previewProjectPolicyLetterTest() {
		ProjectPolicyFormPage projectForm = PageFactory.initElements(driver, ProjectPolicyFormPage.class);
		ProjectPolicyLetterPage projectLetter = PageFactory.initElements(driver, ProjectPolicyLetterPage.class);
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getProjectPolicyLink().click();
		String policyAct = projectForm.getProjectPolicyLetterText().getText();
		String policyExp = "Project";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("NDA Project Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ProjectPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ProjectPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ProjectPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ProjectPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("ProjectPolicyLetter", 1, 4);
		String address = fib.getExcelData("ProjectPolicyLetter", 1, 5);
		projectForm.offerLetter(salutation, employeeName, employeeId, designation, joinDate, address);
		projectLetter.getPrintIcon().click();
		WebElement headLetterCheckbox = projectLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(headLetterCheckbox));
		headLetterCheckbox.click();
		projectLetter.getPrintPreviewBtn().click();
		Reporter.log("Preview of Project policy letter is displayed--> Test is PASS", true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();

	}

	@Test
	public void sendMailProjectPolicyLetterTest() {
		ProjectPolicyFormPage projectForm = PageFactory.initElements(driver, ProjectPolicyFormPage.class);
		ProjectPolicyLetterPage projectLetter = PageFactory.initElements(driver, ProjectPolicyLetterPage.class);
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getProjectPolicyLink().click();
		String policyAct = projectForm.getProjectPolicyLetterText().getText();
		String policyExp = "Project";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("NDA Project Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ProjectPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ProjectPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ProjectPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ProjectPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("ProjectPolicyLetter", 1, 4);
		String address = fib.getExcelData("ProjectPolicyLetter", 1, 5);
		projectForm.offerLetter(salutation, employeeName, employeeId, designation, joinDate, address);
		String to = fib.getExcelData("ProjectPolicyLetter", 1, 7);
		String cc = fib.getExcelData("ProjectPolicyLetter", 1, 8);
		String subject = fib.getExcelData("ProjectPolicyLetter", 1, 9);
		String content = fib.getExcelData("ProjectPolicyLetter", 1, 10);
		String fileupload = fib.getExcelData("ProjectPolicyLetter", 1, 11);
		projectLetter.getSendMailBtn().click();
		WebElement toMail = projectLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(toMail));
		toMail.sendKeys(to);
		WebElement ccMail = projectLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(ccMail));
		ccMail.sendKeys(cc);
		projectLetter.getSubjectTB().sendKeys(subject);
		projectLetter.getContentTA().sendKeys(content);
		projectLetter.getFilePathTB().sendKeys(fileupload);
		projectLetter.getSendBtn().click();
		WebElement successMsg = projectLetter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean success = successMsg.isDisplayed();
		Assert.assertTrue(success);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
		
	}

	@Test
	public void skippingMandatoryFieldTest() {
		ProjectPolicyFormPage projectForm = PageFactory.initElements(driver, ProjectPolicyFormPage.class);
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getProjectPolicyLink().click();
		String policyAct = projectForm.getProjectPolicyLetterText().getText();
		String policyExp = "Project";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("NDA Project Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("ProjectPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("ProjectPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("ProjectPolicyLetter", 1, 2);
		String designation = fib.getExcelData("ProjectPolicyLetter", 1, 3);
		String address = fib.getExcelData("ProjectPolicyLetter", 1, 5);
		projectForm.offerLetter(salutation, employeeName, employeeId, designation, address);
		Boolean errorMsg = projectForm.getErrorMsg().isDisplayed();
		Assert.assertTrue(errorMsg);
		Reporter.log("Cannot generate Project Policy Letter by skipping Joining date --> Test is PASS", true);
	}
}
