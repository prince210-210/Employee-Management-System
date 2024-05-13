package com.nt.dao;

import java.util.List;


import com.nt.model.Employee;

public interface IEmployeeDAO {
	public List<Employee> getAllEmployee();
	public int registerEmp(Employee emp);
	public Employee getEmplByNo(int no);
	public int updateEmpByNo(Employee emp);
	public int deleteEmployeeByNo(int no);

}
