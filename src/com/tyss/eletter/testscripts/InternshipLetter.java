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
import com.tyss.eletter.objectrepository.InternshipLetterFormPage;
import com.tyss.eletter.objectrepository.InternshipLetterPage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class InternshipLetter extends Base {
	@Test
	public void editInternshipLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getInternShipLink().click();
		InternshipLetterFormPage iForm = PageFactory.initElements(driver, InternshipLetterFormPage.class);
		InternshipLetterPage iLetter = PageFactory.initElements(driver, InternshipLetterPage.class);
		String internAct = iForm.getInternshipText().getText();
		String internExp = "Internship";
		Assert.assertTrue(internAct.contains(internExp));
		Reporter.log("Internship Letter form is displayed", true);
		String salutation = fib.getExcelData("Internshipletter", 1, 0);
		String internName = fib.getExcelData("Internshipletter", 1, 1);
		String internId = fib.getExcelData("Internshipletter", 1, 2);
		String companyLocation = fib.getExcelData("Internshipletter", 1, 3);
		String internType = fib.getExcelData("Internshipletter", 1, 4);
		String startDate = fib.getExcelData("Internshipletter", 1, 5);
		String endDate = fib.getExcelData("Internshipletter", 1, 6);
		iForm.internLetter(salutation, internName, internId, companyLocation, internType, startDate, endDate);
		String internLetterAct = iForm.getInternshipCertificateText().getText();
		String internLetterExp = "INTERNSHIP";
		Assert.assertTrue(internLetterAct.contains(internLetterExp));
		Reporter.log("Internship certificate page is displayed", true);
		iLetter.getEditBtn().click();
		String editName = fib.getExcelData("Internshipletter", 1, 7);
		iForm.getInternNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editName);
		iForm.getGenerateBtn().click();
		String editedNameAct = iLetter.getEditText().getText();
		String editedNameExp = "Murli";
		Assert.assertTrue(editedNameAct.contains(editedNameExp));
		Reporter.log("Modified details are updated --> Test is PASS", true);
	}
	@Test
	public void skippingMandatoryFieldTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getInternShipLink().click();
		InternshipLetterFormPage iForm = PageFactory.initElements(driver, InternshipLetterFormPage.class);
		String internAct = iForm.getInternshipText().getText();
		String internExp = "Internship";
		Assert.assertTrue(internAct.contains(internExp));
		Reporter.log("Internship Letter form is displayed", true);
		String salutation = fib.getExcelData("Internshipletter", 1, 0);
		String internName = fib.getExcelData("Internshipletter", 1, 1);
		String internId = fib.getExcelData("Internshipletter", 1, 2);
		String companyLocation = fib.getExcelData("Internshipletter", 1, 3);
		iForm.internLetter(salutation, internName, internId, companyLocation);
		Boolean errorMsg = iForm.getErrorMsg().isDisplayed();
		Assert.assertTrue(errorMsg);
		Reporter.log("Cannot generate Internship Letter by skipping Internship start date --> Test is PASS", true);
	}
	@Test
	public void previewInternshipLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getInternShipLink().click();
		InternshipLetterFormPage iForm = PageFactory.initElements(driver, InternshipLetterFormPage.class);
		InternshipLetterPage iLetter = PageFactory.initElements(driver, InternshipLetterPage.class);
		String internAct = iForm.getInternshipText().getText();
		String internExp = "Internship";
		Assert.assertTrue(internAct.contains(internExp));
		Reporter.log("Internship Letter form is displayed", true);
		String salutation = fib.getExcelData("Internshipletter", 1, 0);
		String internName = fib.getExcelData("Internshipletter", 1, 1);
		String internId = fib.getExcelData("Internshipletter", 1, 2);
		String companyLocation = fib.getExcelData("Internshipletter", 1, 3);
		String internType = fib.getExcelData("Internshipletter", 1, 4);
		String startDate = fib.getExcelData("Internshipletter", 1, 5);
		String endDate = fib.getExcelData("Internshipletter", 1, 6);
		iForm.internLetter(salutation, internName, internId, companyLocation, internType, startDate, endDate);
		String internLetterAct = iForm.getInternshipCertificateText().getText();
		String internLetterExp = "INTERNSHIP";
		Assert.assertTrue(internLetterAct.contains(internLetterExp));
		Reporter.log("Internship certificate page is displayed", true);
		iLetter.getPrintIcon().click();
		WebElement headLetterCheckbox = iLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(headLetterCheckbox));
		headLetterCheckbox.click();
		iLetter.getPrintPreviewBtn().click();
		Reporter.log("Preview of Internship Letter is displayed--> Test is PASS", true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
	}
	@Test
	public void sendmailInternshipLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		h.getInternShipLink().click();
		InternshipLetterFormPage iForm = PageFactory.initElements(driver, InternshipLetterFormPage.class);
		InternshipLetterPage iLetter = PageFactory.initElements(driver, InternshipLetterPage.class);
		String internAct = iForm.getInternshipText().getText();
		String internExp = "Internship";
		Assert.assertTrue(internAct.contains(internExp));
		Reporter.log("Internship Letter form is displayed", true);
		String salutation = fib.getExcelData("Internshipletter", 1, 0);
		String internName = fib.getExcelData("Internshipletter", 1, 1);
		String internId = fib.getExcelData("Internshipletter", 1, 2);
		String companyLocation = fib.getExcelData("Internshipletter", 1, 3);
		String internType = fib.getExcelData("Internshipletter", 1, 4);
		String startDate = fib.getExcelData("Internshipletter", 1, 5);
		String endDate = fib.getExcelData("Internshipletter", 1, 6);
		iForm.internLetter(salutation, internName, internId, companyLocation, internType, startDate, endDate);
		String internLetterAct = iForm.getInternshipCertificateText().getText();
		String internLetterExp = "INTERNSHIP";
		Assert.assertTrue(internLetterAct.contains(internLetterExp));
		Reporter.log("Internship certificate page is displayed", true);
		String to = fib.getExcelData("Internshipletter", 1, 8);
		String cc = fib.getExcelData("Internshipletter", 1, 9);
		String subject = fib.getExcelData("Internshipletter", 1, 10);
		String content = fib.getExcelData("Internshipletter", 1, 11);
		String fileupload = fib.getExcelData("Internshipletter", 1, 12);
		iLetter.getSendMailBtn().click();
		WebElement toMail = iLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(toMail));
		toMail.sendKeys(to);
		WebElement ccMail = iLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(ccMail));
		ccMail.sendKeys(cc);
		iLetter.getSubjectTB().sendKeys(subject);
		iLetter.getContentTA().sendKeys(content);
		iLetter.getFilePathTB().sendKeys(fileupload);
		iLetter.getSendBtn().click();
		WebElement successMsg = iLetter.getSuccessMsg();
		wait.until(ExpectedConditions.elementToBeClickable(successMsg));
		Boolean success = successMsg.isDisplayed();
		Assert.assertTrue(success);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
}
