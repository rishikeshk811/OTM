package userModule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OTM.GenericUtils.ExcelUtils;
import com.OTM.GenericUtils.FileUtils;
import com.OTM.GenericUtils.JavaUtils;
import com.OTM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.SignInPage;
import com.mysql.cj.jdbc.Driver;

public class SignInUserTest {
 @Test
	public void signInWithValidCred() throws SQLException, IOException, InterruptedException {
/* String url =null;
String username =null;
String password =null;    

		Driver driver1=new Driver();
		
		DriverManager.registerDriver(driver1);
		
	
		
		// get the Connection 
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Welcome", "root", "root");
	   // create a Statement 
		java.sql.Statement state= con.createStatement();
		
	      String query    =   "Select * from Student ;";
	     // Execute Query  
	         ResultSet result= state.executeQuery(query);
	      
	      while(result.next()) {
	    	  if (result.getString(1).contains("Online_Tourism_Management_System")) {
	    		   url=result.getString(1);
	    		     username= result.getString(2);
	    		   password= result.getString(2);
	    		  System.out.println(url);
	    	      System.out.println(username);
	    	      System.out.println(password);
				
			}
	        	  
	    }     */
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
			//   wlib.waitForPageLoad(driver, 20);
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // no need to use this if we are using pageload time out 
/* now signing into the Application by using business logic that is already written in POM Class of signinpage		
	   driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
				  
				  
				    WebElement un= driver.findElement(By.xpath("//input[@placeholder='Enter your Email']"));
				  
				    un.sendKeys(username);
				  
				  
				    WebElement pwd=  driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']"));
				 
				    pwd.sendKeys(password);
				  driver.findElement(By.xpath("//input[@name='signin']")).click();    */
                          	SignInPage si =new SignInPage(driver);
	                    si.signInAsUser(username, password);
				  WebElement  validatechangePassword=  driver.findElement(By.xpath("//li[text()='Maven123@gmail.com']"));
				       String actual=validatechangePassword.getText();
				       Assert.assertEquals(actual, username);
				  
				  
				  
	}
}
