package userModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.compress.harmony.pack200.CpBands;
import org.apache.poi.hpsf.HPSFException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.webaudio.model.AudioListenerWillBeDestroyed;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.OTM.GenericUtils.BaseClass;
import com.OTM.GenericUtils.ExcelUtils;
import com.OTM.GenericUtils.FileUtils;
import com.OTM.GenericUtils.JavaUtils;
import com.OTM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.ChangePasswordPage;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.SignInPage;
   
public class ChangePasswordTest extends BaseClass {
	static WebDriver driver;
@Test
	public void changePassword() throws IOException, InterruptedException {
/*	FileUtils flib =new FileUtils();
	ExcelUtils Elib =new ExcelUtils();
	 WebDriverUtils wlib =new WebDriverUtils();
	 JavaUtils jlib =new JavaUtils();
	
	     String username= flib.readDataFromPropertyFile("Username");
	        String url=  flib.readDataFromPropertyFile("url");
	         String password= flib.readDataFromPropertyFile("Password");
	   String browser     =  flib.readDataFromPropertyFile("Browser");
	      String newPass=   flib.readDataFromPropertyFile("newPassword");
	      
		   driver=new ChromeDriver();
		 wlib.maximizeWindow(driver);
		   driver.get(url);  
		    wlib.implicitWait(driver, 15);
		    SignInPage si  =new SignInPage(driver);
		   si.signInAsUser(username, password);  */
	 WebDriverUtils wlib =new WebDriverUtils();
	 SignInPage si  =new SignInPage(driver);
	FileUtils flib =new FileUtils();
	  String username= flib.readDataFromPropertyFile("Username");
	     String password= flib.readDataFromPropertyFile("Password");
	     String newPass=   flib.readDataFromPropertyFile("newPassword");
		HomePage hp =new HomePage(driver); 
			  hp.clickOnChangePassword();
			     ChangePasswordPage cp =new ChangePasswordPage(driver);
	Thread.sleep(3000);
	
		wlib.scrollAction(driver, cp.getChangeButton());
	/*	   int changeY=changeButton.getRect().getY();
		   JavascriptExecutor js =(JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,"+changeY+")");   */
  
       cp.getCurrentPasswordTextFld().sendKeys(password);
         cp.getNewPassElementTextFld().sendKeys(newPass);
     cp.getConfirmPasswordTextFld().sendKeys(newPass);
 	Thread.sleep(3000);

 cp.getChangeButton().click();
     WebElement    validateStatement= driver.findElement(By.xpath("//div[@class='succWrap']"));
       String actualText= validateStatement.getText();

Assert.assertEquals(actualText, "SUCCESS:Your Password succesfully changed");

   hp.clickOnLogout();//logOUt
   si.signInAsUser(username, newPass);
   wlib.waitUntilElementtoBeVisible(driver, cp.getNewLoginConfirmatiinText(), 30);

	  
      String actual= cp.getNewLoginConfirmatiinText().getText();
   
   
  
   Assert.assertEquals(actual, username);
 
      
   
	}
}
