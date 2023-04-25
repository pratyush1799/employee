package com.employee.service;

import java.util.List;

import com.employee.bean.EmployeeBean;

public interface EmployeeService {

	EmployeeBean addEmployee(EmployeeBean bean) throws Exception;
	
	EmployeeBean getEmployeeDetails(EmployeeBean bean) throws Exception;
	
	EmployeeBean deleteEmployee(EmployeeBean bean) throws Exception;
	
	EmployeeBean updateEmployee(EmployeeBean bean) throws Exception;
	
	List<EmployeeBean> getAllEmployee() throws Exception;
}
