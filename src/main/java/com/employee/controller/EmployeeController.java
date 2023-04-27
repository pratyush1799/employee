package com.employee.controller;

import java.util.List;

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
	
	//1st Layer pages
	@GetMapping("/")
	public String home() 
	{
		return "index";
	}
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm()
	{
		return "addEmployee";
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
	public String getEmployeeForm(Model model) throws Exception 
	{
		List<EmployeeBean> employeeBeanList = employeeService.getAllEmployee();
		model.addAttribute("employee", employeeBeanList);
		return "getList";
	}	
	
	// 2nd Layer pages
	@GetMapping("/addEmployee")
	public String addEmployee(Model model, String name, String department, double salary) throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setName(name);
		bean.setDepartment(department);
		bean.setSalary(salary);
		EmployeeBean newEmployee = employeeService.addEmployee(bean);
		System.out.println(newEmployee);
		return "index";
	}
	@GetMapping("/updateEmployee")
	public String updateEmployee(int id, String name, String department, double salary) throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setId(id);
		bean.setDepartment(department);
		bean.setName(name);
		bean.setSalary(salary);
		EmployeeBean newBean = employeeService.updateEmployee(bean);
		System.out.println(newBean);
		return "index";
	}
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(int id) throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setId(id);
		EmployeeBean deletedBean = employeeService.deleteEmployee(bean);
		System.out.println("deletedBean");
		return "index";
	}
	@GetMapping("/showEmployee")
	public String getEmployeeDetails(int id, Model model) throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setId(id);
		EmployeeBean foundBean = employeeService.getEmployeeDetails(bean);
		if(foundBean != null) {
			model.addAttribute("id", foundBean.getId());
			model.addAttribute("name", foundBean.getName());
			model.addAttribute("department", foundBean.getDepartment());
			model.addAttribute("salary", foundBean.getSalary());
			return "foundEmployee";
		}
		return "NotFound";
	}
	@GetMapping("/Home")
	public String foundEmployee()
	{
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}