package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService 
{
	public List<Employee> findAllEmployee();
    public String registerEmployee(Employee emp);
    public Employee findEmplByNo(int no);
    public String modifyEmpDetailsByNo(Employee emp);
    public String removeEmployeeByNo(int no);
}
