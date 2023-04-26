package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.employee.bean.EmployeeBean;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String home() 
	{
		return "index";
	}
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm() 
	{
		return "add_Employee";
	}
	@GetMapping("/deleteEmployeeForm")
	public String deleteEmployeeForm() 
	{	
		return "deleteEmployee";
	}
	@GetMapping("/updateEmployeeForm")
	public String updateEmployeeForm() 
	{
		return "updateEmployee";
	}
	@GetMapping("/showEmployeeForm")
	public String showEmployeeForm() 
	{
		return "showEmployee";
	}
	@GetMapping("/getListForm")
	public String getEmployeeForm() 
	{
		return "getList";
	}	
}