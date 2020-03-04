package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.eletter.genericlibrary.Utility;

public class ITPolicyLetterFormPage {

	Utility util = new Utility();

	@FindBy(xpath = "//h3[text()='IT Policy Letter']")
	private WebElement itPolicyLetterText;

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

	public WebElement getITPolicyLetterText() {
		return itPolicyLetterText;
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

	public void itPolicy(String salutation, String employeeName, String employeeId, String designation, String joinDate,
			String address) {
		util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		employeeIdTB.sendKeys(employeeId);
		designationTB.sendKeys(designation);
		joiningDateTB.sendKeys(joinDate);
		addressTA.sendKeys(address);
		generateBtn.click();
	}

	public void itPolicy(String salutation, String employeeName, String employeeId, String designation) {
		util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		employeeIdTB.sendKeys(employeeId);
		designationTB.sendKeys(designation);
		generateBtn.click();
	}

}
