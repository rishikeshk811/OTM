package tourPackages;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.formula.ptg.NotEqualPtg;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.OTM.GenericUtils.DatabaseUtils;
import com.OTM.GenericUtils.ExcelUtils;
import com.OTM.GenericUtils.FileUtils;
import com.OTM.GenericUtils.JavaUtils;
import com.OTM.GenericUtils.WebDriverUtils;
import com.ObjectRepo.HomePage;
import com.ObjectRepo.SignInPage;
import com.ObjectRepo.TourPackagePage;

public class BookTourHistoryTest {
	
	@Test
	public void tourHistory() throws IOException, ParseException, InterruptedException {

		
		FileReader   filePath=new FileReader("./src\\test\\resources\\JsonRead.json");
		JSONParser jsonP =new JSONParser();
	      Object ob=	jsonP.parse(filePath);
	      
	      JSONObject map=  (JSONObject) ob;
	  String url =    (String) map.get("url");
	    String browser=  (String) map.get("browser");

	        String username=  (String) map.get("username");

	      String password=(String) map.get("password");
	      FileUtils flib =new FileUtils();
			ExcelUtils Elib =new ExcelUtils();
			 WebDriverUtils wlib =new WebDriverUtils();
			 JavaUtils jlib =new JavaUtils();
		   DatabaseUtils dlib    = new DatabaseUtils();
			
		      WebDriver driver=new ChromeDriver();
		  wlib.maximizeWindow(driver);
		   driver.get(url);  
		
		   wlib.implicitWait(driver, 20);
			SignInPage si =new SignInPage(driver);
			si.signInAsUser(username, password);
			
	/*	             WebElement viewmorePackageLink=driver.findElement(By.linkText("View More Packages"));
		   int viewMorePackageLocY=      viewmorePackageLink.getRect().getY();
		           JavascriptExecutor js =(JavascriptExecutor) driver;
		           js.executeScript("window.scrollBy(0,"+viewMorePackageLocY+")");
		           viewmorePackageLink.click();      */
		/*	HomePage hp =new HomePage(driver);
			hp.clickOnTourPakcageLink();   */
			String packageName="Package Name: HappyJourney629";
			     WebElement detailsLink =driver.findElement(By.xpath("//h4[text()='"+packageName+"']/ancestor::div[@class='rom-btm']//a") );//h4[text()='Package Name: HappyJourney629']/ancestor::div[@class='rom-btm']//a"));
		                  wlib.scrollAction(driver, detailsLink);
		HomePage hp	    = new HomePage(driver);
		
		  Thread.sleep(3000);
detailsLink.click(); 

TourPackagePage tp =new TourPackagePage(driver);
         WebElement bookLink=tp.getBookLink();
		wlib.scrollAction(driver, bookLink)    ;
		             tp.clickOnFromDateLink();
		             driver.findElement(By.xpath("//a[text()='23']")).click();
		           tp.clickOnToDateLink();
		             driver.findElement(By.xpath("//a[text()='23']")).click();
		  tp.getCommentTextfld().sendKeys("abckd12333kfgdfj");
		  tp.clickOnBooklink();
	hp.clickmytourHistory();
  
       WebElement packagelist = driver.findElement(By.xpath("//a[text()='HappyJourney629']"));
   //   String   packageName=  packagelist.getText();
      
	}

}
