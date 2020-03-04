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
import com.tyss.eletter.objectrepository.BDPolicyLetterFormPage;
import com.tyss.eletter.objectrepository.BDPolicyLetterPage;
import com.tyss.eletter.objectrepository.HomePage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class BDPolicyLetter extends Base {
	@Test
	public void editBDPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		BDPolicyLetterFormPage bdForm = PageFactory.initElements(driver, BDPolicyLetterFormPage.class);
		BDPolicyLetterPage bdLetter = PageFactory.initElements(driver, BDPolicyLetterPage.class);
		h.getBdPolicyLink().click();
		String bdPolicyAct = bdForm.getBdPolicyLetterText().getText();
		String bdPolicyExp = "BD Policy";
		Assert.assertTrue(bdPolicyAct.contains(bdPolicyExp));
		Reporter.log("BD Policy Letter form is displayed", true);
		String salutaion = fib.getExcelData("BDPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("BDPolicyLetter", 1, 1);
		String fatherName = fib.getExcelData("BDPolicyLetter", 1, 2);
		String employeeId = fib.getExcelData("BDPolicyLetter", 1, 3);
		String designation = fib.getExcelData("BDPolicyLetter", 1, 4);
		String joinDate = fib.getExcelData("BDPolicyLetter", 1, 5);
		String age = fib.getExcelData("BDPolicyLetter", 1, 6);
		String address = fib.getExcelData("BDPolicyLetter", 1, 7);
		bdForm.bdPolicy(salutaion, employeeName, fatherName, employeeId, designation, joinDate, age, address);
		bdLetter.getEditBtn().click();
		String editName = fib.getExcelData("BDPolicyLetter", 1, 8);
		bdForm.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editName);
		bdForm.getGenerateBtn().click();
		String actName = bdForm.getEditNameText().getText();
		String expName = "Chandana";
		Assert.assertEquals(actName, expName);
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}

	@Test
	public void sendMailBDPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		BDPolicyLetterFormPage bdForm = PageFactory.initElements(driver, BDPolicyLetterFormPage.class);
		BDPolicyLetterPage bdLetter = PageFactory.initElements(driver, BDPolicyLetterPage.class);
		h.getBdPolicyLink().click();
		String bdPolicyAct = bdForm.getBdPolicyLetterText().getText();
		String bdPolicyExp = "BD Policy";
		Assert.assertTrue(bdPolicyAct.contains(bdPolicyExp));
		Reporter.log("BD Policy Letter form is displayed", true);
		String salutaion = fib.getExcelData("BDPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("BDPolicyLetter", 1, 1);
		String fatherName = fib.getExcelData("BDPolicyLetter", 1, 2);
		String employeeId = fib.getExcelData("BDPolicyLetter", 1, 3);
		String designation = fib.getExcelData("BDPolicyLetter", 1, 4);
		String joinDate = fib.getExcelData("BDPolicyLetter", 1, 5);
		String age = fib.getExcelData("BDPolicyLetter", 1, 6);
		String address = fib.getExcelData("BDPolicyLetter", 1, 7);
		bdForm.bdPolicy(salutaion, employeeName, fatherName, employeeId, designation, joinDate, age, address);
		bdLetter.getSendMailBtn().click();
		String toMailId = fib.getExcelData("BDPolicyLetter", 1, 9);
		WebElement to = bdLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(to));
		to.sendKeys(toMailId);
		String ccMailId = fib.getExcelData("BDPolicyLetter", 1, 10);
		WebElement cc = bdLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(cc));
		cc.sendKeys(ccMailId);
		String subject = fib.getExcelData("BDPolicyLetter", 1, 11);
		bdLetter.getSubjectTB().sendKeys(subject);
		String content = fib.getExcelData("BDPolicyLetter", 1, 12);
		bdLetter.getContentTA().sendKeys(content);
		String filepath = fib.getExcelData("BDPolicyLetter", 1, 13);
		bdLetter.getFilePathTB().sendKeys(filepath);
		bdLetter.getSendBtn().click();
		WebElement successMsg = bdLetter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean result = successMsg.isDisplayed();
		Assert.assertTrue(result);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);

	}

	@Test
	public void skippingMandatoryFieldTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		BDPolicyLetterFormPage bdForm = PageFactory.initElements(driver, BDPolicyLetterFormPage.class);
		h.getBdPolicyLink().click();
		String bdPolicyAct = bdForm.getBdPolicyLetterText().getText();
		String bdPolicyExp = "BD Policy";
		Assert.assertTrue(bdPolicyAct.contains(bdPolicyExp));
		Reporter.log("BD Policy Letter form is displayed", true);
		String salutaion = fib.getExcelData("BDPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("BDPolicyLetter", 1, 1);
		String fatherName = fib.getExcelData("BDPolicyLetter", 1, 2);
		String employeeId = fib.getExcelData("BDPolicyLetter", 1, 3);
		String designation = fib.getExcelData("BDPolicyLetter", 1, 4);
		bdForm.bdPolicy(salutaion, employeeName, fatherName, employeeId, designation);
		Boolean error = bdForm.getErrorMsg().isDisplayed();
		Assert.assertTrue(error);
		Reporter.log("Cannot generate BD Policy Letter by skipping joining date --> Test is PASS", true);
	}

	@Test
	public void previewBDPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		BDPolicyLetterFormPage bdForm = PageFactory.initElements(driver, BDPolicyLetterFormPage.class);
		BDPolicyLetterPage bdLetter = PageFactory.initElements(driver, BDPolicyLetterPage.class);
		h.getBdPolicyLink().click();
		String bdPolicyAct = bdForm.getBdPolicyLetterText().getText();
		String bdPolicyExp = "BD Policy";
		Assert.assertTrue(bdPolicyAct.contains(bdPolicyExp));
		Reporter.log("BD Policy Letter form is displayed", true);
		String salutaion = fib.getExcelData("BDPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("BDPolicyLetter", 1, 1);
		String fatherName = fib.getExcelData("BDPolicyLetter", 1, 2);
		String employeeId = fib.getExcelData("BDPolicyLetter", 1, 3);
		String designation = fib.getExcelData("BDPolicyLetter", 1, 4);
		String joinDate = fib.getExcelData("BDPolicyLetter", 1, 5);
		String age = fib.getExcelData("BDPolicyLetter", 1, 6);
		String address = fib.getExcelData("BDPolicyLetter", 1, 7);
		bdForm.bdPolicy(salutaion, employeeName, fatherName, employeeId, designation, joinDate, age, address);
		bdLetter.getPrintIcon().click();
		WebElement headLetterCheckbox = bdLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(headLetterCheckbox));
		headLetterCheckbox.click();
		bdLetter.getPrintPreviewBtn().click();
		Reporter.log("Preview of BD Policy Letter is displayed--> Test is PASS", true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
	}
}
