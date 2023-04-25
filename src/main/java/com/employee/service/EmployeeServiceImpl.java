package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.EmployeeBean;
import com.employee.dao.EmployeeDAOWrapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOWrapper employeeDAOWrapper;
	
	@Override
	public EmployeeBean addEmployee(EmployeeBean bean) throws Exception {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.addEmployee(bean);
	}

	@Override
	public EmployeeBean getEmployeeDetails(EmployeeBean bean) throws Exception {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.getEmployeeDetails(bean);
	}

	@Override
	public EmployeeBean deleteEmployee(EmployeeBean bean) throws Exception {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.deleteEmployee(bean);
	}

	@Override
	public EmployeeBean updateEmployee(EmployeeBean bean) throws Exception {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.updateEmployee(bean);
	}

	@Override
	public List<EmployeeBean> getAllEmployee() throws Exception {
		// TODO Auto-generated method stub
		return employeeDAOWrapper.getAllEmployee();
	}

}
