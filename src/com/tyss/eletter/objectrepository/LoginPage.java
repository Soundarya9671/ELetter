package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailTB;

	@FindBy(id = "password")
	private WebElement passwordTB;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String email,String password) {
		emailTB.sendKeys(email);
		passwordTB.sendKeys(password);
		loginBtn.submit();
	}
}
