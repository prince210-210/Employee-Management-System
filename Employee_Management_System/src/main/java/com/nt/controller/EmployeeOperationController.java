package com.nt.controller;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationController {
	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
 public String showHomePage() {
	 // return LVN
	 return "welcome";
 }
	@GetMapping("/emp_report")
	public String showEmployees(Map<String,Object> map) {
		//use Service
		List<Employee> list=empService.findAllEmployee();
		map.put("empsData", list);
		 // return LVN
		 return "show_report";
	}
	
	@GetMapping("/add_emp")
	public String addEmployeeFormPage(@ModelAttribute("emp") Employee emp) {
		return "emp_register_form";
	}
	@PostMapping("/add_emp")
	public String addEmpformPageSubmission(Map<String,Object> map,
			                                      @ModelAttribute("emp")Employee emp) {
		String msg=empService.registerEmployee(emp); 
		//msg show on same page
		List<Employee> list=empService.findAllEmployee();
		map.put("resultMsg", msg);
		map.put("empsData", list);
		
		return "show_report";
	}
	@GetMapping("/emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no")int no,
			                                @ModelAttribute("emp")Employee emp  ){
		Employee emp1=empService.findEmplByNo(no);
		BeanUtils.copyProperties(emp1, emp);
		
		return "emp_edit_form";
      }
	@PostMapping("/emp_edit")
	public String processEditFormPageSubmission(@ModelAttribute("emp")Employee emp,
			                                     Map<String,Object> map) {
		String msg=empService.modifyEmpDetailsByNo(emp);
		List<Employee> listEmps=empService.findAllEmployee();
		map.put("resultMsg", msg);
		map.put("empsData", listEmps);
		
		return "show_report";
	}
	@GetMapping("/emp_delete")
	public String removeEmployee(@RequestParam("no")int no,
			                       Map<String,Object> map) {
		String msg=empService.removeEmployeeByNo(no);
		List<Employee> listEmps=empService.findAllEmployee();
		map.put("resultMsg", msg);
		map.put("empsData", listEmps);
		
		return "show_report";
	}
			                                   
}
