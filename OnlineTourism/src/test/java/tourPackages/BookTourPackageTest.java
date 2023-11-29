package tourPackages;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OTM.GenericUtils.DatabaseUtils;
import com.OTM.GenericUtils.ExcelUtils;
import com.OTM.GenericUtils.FileUtils;
import com.OTM.GenericUtils.IpathConstants;
import com.OTM.GenericUtils.JavaUtils;
import com.OTM.GenericUtils.WebDriverUtils;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Schema.CreateCollectionOptions;

public class BookTourPackageTest {

	@Test
	public void bookTour() throws Throwable 
	{
	try {
		
		/*	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pObje=new Properties();
		    pObje.load(fis);
		       String broweser= pObje.getProperty("Browser");
		       String url    = pObje.getProperty("url");
		       String username = pObje.getProperty("Username");
		    
		       String password   =     pObje.getProperty("Password");    */
		FileUtils flib =new FileUtils();
		ExcelUtils Elib =new ExcelUtils();
		 WebDriverUtils wlib =new WebDriverUtils();
		 JavaUtils jlib =new JavaUtils();
	   DatabaseUtils dlib    = new DatabaseUtils();
		 String urlString=null;
		String username=null;
		String password =null;
	       String usernam=  flib.readDataFromPropertyFile("Username");
	       String url=  flib.readDataFromPropertyFile("url");
	     
	       
	       String pass=  flib.readDataFromPropertyFile("Password");
			
			 Connection con = dlib.connectDB(); 
		       
		              Statement state=con.createStatement();
		            String query=  " Create table SignInData (Url Varchar(80),Username varchar(30),Password varchar(30) );";
		            int result=  state.executeUpdate(query);
		            if (result==0) {
						System.out.println("table Created ");
					}
		               else {
						System.out.println("table not Created ");   
					}
		              
		            
		            
		       
		            
		             Statement state2=   con.createStatement();
		              String query2=   " insert into SignInData values('"+url+"','"+usernam+"','"+pass+"');";
		              
		              
		              
		              
		              
		              
		              
		                   int result2= state2.executeUpdate(query2);
		                   if (result2>=1) {
							System.out.println("data inserted successfully ");
						}
		                   else {
							System.out.println("data not inserted ");
						}
		                   
		                Statement state3=  con.createStatement();
		                 String record=  " select * from SignInData ;";
		                    ResultSet res= state3.executeQuery(record);
		                   
		               while(res.next()) {
		            	  if (res.getString(1).contains("Online_Tourism_Management_System")) {
		            		   urlString= res.getString(1)  ;
			            	     username  =res.getString(2);
			            	         password=res.getString(3);
						}
		            	
							
						}
		              
		        //     System.out.println(result);  while creating returning 0 only 
	            
			
			
		      WebDriver driver=new ChromeDriver();
		wlib.maximizeWindow(driver);
		   driver.get(urlString);  
		//   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
 wlib.implicitWait(driver, 20);
			  driver.findElement(By.xpath("//a[text()='/ Sign In']")).click();
			  
			  
			    WebElement un= driver.findElement(By.xpath("//input[@placeholder='Enter your Email']"));
			  
			    un.sendKeys(username);
			  Thread.sleep(3000);
			  
			    WebElement pwd=  driver.findElement(By.xpath("//input[@placeholder='Password' and @id='password']"));
			 
			    pwd.sendKeys(password);
			  driver.findElement(By.xpath("//input[@name='signin']")).click();
	/*	             WebElement viewmorePackageLink=driver.findElement(By.linkText("View More Packages"));
		   int viewMorePackageLocY=      viewmorePackageLink.getRect().getY();
		           JavascriptExecutor js =(JavascriptExecutor) driver;
		           js.executeScript("window.scrollBy(0,"+viewMorePackageLocY+")");
		           viewmorePackageLink.click();     */ 
			     WebElement detailsLink =driver.findElement(By.xpath("//h4[text()='Package Name: HappyJourney629']/ancestor::div[@class='rom-btm']//a") );//h4[text()='Package Name: HappyJourney629']/ancestor::div[@class='rom-btm']//a"));
			 	wlib.scrollAction(driver, detailsLink)   ;
		  Thread.sleep(3000);
detailsLink.click(); 
WebElement    bookLink=   driver.findElement(By.xpath("//button[@name='submit2']"));
		wlib.scrollAction(driver, bookLink)   ;
		             WebElement       fromDate=driver.findElement(By.id("datepicker"));
		             fromDate.click();
		             driver.findElement(By.xpath("//a[text()='23']")).click();
		             driver.findElement(By.id("datepicker1")).click();
		             driver.findElement(By.xpath("//a[text()='23']")).click();
		    driver.findElement(By.xpath("//input[@name='comment']")).sendKeys("abckd12333kfgdfj");
		    bookLink.click();
   
		    String  vlaidateSuccess=driver.findElement(By.xpath("//div[text()=':Booked Successfully ']")).getText();
		        
			Assert.assertEquals(vlaidateSuccess, "SUCCESS:Booked Successfully");     
	
		}
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
}
}

