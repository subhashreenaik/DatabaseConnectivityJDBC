/**
 * 
 */
package com.web.employee_payroll_jdbc;

/**
 * @author 91824
 *
 */
public class EmployeePayRollData {

	/**
	 * 
	 */
	private int employee_Id;
	private String employee_name;
	
	private int employee_salary;
	
	public EmployeePayRollData(int employee_Id,String employee_name,int employee_salary) {
		this.employee_Id =employee_Id;
		this.employee_name = employee_name;
		this.employee_salary =employee_salary;
		
	}
	
	
	public int getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public int getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(int employee_salary) {
		this.employee_salary = employee_salary;
	}
	
	@Override
	public String toString() {
		return "EmployeePayRollData [employee_Id=" + employee_Id + ", employee_name=" + employee_name
				+ ", employee_salary=" + employee_salary + "]";
	}
	

}
