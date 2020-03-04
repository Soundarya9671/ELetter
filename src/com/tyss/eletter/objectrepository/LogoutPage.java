package com.tyss.eletter.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	@FindBy(xpath="//a[contains(@class,'link dropdown')]")
    private WebElement profileDD;

	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;

	public WebElement getProfileDD() {
		return profileDD;
	}

	public WebElement getLogOutBtn() {
		return logoutBtn;
	}
	
	public void getLogout() {
		profileDD.click();
		logoutBtn.click();
	}
}
