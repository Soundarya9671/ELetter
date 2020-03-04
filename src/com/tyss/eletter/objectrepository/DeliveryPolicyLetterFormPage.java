package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.eletter.genericlibrary.Utility;

public class DeliveryPolicyLetterFormPage {
	
	Utility util = new Utility();
	
	@FindBy(xpath = "//h3[text()='Delivery Policy Letter']")
	private WebElement deliveryPolicyLetterText;

	@FindBy(id = "salutation")
	private WebElement salutationDd;

	@FindBy(id = "employeeName")
	private WebElement employeeNameTB;

	@FindBy(id = "employeeId")
	private WebElement employeeIdTB;

	@FindBy(id = "fatherName")
	private WebElement fatherNameTB;

	@FindBy(id = "designation")
	private WebElement designationTB;

	@FindBy(id = "joiningDate")
	private WebElement joiningDateTB;

	@FindBy(id = "address")
	private WebElement addressTA;

	@FindBy(id = "generate")
	private WebElement generateBtn;

	@FindBy(xpath = "//span[text()='Chandana']")
	private WebElement editNameText;

	@FindBy(id = "age")
	private WebElement ageTB;

	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private WebElement errorMsg;
	
	public WebElement getDeliveryPolicyLetterText() {
		return deliveryPolicyLetterText;
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

	public WebElement getFatherNameTB() {
		return fatherNameTB;
	}

	public WebElement getAgeTB() {
		return ageTB;
	}

	public void deliveryPolicy(String salutation, String employeeName, String fatherName, String employeeId,
			String designation, String joinDate, String age, String address) {
		util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		employeeIdTB.sendKeys(employeeId);
		fatherNameTB.sendKeys(fatherName);
		designationTB.sendKeys(designation);
		joiningDateTB.sendKeys(joinDate);
		ageTB.sendKeys(age);
		addressTA.sendKeys(address);
		generateBtn.click();
	}

	public void deliveryPolicy(String salutation, String employeeName, String fatherName, String employeeId,
			String designation, String age) {
		util.selectByVisibleText(salutationDd, salutation);
		employeeNameTB.sendKeys(employeeName);
		fatherNameTB.sendKeys(fatherName);
		employeeIdTB.sendKeys(employeeId);
		designationTB.sendKeys(designation);
		ageTB.sendKeys(age);
		generateBtn.click();
	}
}
