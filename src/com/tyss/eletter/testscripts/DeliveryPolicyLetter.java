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
import com.tyss.eletter.objectrepository.DeliveryPolicyLetterFormPage;
import com.tyss.eletter.objectrepository.DeliveryPolicyLetterPage;
import com.tyss.eletter.objectrepository.HomePage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class DeliveryPolicyLetter extends Base {
	
	@Test
	public void editDeliveryPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		DeliveryPolicyLetterFormPage dPForm = PageFactory.initElements(driver, DeliveryPolicyLetterFormPage.class);
		DeliveryPolicyLetterPage dPLetter = PageFactory.initElements(driver, DeliveryPolicyLetterPage.class);
		h.getDeliveryPolicyLink().click();
		String policyAct = dPForm.getDeliveryPolicyLetterText().getText();
		String policyExp = "Delivery";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("Delivery Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("DeliveryPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("DeliveryPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("DeliveryPolicyLetter", 1, 2);
		String designation = fib.getExcelData("DeliveryPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("DeliveryPolicyLetter", 1, 4);
		String address = fib.getExcelData("DeliveryPolicyLetter", 1, 5);
		String age = fib.getExcelData("DeliveryPolicyLetter", 1, 13);
		String fatherName =  fib.getExcelData("DeliveryPolicyLetter", 1, 12);
		dPForm.deliveryPolicy(salutation, employeeName, fatherName,employeeId, designation, joinDate,age, address);
		dPLetter.getEditBtn().click();
		String editName = fib.getExcelData("DeliveryPolicyLetter", 1, 6);
		dPForm.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editName);
		dPForm.getGenerateBtn().click();
		String actName = dPForm.getEditNameText().getText();
		String expName = "Chandana";
		Assert.assertEquals(actName, expName);
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}
	@Test
	public void previewDeliveryPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		DeliveryPolicyLetterFormPage dPForm = PageFactory.initElements(driver, DeliveryPolicyLetterFormPage.class);
		DeliveryPolicyLetterPage dPLetter = PageFactory.initElements(driver, DeliveryPolicyLetterPage.class);
		h.getDeliveryPolicyLink().click();
		String policyAct = dPForm.getDeliveryPolicyLetterText().getText();
		String policyExp = "Delivery";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("Delivery Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("DeliveryPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("DeliveryPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("DeliveryPolicyLetter", 1, 2);
		String designation = fib.getExcelData("DeliveryPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("DeliveryPolicyLetter", 1, 4);
		String address = fib.getExcelData("DeliveryPolicyLetter", 1, 5);
		String age = fib.getExcelData("DeliveryPolicyLetter", 1, 13);
		String fatherName = fib.getExcelData("DeliveryPolicyLetter", 1, 12);
		dPForm.deliveryPolicy(salutation, employeeName, fatherName, employeeId, designation, joinDate, age, address);
		dPLetter.getPrintIcon().click();
		WebElement checkBox = dPLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		checkBox.click();
		dPLetter.getPrintPreviewBtn().click();
		Reporter.log("Preview of Delivery Policy Letter is displayed--> Test is PASS", true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
	}
	@Test
	public void sendMailDeliveryPolicyLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		DeliveryPolicyLetterFormPage dPForm = PageFactory.initElements(driver, DeliveryPolicyLetterFormPage.class);
		DeliveryPolicyLetterPage dPLetter = PageFactory.initElements(driver, DeliveryPolicyLetterPage.class);
		h.getDeliveryPolicyLink().click();
		String policyAct = dPForm.getDeliveryPolicyLetterText().getText();
		String policyExp = "Delivery";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("Delivery Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("DeliveryPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("DeliveryPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("DeliveryPolicyLetter", 1, 2);
		String designation = fib.getExcelData("DeliveryPolicyLetter", 1, 3);
		String joinDate = fib.getExcelData("DeliveryPolicyLetter", 1, 4);
		String address = fib.getExcelData("DeliveryPolicyLetter", 1, 5);
		String age = fib.getExcelData("DeliveryPolicyLetter", 1, 13);
		String fatherName = fib.getExcelData("DeliveryPolicyLetter", 1, 12);
		dPForm.deliveryPolicy(salutation, employeeName, fatherName,employeeId, designation, joinDate,age, address);
		dPLetter.getSendMailBtn().click();
		String toMail = fib.getExcelData("DeliveryPolicyLetter", 1, 7);
		WebElement toMailId = dPLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(toMailId));
		toMailId.sendKeys(toMail);
		String ccMail = fib.getExcelData("DeliveryPolicyLetter", 1, 8);
		WebElement cc = dPLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(cc));
		cc.sendKeys(ccMail);
		String subject = fib.getExcelData("DeliveryPolicyLetter", 1, 9);
		dPLetter.getSubjectTB().sendKeys(subject);
		String content = fib.getExcelData("DeliveryPolicyLetter", 1, 10);
		dPLetter.getContentTA().sendKeys(content);
		String fileupload = fib.getExcelData("DeliveryPolicyLetter", 1, 11);
		dPLetter.getFilePathTB().sendKeys(fileupload);
		dPLetter.getSendBtn().click();
		WebElement successMsg = dPLetter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean result = successMsg.isDisplayed();
		Assert.assertTrue(result);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
	@Test
	public void skippingMandatoryFieldTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		DeliveryPolicyLetterFormPage dPForm = PageFactory.initElements(driver, DeliveryPolicyLetterFormPage.class);
		h.getDeliveryPolicyLink().click();
		String policyAct = dPForm.getDeliveryPolicyLetterText().getText();
		String policyExp = "Delivery";
		Assert.assertTrue(policyAct.contains(policyExp));
		Reporter.log("Delivery Policy Letter form is displayed", true);
		String salutation = fib.getExcelData("DeliveryPolicyLetter", 2, 0);
		String employeeName = fib.getExcelData("DeliveryPolicyLetter", 1, 1);
		String employeeId = fib.getExcelData("DeliveryPolicyLetter", 1, 2);
		String designation = fib.getExcelData("DeliveryPolicyLetter", 1, 3);
		String age = fib.getExcelData("DeliveryPolicyLetter", 1, 13);
		String fatherName = fib.getExcelData("DeliveryPolicyLetter", 1, 12);
		dPForm.deliveryPolicy(salutation, employeeName, fatherName, employeeId, designation, age);
		Assert.assertTrue(dPForm.getErrorMsg().isDisplayed());
		Reporter.log("Cannot generate Delivery Policy Letter by skipping Joined date --> Test is PASS", true);
	}
}
