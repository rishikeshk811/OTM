package com.OTM.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.HomePage;
import com.ObjectRepo.SignInPage;

public class BaseClass {
	
	         FileUtils flib =new FileUtils();
				ExcelUtils Elib =new ExcelUtils();
				 WebDriverUtils wlib =new WebDriverUtils();
			   DatabaseUtils dlib    = new DatabaseUtils();
			   WebDriver driver;
   protected static WebDriver ssDriver ;

			
			
			
			
			
			
@BeforeSuite
	public void config_BS() throws Throwable {
		
		dlib.connectDB();
	}

    @Parameters("BROWSER")
	@BeforeClass
	public void config_BC(String BROWSER ) throws IOException {
	
	   //     String BROWSER=   flib.readDataFromPropertyFile("Browser");
	              if (BROWSER.equalsIgnoreCase("chrome")) {
					driver=new ChromeDriver();
				}
	              else if(BROWSER.equalsIgnoreCase("edge")) {
					driver=new EdgeDriver();
				}
	            ssDriver=driver;
	           wlib.maximizeWindow(driver);
	           wlib.implicitWait(driver, 15);
	         
	}
	
	@BeforeMethod
	public void cofig_BM() throws IOException, InterruptedException {
	    String url=	flib.readDataFromPropertyFile("url");
	   String username= flib.readDataFromPropertyFile("Username");
	   String password= flib.readDataFromPropertyFile("Password");
	   driver.get(url);
       SignInPage pg  =new SignInPage(driver);
       pg.signInAsUser(username, password);    
		
	}
	@AfterMethod
public void cofig_AM() {
		HomePage hp =new  HomePage(driver);
		hp.clickOnLogout();
	}
	
	@AfterClass
public void cofig_AC() {
		driver.quit();
	}
	@AfterSuite
	public void config_AS() throws SQLException {
		
	dlib.disconnectDB();
		
		
		
	}
}
