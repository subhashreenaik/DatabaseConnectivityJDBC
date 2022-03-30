package com.web.employee_payroll_jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
    /**
     * Rigorous Test :-)
     * @throws SQLException 
     */
    @Test
    public void checkSizeOfList() throws SQLException
    {
    	App test=new App();
    	String sql="SELECT  * FROM employee_payroll";	
    	int size=test.executeQuery(sql);
    	Assert.assertEquals(10, size);
    	
    	
    	
    	
    }
}
