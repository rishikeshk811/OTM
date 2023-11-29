package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

public class ChangePasswordPage {

	public WebElement getCurrentPasswordTextFld() {
		return currentPasswordTextFld;
	}


	public WebElement getNewPassElementTextFld() {
		return newPassElementTextFld;
	}


	public WebElement getConfirmPasswordTextFld() {
		return confirmPasswordTextFld;
	}


	public WebElement getChangeButton() {
		return changeButton;
	}


	@FindBy(id = "exampleInputPassword1")
	private WebElement currentPasswordTextFld ;
	
	@FindBy(id = "newpassword")
	private WebElement newPassElementTextFld ;
	
	@FindBy(id = "confirmpassword")
	private WebElement confirmPasswordTextFld   ;
	
	@FindBy(xpath = "//button[text()='Change']")
	private WebElement changeButton;
	
	
	@FindBy(xpath = "//li[text()='Maven123@gmail.com']")
	private WebElement newLoginConfirmatiinText ;
	
	
public ChangePasswordPage (WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getNewLoginConfirmatiinText() {
	return newLoginConfirmatiinText;
}	


}
