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
import com.tyss.eletter.objectrepository.ConsultantOfferLetterFormPage;
import com.tyss.eletter.objectrepository.ConsultantOfferLetterPage;
import com.tyss.eletter.objectrepository.HomePage;


@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class ConsultantOfferLetter extends Base {
	@Test
	public void editConsultantOfferLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ConsultantOfferLetterFormPage c = PageFactory.initElements(driver, ConsultantOfferLetterFormPage.class);
		h.getConsultantOfferLink().click();
		String consultantOfferExp = c.getConsultantOfferLetterText().getText();
		String consultantOfferAct = "Consultant";
		Assert.assertTrue(consultantOfferExp.contains(consultantOfferAct));
		Reporter.log("Consultant Offer Letter form is displayed", true);
		String salutation = fib.getExcelData("ConsultantOfferLetter", 2, 0);
		String employeeName = fib.getExcelData("ConsultantOfferLetter", 1, 1);
		String designation = fib.getExcelData("ConsultantOfferLetter", 1, 2);
		String companyLocation = fib.getExcelData("ConsultantOfferLetter", 1, 3);
		String noticePeriod = fib.getExcelData("ConsultantOfferLetter", 1, 4);
		String joinDate = fib.getExcelData("ConsultantOfferLetter", 1, 5);
		String reportingDate = fib.getExcelData("ConsultantOfferLetter", 1, 6);
		c.consultantOffer(salutation, employeeName, designation, companyLocation, noticePeriod, joinDate,
				reportingDate);
		c.getEditBtn().click();
		String editEmployeeName = fib.getExcelData("ConsultantOfferLetter", 1, 7);
		c.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editEmployeeName);
		c.getGenerateBtn().click();
		String editedNameAct = c.getEditTxt().getText();
		Assert.assertTrue(editedNameAct.contains("Chandana"));
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}

	@Test
	public void previewConsultantOfferLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ConsultantOfferLetterFormPage c = PageFactory.initElements(driver, ConsultantOfferLetterFormPage.class);
		ConsultantOfferLetterPage cl = PageFactory.initElements(driver, ConsultantOfferLetterPage.class);
		h.getConsultantOfferLink().click();
		String consultantOfferExp = c.getConsultantOfferLetterText().getText();
		String consultantOfferAct = "Consultant";
		Assert.assertTrue(consultantOfferExp.contains(consultantOfferAct));
		Reporter.log("Consultant Offer Letter form is displayed", true);
		String salutation = fib.getExcelData("ConsultantOfferLetter", 2, 0);
		String employeeName = fib.getExcelData("ConsultantOfferLetter", 1, 1);
		String designation = fib.getExcelData("ConsultantOfferLetter", 1, 2);
		String companyLocation = fib.getExcelData("ConsultantOfferLetter", 1, 3);
		String noticePeriod = fib.getExcelData("ConsultantOfferLetter", 1, 4);
		String joinDate = fib.getExcelData("ConsultantOfferLetter", 1, 5);
		String reportingDate = fib.getExcelData("ConsultantOfferLetter", 1, 6);
		c.consultantOffer(salutation, employeeName, designation, companyLocation, noticePeriod, joinDate,
				reportingDate);
		cl.getprintIcon().click();
		WebElement checkBox = cl.getHeaderLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		checkBox.click();
		cl.getPrintPreviewBtn().click();
		Reporter.log("Preview of Consultant Offer Letter is displayed--> Test is PASS", true);
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
		ConsultantOfferLetterFormPage c = PageFactory.initElements(driver, ConsultantOfferLetterFormPage.class);
		h.getConsultantOfferLink().click();
		String consultantOfferExp = c.getConsultantOfferLetterText().getText();
		String consultantOfferAct = "Consultant";
		Assert.assertTrue(consultantOfferExp.contains(consultantOfferAct));
		Reporter.log("Consultant Offer Letter form is displayed", true);
		String salutation = fib.getExcelData("ConsultantOfferLetter", 2, 0);
		String employeeName = fib.getExcelData("ConsultantOfferLetter", 1, 1);
		String designation = fib.getExcelData("ConsultantOfferLetter", 1, 2);
		String companyLocation = fib.getExcelData("ConsultantOfferLetter", 1, 3);
		String noticePeriod = fib.getExcelData("ConsultantOfferLetter", 1, 4);
		c.consultantOffer(salutation, employeeName, designation, companyLocation, noticePeriod);
		Assert.assertTrue(c.getErrorMsg().isDisplayed());
		Reporter.log("Cannot generate Consultant Offer Letter by skipping Joined date --> Test is PASS", true);
	}

	@Test
	public void sendMailConsultantOfferLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ConsultantOfferLetterFormPage cForm = PageFactory.initElements(driver, ConsultantOfferLetterFormPage.class);
		ConsultantOfferLetterPage cLetter = PageFactory.initElements(driver, ConsultantOfferLetterPage.class);
		h.getConsultantOfferLink().click();
		String consultantOfferExp = cForm.getConsultantOfferLetterText().getText();
		String consultantOfferAct = "Consultant";
		Assert.assertTrue(consultantOfferExp.contains(consultantOfferAct));
		Reporter.log("Consultant Offer Letter form is displayed", true);
		String salutation = fib.getExcelData("ConsultantOfferLetter", 2, 0);
		String employeeName = fib.getExcelData("ConsultantOfferLetter", 1, 1);
		String designation = fib.getExcelData("ConsultantOfferLetter", 1, 2);
		String companyLocation = fib.getExcelData("ConsultantOfferLetter", 1, 3);
		String noticePeriod = fib.getExcelData("ConsultantOfferLetter", 1, 4);
		String joinDate = fib.getExcelData("ConsultantOfferLetter", 1, 5);
		String reportingDate = fib.getExcelData("ConsultantOfferLetter", 1, 6);
		cForm.consultantOffer(salutation, employeeName, designation, companyLocation, noticePeriod, joinDate,
				reportingDate);
		cLetter.getSendMailBtn().click();
		String toMail = fib.getExcelData("ConsultantOfferLetter", 1, 8);
		WebElement to = cLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(to));
		to.sendKeys(toMail);
		String ccMail = fib.getExcelData("ConsultantOfferLetter", 1, 9);
		WebElement cc = cLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(cc));
		cc.sendKeys(ccMail);
		String subject = fib.getExcelData("ConsultantOfferLetter", 1, 10);
		cLetter.getSubjectTB().sendKeys(subject);
		String content = fib.getExcelData("ConsultantOfferLetter", 1, 11);
		cLetter.getContentTA().sendKeys(content);
		String fileupload = fib.getExcelData("ConsultantOfferLetter", 1, 12);
		cLetter.getFilePathTB().sendKeys(fileupload);
		cLetter.getSendBtn().click();
		WebElement successMsg = cLetter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean result = successMsg.isDisplayed();
		Assert.assertTrue(result);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
}
