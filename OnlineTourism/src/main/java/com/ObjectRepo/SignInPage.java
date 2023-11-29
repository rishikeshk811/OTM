package com.ObjectRepo;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OTM.GenericUtils.FileUtils;

public class SignInPage {

	//declaration 
	
	@FindBy(xpath = "//a[text()='/ Sign In']")
	private WebElement signInUser;
	

	
	@FindBy(xpath ="//input[@placeholder='Enter your Email']")
	private WebElement emailtexField ;
	
	@FindBy(xpath ="//input[@placeholder='Password' and @id='password']")
	private WebElement passwordTextFld;

	@FindBy(xpath ="//input[@name='signin']")
	private WebElement signInButton ;
	
	@FindBy(linkText = "Sign Up")
	private WebElement signUpLink;
	
	@FindBy(xpath = "//input[@value='CREATE ACCOUNT']")
	private WebElement createAccountBtn ;
	// initialization 
	public  SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// UtiliZation
	public void signInAsUser(String username,String password) throws IOException, InterruptedException {
		signInUser.click();
		emailtexField.sendKeys(username);
		Thread.sleep(3000);
		passwordTextFld.sendKeys(password);
		signInButton.click();
		
	}
	public void clickOnSignUPLink() {
		
		signUpLink.click();

	}
	public void signUpToApplication() {
		
	}
	public void clickOnCreateAccountButton() {
	
		createAccountBtn.click();
	
	}
}
