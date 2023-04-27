package com.employee;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.employee.bean.EmployeeBean;
import com.employee.entity.EmployeeEntity;
import com.employee.service.EmployeeService;

@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	private EmployeeService service;
	
	int testId = 1;
	
	@Test
	void getEmployeeDetailsTest() throws Exception {
		EmployeeBean bean = new EmployeeBean();
		bean.setId(6);
		bean.setDepartment("Frontend Development");
		bean.setName("Pratyush Singh");
		bean.setSalary(10000);
		EmployeeBean foundEmployee = service.getEmployeeDetails(bean);
		assertTrue(foundEmployee != null);
	}
	
	@Test
	void getEmployeeListTest() throws Exception {
		List<EmployeeBean> empList = service.getAllEmployee();
		assertTrue(empList != null);
	}
	
	@Test
	void addEmployeeTest() throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setId(testId);
		bean.setDepartment("Frontend Development");
		bean.setName("Pratyush Singh");
		bean.setSalary(10000);
		EmployeeBean addBean = service.addEmployee(bean);
		testId = addBean.getId();
		assertTrue(addBean != null);
	}
	
	@Test
	void updateEmployeeTest() throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setId(testId);
		bean.setDepartment("Frontend Development");
		bean.setName("Pratyush Singh");
		bean.setSalary(1000);
		EmployeeBean updateBean = service.updateEmployee(bean);
		assertTrue(updateBean == null);
	}
	
	@Test
	void deleteEmployeeTest() throws Exception
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setId(testId);
		bean.setDepartment("Frontend Development");
		bean.setName("Pratyush Singh");
		bean.setSalary(1000);
		EmployeeBean deleteBean = service.deleteEmployee(bean);
		assertTrue(deleteBean == null);
	}
	
	@Test
	void beanTest()
	{
		EmployeeBean bean = new EmployeeBean();
		bean.setId(testId);
		bean.setDepartment("Frontend Development");
		bean.setName("Pratyush Singh");
		bean.setSalary(1000);
		assertTrue(bean.getBean() != "");
	}
	
	@Test
	void entityTest()
	{
		EmployeeEntity entity = new EmployeeEntity();
		entity.setId(testId);
		entity.setDepartment("testDepartment");
		entity.setName("testName");
		entity.setSalary(10000.0);
		assertTrue(entity.getEntity() != null);
	}
	
}








