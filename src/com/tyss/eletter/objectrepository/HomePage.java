package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(linkText = "Exit Letter")
	private WebElement exitLink;
	
	@FindBy(linkText = "HR Policy Letter")
	private WebElement hrPolicyLink;
	
	@FindBy(linkText = "Internship Letter")
	private WebElement internShipLink;
	
	@FindBy(linkText = "IT Policy Letter")
	private WebElement itPolicyLink;
	
	@FindBy(linkText = "Offer Letter")
	private WebElement offerLink;
	
	@FindBy(linkText = "Project Policy Letter")
	private WebElement projectPolicyLink;
	
	@FindBy(linkText = "Salary Revision Letter")
	private WebElement salaryRevisionLink;
	
	@FindBy(linkText = "BD Policy Letter")
	private WebElement bdPolicyLink;
	
	@FindBy(linkText = "Consultant Offer Letter")
	private WebElement consultantOfferLink;
	
	@FindBy(linkText = "Delivery Policy Letter")
	private WebElement deliveryPolicyLink;

	public WebElement getExitLink() {
		return exitLink;
	}

	public WebElement getHrPolicyLink() {
		return hrPolicyLink;
	}

	public WebElement getInternShipLink() {
		return internShipLink;
	}

	public WebElement getItPolicyLink() {
		return itPolicyLink;
	}

	public WebElement getOfferLink() {
		return offerLink;
	}

	public WebElement getProjectPolicyLink() {
		return projectPolicyLink;
	}

	public WebElement getSalaryRevisionLink() {
		return salaryRevisionLink;
	}

	public WebElement getBdPolicyLink() {
		return bdPolicyLink;
	}

	public WebElement getConsultantOfferLink() {
		return consultantOfferLink;
	}

	public WebElement getDeliveryPolicyLink() {
		return deliveryPolicyLink;
	}
	
}
