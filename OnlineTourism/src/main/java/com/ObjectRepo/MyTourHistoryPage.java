package com.ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyTourHistoryPage {

public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	
	
	// (//span[text()='Category']/preceding-sibling::span)[2]
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	WebElement shopbyElement= driver.findElement(By.xpath("//div[@class='Header___StyledCategoryMenu2-sc-19kl9m3-13 ibVaum']"));
	Actions actions=new Actions(driver);
	actions.moveToElement(shopbyElement).click().perform();
	  WebElement bakery=driver.findElement(By.xpath("//nav[@class='jsx-1259984711 flex text-medium']/descendant::a[text()='Bakery, Cakes & Dairy']"));
	
	actions.moveToElement(bakery).perform();
	WebElement frozenVeggies=driver.findElement(By.xpath("//nav[@class='jsx-1259984711 flex text-medium']/descendant::a[text()='Frozen Veggies & Snacks']"));
	actions.moveToElement(frozenVeggies).perform();
	
}
}
