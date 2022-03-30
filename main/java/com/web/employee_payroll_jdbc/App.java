package com.web.employee_payroll_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

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
	static Connection con = null;
	static Statement stmt = null;
	static List<EmployeePayRollData> 	employeelist = new ArrayList<EmployeePayRollData>() ;
	
	private  void listDriver() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println(" " + driverClass.getClass().getName());
		}
		
	}
	
	/**	Register JDBC driver  **/
	public  void loadDriver() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println(" Cannot find database driver in the Classpath ");
		}
	}
	
	/**
	 * Open connection
	 */
	public  void getConnection() {
		System.out.println("Connecting to database...");
		try {
			con = DriverManager.getConnection(jdbcURL,username,password);
			System.out.println("Connection is Successfull ::" + con);
		} catch (SQLException e) {
			System.out.println("not connected to database...");
			e.printStackTrace();
			
		}
	}
	/**
	 *  Execute a query and read the data
	 * @throws SQLException 
	 */
	public  int executeQuery(String sql) throws SQLException {
		System.out.println("Creating statement...");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			/**
			* Extract data from result set*/
			
			while(rs.next()){
				
				//Retrieve by column name
				int id=rs.getInt("id");
				int salary = rs.getInt("salary");
				String name = rs.getString("name");
				String StartDate = rs.getString("StartDate");
				employeelist.add(new EmployeePayRollData(id, name, salary));
				
				//Display values
				
				System.out.print("Id  : " + id);
				System.out.print("Salary : " + salary);
				System.out.print(" name is: " + name);
				System.out.println(" StartDate: " + StartDate);
				}	
			//System.out.println(employeelist);
			return employeelist.size();
			
			
	}
	/**
	 *  updating the database 
	 * @throws SQLException 
	 */
	public  void updateDatabase(String sql) throws SQLException {
		System.out.println("Updating table in given database...");
		stmt.executeLargeUpdate(sql);
		
	}
	/**
	 *  updating the database using prepared statement
	 * @throws SQLException 
	 */
	public  void updateDatabaseUsingPreparedStatement(String sql) throws SQLException {
		System.out.println("Updating table by using in given database...");
		PreparedStatement p=con.prepareStatement(sql);
		p.executeLargeUpdate();
	}
	
	
	
    public static void main( String[] args ) throws SQLException {
    	App obj1 =new App();
    	String sql;	
    	obj1.loadDriver();
    	obj1.listDriver();
    	obj1.getConnection();
    	
	    
	    
	    /**
		 *  Execute a query and Extract data from result set
		 */
	   Scanner scan =new Scanner(System.in);
	   System.out.println("Give sql command to retrive employee data");
	   sql=scan.nextLine();
	   
	
	    //sql = "SELECT  * FROM employee_payroll";
	   obj1.executeQuery(sql);
	  
	   
	   /**
		 *  Execute a query and update the database
		 */
		
	    System.out.println("Give sql command to update employee data");
		// update="UPDATE employee_payroll set salary='30000' WHERE id= 27 ";
	    String update=scan.nextLine();
	   // obj1.updateDatabase(update);
		obj1.updateDatabaseUsingPreparedStatement(update);
		
	
}
    


	
}
