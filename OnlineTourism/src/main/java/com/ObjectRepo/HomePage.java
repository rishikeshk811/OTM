package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath = "//a[text()=' / Write Us ']")
	private WebElement writeusElement;
	
	
	@FindBy(xpath = "//a[text()='My Tour History']")
	private WebElement tourHistoryLInk ;
	
	@FindBy(xpath = "//a[text()='My Profile']")
	private WebElement myProflileLink ;
	
	
	@FindBy(xpath = "//a[text()='Change Password']")
	private WebElement changePasswordLink ;
	
	public WebElement getWriteusElement() {
		return writeusElement;
	}

	public WebElement getTourHistoryLInk() {
		return tourHistoryLInk;
	}

	public WebElement getMyProflileLink() {
		return myProflileLink;
	}

	public WebElement getChangePasswordLink() {
		return changePasswordLink;
	}

	public WebElement getIssueTicketLink() {
		return issueTicketLink;
	}

	public WebElement getLogoutLInk() {
		return logoutLInk;
	}

	public WebElement getTourPackagesLinK() {
		return tourPackagesLinK;
	}

	@FindBy(linkText = "Issue Tickets")
	private WebElement issueTicketLink ;
	
	@FindBy(linkText = "/ Logout")
	private WebElement logoutLInk ;
	
	@FindBy(linkText = "Tour Packages")
	private WebElement tourPackagesLinK ;
	
	
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogout() {
		logoutLInk.click();
	}
	public void clickmytourHistory() {
		tourHistoryLInk.click();
	}
	 public void clickOnChangePassword() {
		 changePasswordLink.click();
	}
	public void clickOnIssueTickets() {
		issueTicketLink.click();
	}
	
	public void clickOnMyprofile() {
		myProflileLink.click();
	}
	
	public void clickOnWriteUs() {
		writeusElement.click();
	}
	
	public void clickOnTourPakcageLink() {
		tourPackagesLinK.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
