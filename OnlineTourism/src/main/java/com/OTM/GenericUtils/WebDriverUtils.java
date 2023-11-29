package com.OTM.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
/*
 * this method is used to maximize the browser 
 * @param driver
 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/*
	 *
	 * 
	 * this method is used to minimize the browser
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/*
	 * this method is used to wait until page load 
	 * @param driver 
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver,int sec) {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public void implicitWait(WebDriver driver,int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	public void  waitUntilElementtoBeVisible(WebDriver driver,WebElement element,int sec) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void dropdown(WebElement element,int index) {
		Select select =new Select(element);
				select.selectByIndex(index);
		
	}
			public void dropdown(WebElement element,String text) {
				Select select =new Select(element);
				select.selectByVisibleText(text);
		
		
		
	}	
		

	public void dropdown(String value,WebElement element) {
		Select select =new Select(element);
		select.selectByValue(value);

	}	
	public void rightClickonWebPage(WebDriver driver) {
		Actions act =new Actions(driver);
		act.contextClick().click().perform();
	}
		public void rightClickonWebElement(WebDriver driver,WebElement element) {
			Actions act =new Actions(driver);
			act.contextClick(element).click().perform();
		}
		public void doubleClick(WebDriver driver) {
			Actions act =new Actions(driver);
act.doubleClick().perform();
		}
		public void doubleClickOnElement(WebDriver driver,WebElement element) {
			Actions act =new Actions(driver);
			act.doubleClick(element);
		}
		public void mouseHOverOnWebElement(WebDriver driver,WebElement element) {
			Actions act =new Actions(driver);
act.moveToElement(element);
		}
		public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
			Actions act =new Actions(driver);
             act.dragAndDrop(src, dest);
		}
		public void keyPress(WebDriver driver) {
			Actions act =new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		public void keyPressEnter(WebDriver driver) throws AWTException {
			Robot rb =new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
		}
		public void keyReleaseEnter() throws Throwable {
			Robot rb =new Robot();
			rb.keyRelease(KeyEvent.VK_ENTER);
		}
		public void switchToWindow(WebDriver driver,String wid) {
			driver.switchTo().window(wid);
		}
		public void switchToFrame(WebDriver driver,int index) {
			driver.switchTo().frame(index);
		}
		
		public void switchToFrame(WebDriver driver,String nameorId) {
			driver.switchTo().frame(nameorId);
		}
		public void switchToFrame(WebDriver driver,WebElement address) {
			driver.switchTo().frame(address);
		}
		public void acceptAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		public void cancleAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		public String getTextFromAlert(WebDriver driver) {
			   String text=driver.switchTo().alert().getText();
			return text;
		}
		public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		}
		public void scrollAction(WebDriver driver,WebElement element) {
			JavascriptExecutor js =(JavascriptExecutor) driver;
			  int y=element.getLocation().getY();
		//	js.executeScript("arguments[0].scrollIntoView()", element);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
		
	public static void getScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver ;
		     File src=ts.getScreenshotAs(OutputType.FILE);
		     File dest =new File("./ScreenShots"+screenShotName+".png");
		  
		     FileUtils.copyFile(src, dest); 
		     
		     
	}	
		
		
		
		
		
		
		
	
}
