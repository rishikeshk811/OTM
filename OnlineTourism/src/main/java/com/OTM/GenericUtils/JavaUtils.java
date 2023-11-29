package com.OTM.GenericUtils;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	
	public int getRandomNo() {
		Random random=new Random();
		   int num=random.nextInt(500);
		   return num;
	}
	public String systemDate() {
	
		
		
		Date date = new  Date()  ;
		  String systemDate=date.toString();
		  
		  return systemDate;
	}
	public String systemDateinFormat() {
		   SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
		   
	Date date =new Date ();
	   String   systemDateinFormat=dateformat.format(date);
	   return systemDateinFormat ;
	}
}
