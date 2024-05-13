package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService
{
	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> list=empDAO.getAllEmployee();
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) {
		int count=empDAO.registerEmp(emp);
		return count==0?"Emp Not registered":"Employee is registered";
	}

	@Override
	public Employee findEmplByNo(int no) {
		Employee emp=empDAO.getEmplByNo(no);
		return emp;
	}

	@Override
	public String modifyEmpDetailsByNo(Employee emp) {
		int count=empDAO.updateEmpByNo(emp);
		return count==0?"Employee not found for updation":"Employee found and updated";
	}

	@Override
	public String removeEmployeeByNo(int no) {
		int count=empDAO.deleteEmployeeByNo(no);
		return count==0?"Employee not found for deletion":"Employee found and deleted";
	}

}
