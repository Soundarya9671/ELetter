package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.eletter.genericlibrary.Utility;

public class HRPolicyLetterFormPage {

	Utility util = new Utility();

	@FindBy(xpath = "//h3[text()='HR Policy Letter']")
	private WebElement hrPolicyLetterText;

	@FindBy(id = "salutation")
	private WebElement salutationDd;

	@FindBy(id = "employeeName")
	private WebElement employeeNameTB;

	@FindBy(id = "employeeId")
	private WebElement employeeIdTB;

	@FindBy(id = "designation")
	private WebElement designationTB;

	@FindBy(id = "joiningDate")
	private WebElement joiningDateTB;

	@FindBy(id = "address")
	private WebElement addressTA;

	@FindBy(id = "generate")
	private WebElement generateBtn;

	@FindBy(xpath = "//strong[text()='Chandana']")
	private WebElement editNameText;

	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private WebElement errorMsg;

	public Utility getUtil() {
		return util;
	}

	public WebElement getHrPolicyLetterText() {
		return hrPolicyLetterText;
	}

	public WebElement getSalutationDd() {
		return salutationDd;
	}

	public WebElement getEmployeeNameTB() {
		return employeeNameTB;
	}

	public WebElement getEmployeeIdTB() {
		return employeeIdTB;
	}

	public WebElement getDesignationTB() {
		return designationTB;
	}

	public WebElement getJoiningDateTB() {
		return joiningDateTB;
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

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public void hrLetter(String salutation, String employeeName, String employeeId, String designation, String joinDate,
			String address) {
      util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		employeeIdTB.sendKeys(employeeId);
		designationTB.sendKeys(designation);
		joiningDateTB.sendKeys(joinDate);
		addressTA.sendKeys(address);
		generateBtn.click();
	}
	public void hrLetter(String salutation, String employeeName, String employeeId, String designation, 
			String address) {
      util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		employeeIdTB.sendKeys(employeeId);
		designationTB.sendKeys(designation);
		addressTA.sendKeys(address);
		generateBtn.click();
	}
}
