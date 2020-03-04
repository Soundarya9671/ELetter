package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.eletter.genericlibrary.Utility;

public class BDPolicyLetterFormPage {
	Utility util = new Utility();
	@FindBy(id = "salutation")
	private WebElement salutationDD;

	@FindBy(id = "employeeName")
	private WebElement employeeNameTB;

	@FindBy(id = "fatherName")
	private WebElement fatherNameTB;

	@FindBy(id = "employeeId")
	private WebElement employeeIdTB;

	@FindBy(id = "designation")
	private WebElement designationTB;

	@FindBy(id = "joiningDate")
	private WebElement joiningDateTB;

	@FindBy(id = "age")
	private WebElement ageTB;

	@FindBy(id = "address")
	private WebElement addressTA;

	@FindBy(id = "generate")
	private WebElement generateBtn;

	@FindBy(xpath = "//h3[text()='BD Policy Letter']")
	private WebElement bdPolicyLetterText;

	@FindBy(xpath = "//span[text()='Chandana']")
	private WebElement editNameText;
	
	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private WebElement errorMsg;
	
	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getSalutationDD() {
		return salutationDD;
	}

	public WebElement getEmployeeNameTB() {
		return employeeNameTB;
	}

	public WebElement getFatherNameTB() {
		return fatherNameTB;
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

	public WebElement getAgeTB() {
		return ageTB;
	}

	public WebElement getAddressTA() {
		return addressTA;
	}

	public WebElement getGenerateBtn() {
		return generateBtn;
	}

	public WebElement getBdPolicyLetterText() {
		return bdPolicyLetterText;
	}

	public WebElement getEditNameText() {
		return editNameText;
	}

	public void bdPolicy(String salutation, String employeeName, String fatherName, String employeeId,
		String designation, String joinDate, String age, String address) {
		util.selectByVisibleText(salutationDD, salutation);
		employeeNameTB.sendKeys(employeeName);
		fatherNameTB.sendKeys(fatherName);
		employeeIdTB.sendKeys(employeeId);
		designationTB.sendKeys(designation);
		joiningDateTB.sendKeys(joinDate);
		ageTB.sendKeys(age);
		addressTA.sendKeys(address);
		generateBtn.click();
	}

	public void bdPolicy(String salutaion, String employeeName, String fatherName, String employeeId,
		String designation) {
		util.selectByVisibleText(salutationDD, salutaion);
		employeeNameTB.sendKeys(employeeName);
		fatherNameTB.sendKeys(fatherName);
		employeeIdTB.sendKeys(employeeId);
		designationTB.sendKeys(designation);
		generateBtn.click();
	}
}
