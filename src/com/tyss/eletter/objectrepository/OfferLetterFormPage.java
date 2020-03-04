package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.eletter.genericlibrary.Utility;

public class OfferLetterFormPage {

	Utility util = new Utility();
	
	@FindBy(xpath = "//h3[text()='Offer Letter']")
	private WebElement offerLetterText;

	@FindBy(id = "salutation")
	private WebElement salutationDd;

	@FindBy(id = "employeeName")
	private WebElement employeeNameTB;

	@FindBy(id = "fatherName")
	private WebElement fatherNameTB;

	@FindBy(id = "designation")
	private WebElement designationTB;

	@FindBy(id = "offerValidity")
	private WebElement offerValidityTB;

	@FindBy(id = "address")
	private WebElement addressTA;

	@FindBy(id = "genrate")
	private WebElement generateBtn;
	
	@FindBy(xpath = "//strong[text()='Chandana']")
	private WebElement editNameText;

	@FindBy(id = "age")
	private WebElement ageTB;

	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private WebElement errorMsg;
	
	@FindBy(id = "salary")
	private WebElement salaryTB;
	
	@FindBy(id = "companyLocation")
	private WebElement companyLocationTB;

	public WebElement getOfferLetterText() {
		return offerLetterText;
	}

	public WebElement getSalaryTB() {
		return salaryTB;
	}

	public WebElement getCompanyLocationTB() {
		return companyLocationTB;
	}

	public WebElement getSalutationDd() {
		return salutationDd;
	}
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getEmployeeNameTB() {
		return employeeNameTB;
	}

	public WebElement getDesignationTB() {
		return designationTB;
	}

	public WebElement getofferValidityTB() {
		return offerValidityTB;
	}

	public WebElement getAddressTA() {
		return addressTA;
	}

	public WebElement getGenerateBtn() {
		return generateBtn;
	}

	public WebElement getEditNameText() {
		return editNameText;
	}

	public WebElement getFatherNameTB() {
		return fatherNameTB;
	}

	public WebElement getAgeTB() {
		return ageTB;
	}

	public void offerLetter(String salutation, String employeeName, String fatherName,String designation,
			String companyLocation,String salary, String offervalidity, String age, String address) {
		util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		fatherNameTB.sendKeys(fatherName);
		designationTB.sendKeys(designation);
		companyLocationTB.sendKeys(companyLocation);
		salaryTB.sendKeys(salary);
		offerValidityTB.sendKeys(offervalidity);
		ageTB.sendKeys(age);
		addressTA.sendKeys(address);
		generateBtn.click();
	}

	public void offerLetter(String salutation, String employeeName, String fatherName,String designation,
			String companyLocation,String salary, String age, String address) {
		util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		fatherNameTB.sendKeys(fatherName);
		designationTB.sendKeys(designation);
		companyLocationTB.sendKeys(companyLocation);
		salaryTB.sendKeys(salary);
		ageTB.sendKeys(age);
		generateBtn.click();
	}
}
