package com.OTM.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
Connection con;
	public Connection connectDB() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		  con=DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DB_Username, IpathConstants.DB_Password);
		  return con;
	}

	
	
	public String executeAndGetData(int colData,String ExpData,String query) throws SQLException {
		   Statement state=con.createStatement();
	//	     String query= "select * from  Student_info ;";
		       ResultSet result=   state.executeQuery(query);
		       boolean flag=false;
		       while(result.next()) {
		    	     String acutal= result.getString(colData);
		    	     if (acutal.equalsIgnoreCase(ExpData)) {
						flag=true;
						break;
					}
		       }
		       if (flag) {
				System.out.println("Project Created Successfully ");
				return ExpData;
			}
		       else {
				System.out.println("Project not Created Successfully ");
				return "";
			
		       }
		       
	}
	public void disconnectDB() throws SQLException {
		
		
		con.close();
	
	}
}
