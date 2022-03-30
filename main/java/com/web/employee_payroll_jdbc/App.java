package com.web.employee_payroll_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

public class App 
{
	 /**
     * Database credentials
     *  */
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";	
	static final String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
	static final String username = "root";
	static final String password = "Shreemay@1";
	
	private static void listDriver() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
		
	}
	
    public static void main( String[] args ) {
   
    /**	Register JDBC driver  **/
    	
	Connection con = null;
	Statement stmt = null;
	try {
		Class.forName(JDBC_DRIVER);
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		System.out.println(" Cannot find database driver in the Classpath ");
	}
	
	listDriver();
	
	/**
	 * Open connection
	 */
	System.out.println("Connecting to database...");
	try {
		con = DriverManager.getConnection(jdbcURL,username,password);
		System.out.println("Connection is Successfull ::" + con);
	} catch (SQLException e) {
		System.out.println("not connected to database...");
		e.printStackTrace();
		
	}
	
	/**
	 *  Execute a query
	 */
	System.out.println("Creating statement...");
	try {
		stmt = con.createStatement();
		String sql;
		sql = "SELECT  name, salary, StartDate FROM employee_payroll";
		ResultSet rs = stmt.executeQuery(sql);
		
	/**
	* Extract data from result set*/	
		while(rs.next()){
			//Retrieve by column name
			
			int salary = rs.getInt("salary");
			String name = rs.getString("name");
			String StartDate = rs.getString("StartDate");
			//Display values
			
			System.out.print("Salary : " + salary);
			System.out.print(" name is: " + name);
			System.out.println(" StartDate: " + StartDate);
			}	
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}


	
}
