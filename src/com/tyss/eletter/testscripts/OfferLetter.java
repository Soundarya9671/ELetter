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
import com.tyss.eletter.objectrepository.OfferLetterFormPage;
import com.tyss.eletter.objectrepository.OfferLetterPage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class OfferLetter extends Base {
	@Test
	public void editOfferLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		OfferLetterFormPage offerForm = PageFactory.initElements(driver, OfferLetterFormPage.class);
		OfferLetterPage offerLetter = PageFactory.initElements(driver, OfferLetterPage.class);
		h.getOfferLink().click();
		String offerLetterAct = offerForm.getOfferLetterText().getText();
		String offerLetterExp = "Offer";
		Assert.assertTrue(offerLetterAct.contains(offerLetterExp));
		Reporter.log("Offer letter form is displayed", true);
		String salutation = fib.getExcelData("Offerletter", 2, 0);
		String employeeName = fib.getExcelData("Offerletter", 1, 1);
		String fatherName = fib.getExcelData("Offerletter", 1, 2);
		String age = fib.getExcelData("Offerletter", 1, 3);
		String designation = fib.getExcelData("Offerletter", 1, 4);
		String companyLocation = fib.getExcelData("Offerletter", 1, 5);
		String salary = fib.getExcelData("Offerletter", 1, 6);
		String offerValidity = fib.getExcelData("Offerletter", 1, 7);
		String address = fib.getExcelData("Offerletter", 1, 8);
		offerForm.offerLetter(salutation, employeeName, fatherName, designation, companyLocation, salary, offerValidity,
				age, address);
		offerLetter.getEditBtn().click();
		String editName = fib.getExcelData("Offerletter", 1, 9);
		offerForm.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editName);
		offerForm.getGenerateBtn().click();
		String editedNameAct = offerForm.getEditNameText().getText();
		String editedNameExp = "Chandana";
		Assert.assertTrue(editedNameAct.contains(editedNameExp));
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}

	@Test
	public void previewOfferLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		OfferLetterFormPage offerForm = PageFactory.initElements(driver, OfferLetterFormPage.class);
		OfferLetterPage offerLetter = PageFactory.initElements(driver, OfferLetterPage.class);
		h.getOfferLink().click();
		String offerLetterAct = offerForm.getOfferLetterText().getText();
		String offerLetterExp = "Offer";
		Assert.assertTrue(offerLetterAct.contains(offerLetterExp));
		Reporter.log("Offer letter form is displayed", true);
		String salutation = fib.getExcelData("Offerletter", 2, 0);
		String employeeName = fib.getExcelData("Offerletter", 1, 1);
		String fatherName = fib.getExcelData("Offerletter", 1, 2);
		String age = fib.getExcelData("Offerletter", 1, 3);
		String designation = fib.getExcelData("Offerletter", 1, 4);
		String companyLocation = fib.getExcelData("Offerletter", 1, 5);
		String salary = fib.getExcelData("Offerletter", 1, 6);
		String offerValidity = fib.getExcelData("Offerletter", 1, 7);
		String address = fib.getExcelData("Offerletter", 1, 8);
		offerForm.offerLetter(salutation, employeeName, fatherName, designation, companyLocation, salary, offerValidity,
				age, address);
		offerLetter.getPrintIcon().click();
		WebElement headLetterCheckbox = offerLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(headLetterCheckbox));
		headLetterCheckbox.click();
		offerLetter.getPrintPreviewBtn().click();
		Reporter.log("Preview of Offer letter is displayed--> Test is PASS", true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
	}

	@Test
	public void skippingMandatoryField() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		OfferLetterFormPage offerForm = PageFactory.initElements(driver, OfferLetterFormPage.class);
		h.getOfferLink().click();
		String offerLetterAct = offerForm.getOfferLetterText().getText();
		String offerLetterExp = "Offer";
		Assert.assertTrue(offerLetterAct.contains(offerLetterExp));
		Reporter.log("Offer letter form is displayed", true);
		String salutation = fib.getExcelData("Offerletter", 2, 0);
		String employeeName = fib.getExcelData("Offerletter", 1, 1);
		String fatherName = fib.getExcelData("Offerletter", 1, 2);
		String age = fib.getExcelData("Offerletter", 1, 3);
		String designation = fib.getExcelData("Offerletter", 1, 4);
		String companyLocation = fib.getExcelData("Offerletter", 1, 5);
		String salary = fib.getExcelData("Offerletter", 1, 6);
		String address = fib.getExcelData("Offerletter", 1, 8);
		offerForm.offerLetter(salutation, employeeName, fatherName, designation, companyLocation, salary, age, address);
		Boolean success = offerForm.getErrorMsg().isDisplayed();
		Assert.assertTrue(success);
		Reporter.log("Cannot generate Offer Letter by skipping Offer Validity --> Test is PASS", true);
	}

	@Test
	public void sendMailOfferLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		OfferLetterFormPage offerForm = PageFactory.initElements(driver, OfferLetterFormPage.class);
		OfferLetterPage offerLetter = PageFactory.initElements(driver, OfferLetterPage.class);
		h.getOfferLink().click();
		String offerLetterAct = offerForm.getOfferLetterText().getText();
		String offerLetterExp = "Offer";
		Assert.assertTrue(offerLetterAct.contains(offerLetterExp));
		Reporter.log("Offer letter form is displayed", true);
		String salutation = fib.getExcelData("Offerletter", 2, 0);
		String employeeName = fib.getExcelData("Offerletter", 1, 1);
		String fatherName = fib.getExcelData("Offerletter", 1, 2);
		String age = fib.getExcelData("Offerletter", 1, 3);
		String designation = fib.getExcelData("Offerletter", 1, 4);
		String companyLocation = fib.getExcelData("Offerletter", 1, 5);
		String salary = fib.getExcelData("Offerletter", 1, 6);
		String offerValidity = fib.getExcelData("Offerletter", 1, 7);
		String address = fib.getExcelData("Offerletter", 1, 8);
		offerForm.offerLetter(salutation, employeeName, fatherName, designation, companyLocation, salary, offerValidity,
				age, address);
		String to = fib.getExcelData("Offerletter", 1, 10);
		String cc = fib.getExcelData("Offerletter", 1, 11);
		String subject = fib.getExcelData("Offerletter", 1, 12);
		String content = fib.getExcelData("Offerletter", 1, 13);
		String fileupload = fib.getExcelData("Offerletter", 1, 14);
		offerLetter.getSendMailBtn().click();
		WebElement toMail = offerLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(toMail));
		toMail.sendKeys(to);
		WebElement ccMail = offerLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(ccMail));
		ccMail.sendKeys(cc);
		offerLetter.getSubjectTB().sendKeys(subject);
		offerLetter.getContentTA().sendKeys(content);
		offerLetter.getFilePathTB().sendKeys(fileupload);
		offerLetter.getSendBtn().submit();
		WebElement successMsg = offerLetter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean success = successMsg.isDisplayed();
		Assert.assertTrue(success);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
}
