package com.OTM.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExcelUtils {
	/*
	 * this method is used to read a data form excel file 
	 * @author rishikesh singh Rajput
	 * @param =sheetName
	 * @param=row
	 * @param=cell
	 * @return 
	 * @throws throwable 
	 */

	public String readDataFromExcelSheet(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(IpathConstants.ExcelPath);
	  Workbook wb  =	 WorkbookFactory.create(fis);
	   
	 
	  
	  org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
	     String value= sh.getRow(row).getCell(cell).getStringCellValue();
	     return value;
	}
	/*
	 * this method is used to write data in  excel file 
	 * @author rishikesh singh Rajput
	 * @param  sheetName
	 * @param row
	 * @param cell
	 * @param cellvalue
	 * @return 
	 * @throws throwable 
	 */
	
	
	
	public void writeDataInExcel(String sheetName,int row,int cell,String cellValue) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(IpathConstants.ExcelPath);
		  Workbook wb  =	 WorkbookFactory.create(fis);
		   
		  
		  
		  org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
		    sh.getRow(row).getCell(cell).setCellValue(cellValue);
		    FileOutputStream fos =new FileOutputStream(IpathConstants.ExcelPath);
		    wb.write(fos);
		 
	}
	
		/*
		 * this method is used to get row count in Excel sheet
		 * @author rishikesh singh Rajput
		 * @param =sheetName
	       * @return 
		 * @throws throwable 
		 */
	
	
	public int getLastRowCount(String sheetName) throws Throwable {
		
		FileInputStream fis =new FileInputStream(IpathConstants.ExcelPath);
		  Workbook wb  =	 WorkbookFactory.create(fis);
		   
		  
		  
		  
		  org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
		      int count=sh.getLastRowNum();
		
		return count;
		
	
	}
	public void readMultipleData(String sheetName,WebDriver driver) throws Throwable{
		JavaUtils jLib =new JavaUtils();
		FileInputStream fis =new FileInputStream(IpathConstants.ExcelPath);
		  Workbook wb  =	 WorkbookFactory.create(fis);
		   
		  
		  
		  org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetName);
		      int count=sh.getLastRowNum();
		 
		      
		      HashMap<String, String> map =new  HashMap<String, String>();
		      for( int i=1;i<=count;i++) {
		    	     String key= sh.getRow(i).getCell(0).getStringCellValue();
		    	     String value= sh.getRow(i).getCell(1).getStringCellValue();
		    	     map.put(key, value);
		      }
		     
		
		for(Entry<String, String>set:map.entrySet()) {
		         if (set.getKey().contains("accountName")) {
				
		       	 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNo());
		        //	 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		        	 
				}
		         else {
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
		      
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	public  Object[][] testDataFromExcel(String sheetName ) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis  =new FileInputStream(IpathConstants.ExcelPath);
		    Workbook wb = WorkbookFactory.create(fis);
		     Sheet sh= wb.getSheet(sheetName);
		        int countRow= sh.getLastRowNum();
		   
		         int countCell=   sh.getRow(0).getLastCellNum(); 
		            Object[][] obj = new Object[countRow+1][countCell];
		            for( int i=0;i<=countRow;i++) {
		            	for(int j=0;j<countCell;j++) {
		            		    obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		            		
		            	}
		            }
		          
		          
		          return obj;
		    
		    
	}
	
	
}

