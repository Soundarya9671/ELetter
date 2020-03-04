package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.tyss.eletter.genericlibrary.Utility;

public class InternshipLetterFormPage {

	Utility util = new Utility();

	@FindBy(id = "salutation")
	private WebElement salutationDD;

	@FindBy(id = "internName")
	private WebElement internNameTB;

	@FindBy(id = "internId")
	private WebElement internIdTB;

	@FindBy(id = "companyLocation")
	private WebElement companyLocationTB;

	@FindBy(id = "internType")
	private WebElement internTypeTB;

	@FindBy(id = "startDate")
	private WebElement startDateTB;

	@FindBy(id = "endDate")
	private WebElement endDateTB;

	@FindBy(id = "generate")
	private WebElement generateBtn;

	@FindBy(xpath = "//h3[text()='Internship Letter']")
	private WebElement internshipText;
	
	@FindBy(xpath = "//div[contains(text(),'Please')]")
	private WebElement errorMsg;

	public WebElement getErrorMsg() {
		return errorMsg;
	}

	public WebElement getInternshipText() {
		return internshipText;
	}

	@FindBy(xpath = "//u[text()='INTERNSHIP CERTIFICATE']")
	private WebElement internshipCertificateText;
	
	public WebElement getSalutationDD() {
		return salutationDD;
	}

	public WebElement getInternNameTB() {
		return internNameTB;
	}

	public WebElement getInternIdTB() {
		return internIdTB;
	}

	public WebElement getCompanyLocationTB() {
		return companyLocationTB;
	}

	public WebElement getInternTypeTB() {
		return internTypeTB;
	}

	public WebElement getStartDateTB() {
		return startDateTB;
	}

	public WebElement getEndDateTB() {
		return endDateTB;
	}

	public WebElement getGenerateBtn() {
		return generateBtn;
	}

	public WebElement getInternshipCertificateText() {
		return internshipCertificateText;
	}

	public void internLetter(String salutation, String internName, String internId, String companyLocation,String internType,
			String startDate, String endDate) {
		util.selectByVisibleText(salutationDD, salutation);
		internNameTB.sendKeys(internName);
		internIdTB.sendKeys(internId);
		companyLocationTB.sendKeys(companyLocation);
		internTypeTB.sendKeys(internType);
		startDateTB.sendKeys(startDate);
		endDateTB.sendKeys(endDate);
		generateBtn.click();

	}

	public void internLetter(String salutation, String internName, String internId, String companyLocation) {
		util.selectByVisibleText(salutationDD, salutation);
		internNameTB.sendKeys(internName);
		internIdTB.sendKeys(internId);
		companyLocationTB.sendKeys(companyLocation);
		generateBtn.click();

	}

}
