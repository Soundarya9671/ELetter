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
import com.tyss.eletter.objectrepository.ExitLetterFormPage;
import com.tyss.eletter.objectrepository.ExitLetterPage;
import com.tyss.eletter.objectrepository.HomePage;

@Listeners(com.tyss.eletter.genericlibrary.ListenersImplement.class)
public class ExitLetter extends Base {
	@Test
	public void editExitLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ExitLetterFormPage eForm = PageFactory.initElements(driver, ExitLetterFormPage.class);
		ExitLetterPage eLetter = PageFactory.initElements(driver, ExitLetterPage.class);
		h.getExitLink().click();
		String exitAct = eForm.getExitText().getText();
		String exitExp = "Exit";
		Assert.assertTrue(exitAct.contains(exitExp));
		Reporter.log("Exit letter form is displayed", true);
		String salutation = fib.getExcelData("Exitletter", 2, 0);
		String employeeName = fib.getExcelData("Exitletter", 1, 1);
		String designation = fib.getExcelData("Exitletter", 1, 2);
		String companyLocation = fib.getExcelData("Exitletter", 1, 3);
		String joinDate = fib.getExcelData("Exitletter", 1, 9);
		String exitDate = fib.getExcelData("Exitletter", 1, 10);
		String salaryDeduction = fib.getExcelData("Exitletter", 1, 4);
		String deduction = fib.getExcelData("Exitletter", 1, 5);
		String salary = fib.getExcelData("Exitletter", 1, 6);
		String fundDue = fib.getExcelData("Exitletter", 1, 7);
		eForm.exitForm(salutation, employeeName,designation, companyLocation, joinDate, exitDate, salaryDeduction, deduction,
				salary, fundDue);
		eForm.getGenerateBtn().click();
		String exitAgreementAct = eForm.getExitAgreementText().getText();
		String exitAgreementExp = "EXIT";
		Assert.assertTrue(exitAgreementAct.contains(exitAgreementExp));
		Reporter.log("Exit Agreement page is displayed", true);
		eLetter.getEditBtn().click();
		String editname = fib.getExcelData("Exitletter", 1, 11);
		eForm.getEmployeeNameTB().sendKeys(Keys.chord(Keys.CONTROL, "a"), editname);
		eForm.getGenerateBtn().click();
		String editedNameAct = eForm.getEditNameText().getText();
		String editedNameExp = "Chandana";
		Assert.assertTrue(editedNameAct.contains(editedNameExp));
		Reporter.log("Modified details are updated --> Test is PASS",true);
	}
	@Test
	public void previewExitLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ExitLetterFormPage eForm = PageFactory.initElements(driver, ExitLetterFormPage.class);
		ExitLetterPage eLetter = PageFactory.initElements(driver, ExitLetterPage.class);
		h.getExitLink().click();
		String exitAct = eForm.getExitText().getText();
		String exitExp = "Exit";
		Assert.assertTrue(exitAct.contains(exitExp));
		Reporter.log("Exit letter form is displayed", true);
		String salutation = fib.getExcelData("Exitletter", 2, 0);
		String employeeName = fib.getExcelData("Exitletter", 1, 1);
		String designation = fib.getExcelData("Exitletter", 1, 2);
		String companyLocation = fib.getExcelData("Exitletter", 1, 3);
		String joinDate = fib.getExcelData("Exitletter", 1, 9);
		String exitDate = fib.getExcelData("Exitletter", 1, 10);
		String salaryDeduction = fib.getExcelData("Exitletter", 1, 4);
		String deduction = fib.getExcelData("Exitletter", 1, 5);
		String salary = fib.getExcelData("Exitletter", 1, 6);
		String fundDue = fib.getExcelData("Exitletter", 1, 7);
		eForm.exitForm(salutation, employeeName, designation, companyLocation, joinDate, exitDate, salaryDeduction,
				deduction, salary, fundDue);
		eForm.getGenerateBtn().click();
		String exitAgreementAct = eForm.getExitAgreementText().getText();
		String exitAgreementExp = "EXIT";
		Assert.assertTrue(exitAgreementAct.contains(exitAgreementExp));
		Reporter.log("Exit Agreement page is displayed", true);
		eLetter.getPrintIcon().click();
		WebElement checkBox = eLetter.getHeadLetterCb();
		wait.until(ExpectedConditions.elementToBeClickable(checkBox));
		checkBox.click();
		eLetter.getPrintPreviewBtn().click();
		Reporter.log("Preview of Exit Letter is displayed--> Test is PASS", true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
	}
	@Test
	public void sendMailExitLetterTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ExitLetterFormPage eForm = PageFactory.initElements(driver, ExitLetterFormPage.class);
		ExitLetterPage eLetter = PageFactory.initElements(driver, ExitLetterPage.class);
		h.getExitLink().click();
		String exitAct = eForm.getExitText().getText();
		String exitExp = "Exit";
		Assert.assertTrue(exitAct.contains(exitExp));
		Reporter.log("Exit letter form is displayed", true);
		String salutation = fib.getExcelData("Exitletter", 2, 0);
		String employeeName = fib.getExcelData("Exitletter", 1, 1);
		String designation = fib.getExcelData("Exitletter", 1, 2);
		String companyLocation = fib.getExcelData("Exitletter", 1, 3);
		String joinDate = fib.getExcelData("Exitletter", 1, 9);
		String exitDate = fib.getExcelData("Exitletter", 1, 10);
		String salaryDeduction = fib.getExcelData("Exitletter", 1, 4);
		String deduction = fib.getExcelData("Exitletter", 1, 5);
		String salary = fib.getExcelData("Exitletter", 1, 6);
		String fundDue = fib.getExcelData("Exitletter", 1, 7);
		eForm.exitForm(salutation, employeeName,designation, companyLocation, joinDate, exitDate, salaryDeduction, deduction,
				salary, fundDue);
		eForm.getGenerateBtn().click();
		String exitAgreementAct = eForm.getExitAgreementText().getText();
		String exitAgreementExp = "EXIT";
		Assert.assertTrue(exitAgreementAct.contains(exitAgreementExp));
		Reporter.log("Exit Agreement page is displayed", true);
		eLetter.getSendMailBtn().click();
		String toMail = fib.getExcelData("Exitletter", 1, 12);
		WebElement to = eLetter.getToTB();
		wait.until(ExpectedConditions.elementToBeClickable(to));
		to.sendKeys(toMail);
		String ccMail = fib.getExcelData("Exitletter", 1, 13);
		WebElement cc = eLetter.getCcTB();
		wait.until(ExpectedConditions.elementToBeClickable(cc));
		cc.sendKeys(ccMail);
		String subject = fib.getExcelData("Exitletter", 1, 14);
		eLetter.getSubjectTB().sendKeys(subject);
		String content = fib.getExcelData("Exitletter", 1, 15);
		eLetter.getContentTA().sendKeys(content);
	    String fileupload = fib.getExcelData("Exitletter", 1, 16);
	    eLetter.getFilePathTB().sendKeys(fileupload);
		eLetter.getSendBtn().click(); 
	    WebElement successMsg = eLetter.getSuccessMsg();
        wait.until(ExpectedConditions.elementToBeClickable(successMsg));
        Boolean success = successMsg.isDisplayed();
        Assert.assertTrue(success);
		Reporter.log("Mail sent successfully ---> Test is PASS", true);
	}
	@Test
	public void skippingMandatoryFieldTest() {
		HomePage h = PageFactory.initElements(driver, HomePage.class);
		ExitLetterFormPage eForm = PageFactory.initElements(driver, ExitLetterFormPage.class);
		h.getExitLink().click();
		String exitAct = eForm.getExitText().getText();
		String exitExp = "Exit";
		Assert.assertTrue(exitAct.contains(exitExp));
		Reporter.log("Exit letter form is displayed", true);
		String salutation = fib.getExcelData("Exitletter", 2, 0);
		String employeeName = fib.getExcelData("Exitletter", 1, 1);
		String designation = fib.getExcelData("Exitletter", 1, 2);
		String companyLocation = fib.getExcelData("Exitletter", 1, 3);
		String salaryDeduction = fib.getExcelData("Exitletter", 1, 4);
		String deduction = fib.getExcelData("Exitletter", 1, 5);
		String salary = fib.getExcelData("Exitletter", 1, 6);
		String fundDue = fib.getExcelData("Exitletter", 1, 7);
		eForm.exitForm(salutation, employeeName, designation, companyLocation, salaryDeduction, deduction, salary,
				fundDue);
		eForm.getGenerateBtn().click();
		String errorAct = eForm.getErrorMsg().getText();
		String errorExp = "Please";
		Assert.assertTrue(errorAct.contains(errorExp));
		Reporter.log("Cannot generate Exit Letter by skipping Joined date --> Test is PASS", true);
	}
}
