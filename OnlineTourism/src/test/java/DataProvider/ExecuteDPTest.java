package DataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OTM.GenericUtils.ExcelUtils;

public class ExecuteDPTest {

	
	
	
	
	@Test(dataProvider = "DataformExcel")
	public void getData(String org,String loc,String founder) {
		System.out.println(" orgName ---> "+org+"  LOcation --- >> "+loc+" founder-->> "+founder);
	}
	
	
	
	
	
	
	
	@DataProvider
	public  Object[][] DataformExcel() throws EncryptedDocumentException, IOException {
		ExcelUtils elib  =new ExcelUtils();
		   Object [][]obj=elib.testDataFromExcel("changePassword");
		      return obj;
	}
	
	
	
	
	
	 
	
	
	
	
	
}
