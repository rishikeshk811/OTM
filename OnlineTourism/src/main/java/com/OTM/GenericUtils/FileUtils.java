package com.OTM.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
/* 
 * this method is used to read data from porperty file
 * @Author =Rishikesh singh rajput
 * @param =key
 * @return 
 * @throws throwable
 */

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis =new FileInputStream(IpathConstants.FilePath);
		Properties pObj =new Properties();
		pObj.load(fis);
	     String value= pObj.getProperty(key);
	     return value;
	}
	
	public void writeInPropertyFile(String key,String value) throws IOException {
		FileInputStream fis =new FileInputStream(IpathConstants.FilePath);
		Properties pObj =new Properties();
		pObj.load(fis);
		pObj.setProperty(key, value);
		FileOutputStream fos=new FileOutputStream(IpathConstants.FilePath);
		pObj.store(fos, "data inserted successfully");
	}
}
