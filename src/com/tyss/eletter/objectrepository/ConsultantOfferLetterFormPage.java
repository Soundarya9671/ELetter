package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.eletter.genericlibrary.Utility;

public class ConsultantOfferLetterFormPage {
	Utility util = new Utility();

	@FindBy(id = "salutation")
	private WebElement salutationDD;

	@FindBy(id = "employeeName")
	private WebElement employeeNameTB;

	@FindBy(id = "designation")
	private WebElement designationTB;

	@FindBy(id = "companyLocation")
	private WebElement companyLocationTB;

	@FindBy(id = "noticePeriod")
	private WebElement noticePeriodTB;

	@FindBy(id = "joiningDate")
	private WebElement joiningDateTB;

	@FindBy(id = "reportingDate")
	private WebElement reportingDateTB;

	@FindBy(id = "generate")
	private WebElement generateBtn;

	@FindBy(xpath = "//h3[text()='Consultant Offer Letter']")
	private WebElement consultantOfferLetterText;

	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement editBtn;

	@FindBy(xpath = "//strong[contains(text(),'Dear')]")
	private WebElement editTxt;
	
	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private WebElement errorMsg;
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	public WebElement getEditTxt() {
		return editTxt;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

	public WebElement getSalutationDD() {
		return salutationDD;
	}

	public WebElement getEmployeeNameTB() {
		return employeeNameTB;
	}

	public WebElement getDesignationTB() {
		return designationTB;
	}

	public WebElement getCompanyLocationTB() {
		return companyLocationTB;
	}

	public WebElement getNoticePeriodTB() {
		return noticePeriodTB;
	}

	public WebElement getJoiningDateTB() {
		return joiningDateTB;
	}

	public WebElement getReportingDateTB() {
		return reportingDateTB;
	}

	public WebElement getGenerateBtn() {
		return generateBtn;
	}

	public WebElement getConsultantOfferLetterText() {
		return consultantOfferLetterText;
	}

	public void consultantOffer(String salutation, String employeeName, String designation, String companyLocation,
			String noticePeriod, String joinDate, String reportingDate) {
		util.selectByVisibleText(salutationDD, salutation);
		employeeNameTB.sendKeys(employeeName);
		designationTB.sendKeys(designation);
		companyLocationTB.sendKeys(companyLocation);
		noticePeriodTB.sendKeys(noticePeriod);
		joiningDateTB.sendKeys(joinDate);
		reportingDateTB.sendKeys(reportingDate);
		generateBtn.click();

	}
	public void consultantOffer(String salutation, String employeeName, String designation, String companyLocation,
			String noticePeriod) {
		util.selectByVisibleText(salutationDD, salutation);
		employeeNameTB.sendKeys(employeeName);
		designationTB.sendKeys(designation);
		companyLocationTB.sendKeys(companyLocation);
		noticePeriodTB.sendKeys(noticePeriod);
		generateBtn.click();
	}
}
