package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalaryRevisionFormPage {
	@FindBy(id = "employeeName")
	private WebElement employeeNameTB;

	@FindBy(id = "employeeId")
	private WebElement employeeIdTB;

	@FindBy(id = "incrementInEffectDate")
	private WebElement incrementInEffectDateTB;

	@FindBy(id = "salaryIncrementFrom")
	private WebElement salaryIncrementFromTB;

	@FindBy(id = "salaryIncrementTo")
	private WebElement salaryIncrementToTB;

	@FindBy(id = "generate")
	private WebElement generateBtn;

	@FindBy(xpath = "//h3[text()='Salary Revision Letter']")
	private WebElement salaryRevisionLetterText;

	@FindBy(xpath = "//strong[text()='Chandana']")
	private WebElement editText;

	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private WebElement errorMsg;

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getEmployeeNameTB() {
		return employeeNameTB;
	}

	public WebElement getEmployeeIdTB() {
		return employeeIdTB;
	}

	public WebElement getIncrementInEffectDateTB() {
		return incrementInEffectDateTB;
	}

	public WebElement getSalaryIncrementFromTB() {
		return salaryIncrementFromTB;
	}

	public WebElement getSalaryIncrementToTB() {
		return salaryIncrementToTB;
	}

	public WebElement getGenerateBtn() {
		return generateBtn;
	}

	public WebElement getSalaryRevisionLetterText() {
		return salaryRevisionLetterText;
	}

	public WebElement getEditText() {
		return editText;
	}

	public void salaryRevision(String employeeName, String employeeId, String incrementInEffect, String incrementFrom,
			String incrementTo){
       employeeNameTB.sendKeys(employeeName);
       getEmployeeIdTB().sendKeys(employeeId);
       incrementInEffectDateTB.sendKeys(incrementInEffect);
       salaryIncrementFromTB.sendKeys(incrementFrom);
       salaryIncrementToTB.sendKeys(incrementTo);
       generateBtn.click();
	}
	public void salaryRevision(String employeeName, String employeeId, String incrementInEffect){
		employeeNameTB.sendKeys(employeeName);
		getEmployeeIdTB().sendKeys(employeeId);
		incrementInEffectDateTB.sendKeys(incrementInEffect);
		generateBtn.click();
	}

}
