package userModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.OTM.GenericUtils.ExcelUtils;
import com.OTM.GenericUtils.FileUtils;
import com.OTM.GenericUtils.JavaUtils;
import com.OTM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.SignInPage;
import com.mysql.cj.jdbc.Driver;

public class SignUPTest {

	
	public void signUpwithAllcred() throws Throwable {
		FileUtils flib =new FileUtils();
		ExcelUtils Elib =new ExcelUtils();
		 WebDriverUtils wlib =new WebDriverUtils();
		 JavaUtils jlib =new JavaUtils();
		
		     String username= flib.readDataFromPropertyFile("Username");
		        String url=  flib.readDataFromPropertyFile("url");
		         String password= flib.readDataFromPropertyFile("Password");
		   String browser     =  flib.readDataFromPropertyFile("Browser");
		
		
		WebDriver driver=new ChromeDriver();
	wlib.maximizeWindow(driver);
 driver.get(url);
	wlib.implicitWait(driver, 20);
		SignInPage si =new SignInPage(driver);
		si.clickOnSignUPLink();
		Thread.sleep(3000);
		Elib.readMultipleData("signUPdata", driver);
		
		si.clickOnCreateAccountButton();
		
	}
}
