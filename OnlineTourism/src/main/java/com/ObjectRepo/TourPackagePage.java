package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TourPackagePage {

	
	@FindBy(id = "datepicker")
	private WebElement fromDate;
	
	@FindBy(id = "datepicker1")
	private WebElement toDate ;
	
	@FindBy(xpath = "//input[@name='comment']")
	private WebElement commentTextfld ;
	
	@FindBy(xpath = "//button[@name='submit2']")
	private WebElement bookLink ;

	public WebElement getFromDate() {
		return fromDate;
	}

	public WebElement getToDate() {
		return toDate;
	}

	public WebElement getCommentTextfld() {
		return commentTextfld;
	}

	public WebElement getBookLink() {
		return bookLink;
	}
	
	public  TourPackagePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBooklink() {
		bookLink.click();
	}
	public void clickOnFromDateLink() {
		fromDate.click();
	}
	public void clickOnToDateLink() {
		toDate.click();
	}
}
