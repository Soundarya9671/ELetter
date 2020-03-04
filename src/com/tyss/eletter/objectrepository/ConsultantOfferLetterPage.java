package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultantOfferLetterPage {
	
	@FindBy(xpath = "//img[contains(@src,'data') and contains(@style,'border-radius')]")
	private WebElement printIcon;

	@FindBy(xpath = "//button[text()='Print Preview']")
	private WebElement printPreviewBtn;

	@FindBy(id = "inlineCheckbox1")
	private WebElement headerLetterCb;

	@FindBy(xpath = "//button[text()='Send Mail']")
	private WebElement sendMailBtn;

	@FindBy(id = "to")
	private WebElement toTB;

	@FindBy(id = "cc")
	private WebElement ccTB;

	@FindBy(id = "subject")
	private WebElement subjectTB;

	@FindBy(id = "content")
	private WebElement contentTA;

	@FindBy(id = "myInput")
	private WebElement filePathTB;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement sendBtn;

	public WebElement getSendBtn() {
		return sendBtn;
	}

	@FindBy(xpath = "//div[text()='Email sent successfully']")
	private WebElement successMsg;

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public WebElement getHeaderLetterCb() {
		return headerLetterCb;
	}

	public WebElement getPrintIcon() {
		return printIcon;
	}

	public WebElement getSendMailBtn() {
		return sendMailBtn;
	}

	public WebElement getToTB() {
		return toTB;
	}

	public WebElement getCcTB() {
		return ccTB;
	}

	public WebElement getSubjectTB() {
		return subjectTB;
	}

	public WebElement getContentTA() {
		return contentTA;
	}

	public WebElement getFilePathTB() {
		return filePathTB;
	}

	public WebElement getPrintPreviewBtn() {
		return printPreviewBtn;
	}

	public WebElement getprintIcon() {
		return printIcon;
	}
}
