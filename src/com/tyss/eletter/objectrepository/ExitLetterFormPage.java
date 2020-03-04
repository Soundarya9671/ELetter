package com.tyss.eletter.objectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tyss.eletter.genericlibrary.Utility;

public class ExitLetterFormPage {
	Utility util = new Utility();
	@FindBy(id = "salutation")
	private WebElement salutationDD;

	@FindBy(id = "employeeName")
	private WebElement employeeNameTB;
	
	@FindBy(id = "companyLocation")
	private WebElement companyLocationTB;

	@FindBy(id = "joiningDate")
	private WebElement joiningDateTB;
	
	@FindBy(id = "exitDate")
	private WebElement exitDateTB;
	
	@FindBy(id = "salaryDeduction")
	private WebElement salaryDeductionTB;
	
	@FindBy(id = "deductionTDS")
	private WebElement deductionTB;
	
	@FindBy(id = "salary")
	private WebElement salaryTB;
	
	@FindBy(id = "fundDue")
	private WebElement fundDueTB;
	
	@FindBy(id = "gratuity")
	private WebElement gratuityTB;

	@FindBy(id = "generate")
	private WebElement generateBtn;
	
	@FindBy(xpath = "//h3[text()='Exit Letter']")
	private WebElement exitText;
	
	@FindBy(xpath = "//u[text()='EXIT AGREEMENT']")
	private WebElement exitAgreementText;
	
	@FindBy(xpath = "//strong[text()='Chandana']")
	private WebElement editNameText;
	
	@FindBy(id = "designation")
	private WebElement designationTB;
	
	@FindBy(xpath="//div[contains(text(),'Please')]")
	private WebElement errorMsg;
			
	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getEditNameText() {
		return editNameText;
	}

	public WebElement getExitText() {
		return exitText;
	}

	public Utility getUtil() {
		return util;
	}

	public WebElement getExitAgreementText() {
		return exitAgreementText;
	}

	public WebElement getSalutationDD() {
		return salutationDD;
	}

	public WebElement getEmployeeNameTB() {
		return employeeNameTB;
	}

	public WebElement getCompanyLocationTB() {
		return companyLocationTB;
	}

	public WebElement getJoiningDateTB() {
		return joiningDateTB;
	}

	public WebElement getExitDateTB() {
		return exitDateTB;
	}

	public WebElement getSalaryDeductionTB() {
		return salaryDeductionTB;
	}

	public WebElement getDeductionTB() {
		return deductionTB;
	}

	public WebElement getSalaryTB() {
		return salaryTB;
	}

	public WebElement getFundDueTB() {
		return fundDueTB;
	}

	public WebElement getGratuityTB() {
		return gratuityTB;
	}
	
	public WebElement getGenerateBtn() {
		return generateBtn;
	}
	
	public WebElement getDesignationTB() {
		return designationTB;
	}
	
	public void exitForm(String salutation,String employeeName,String designation,String companyLocation,String joinDate,String exitDate,
			String salaryDeduction,String deduction, String salary,String fundDue) {
		util.selectByVisibleText(salutationDD, salutation);
		employeeNameTB.sendKeys(employeeName);
		designationTB.sendKeys(designation);
		companyLocationTB.sendKeys(companyLocation);
		joiningDateTB.sendKeys(joinDate);
		exitDateTB.sendKeys(exitDate);
		salaryDeductionTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),salaryDeduction);
		deductionTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),deduction);
		salaryTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),salary);
		fundDueTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),fundDue);
	}
	public void exitForm(String salutation,String employeeName,String designation,String companyLocation,
			String salaryDeduction,String deduction, String salary,String fundDue) {
		util.selectByVisibleText(salutationDD, salutation);
		employeeNameTB.sendKeys(employeeName);
		designationTB.sendKeys(designation);
		companyLocationTB.sendKeys(companyLocation);
		salaryDeductionTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),salaryDeduction);
		deductionTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),deduction);
		salaryTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),salary);
		fundDueTB.sendKeys(Keys.chord(Keys.CONTROL, "a"),fundDue);
	}
}
