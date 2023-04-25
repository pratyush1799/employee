package com.employee.dao;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.bean.EmployeeBean;
import com.employee.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public EmployeeBean addEmployee(EmployeeBean bean) throws Exception 
	{
		EmployeeBean result = null;
		try {
			EmployeeEntity entity = convertBeanToEntity(bean);
			EmployeeEntity entity2 = employeeDAO.save(entity);
			result = convertEntityToBean(entity2);
		} catch(Exception ex) {
			throw ex;
		}
		return result;
	}
	
	public EmployeeBean getEmployeeDetails(EmployeeBean bean) throws Exception
	{
		EmployeeBean result = null;
		try {
			List<EmployeeEntity> EmployeeEntityList = (List<EmployeeEntity>) employeeDAO.findAll();
			for(EmployeeEntity entity : EmployeeEntityList)
			{
				if(bean.getId() == entity.getId())
				{
					result = convertEntityToBean(entity);
					break;
				}
			}
		} catch(Exception ex) {
			throw ex;
		}
		return result;
	}
	
	public EmployeeBean deleteEmployee(EmployeeBean bean) throws Exception
	{
		EmployeeBean result = null;
		try {
			List<EmployeeEntity> EmployeeEntityList = (List<EmployeeEntity>) employeeDAO.findAll();
			for(EmployeeEntity entity : EmployeeEntityList)
			{
				if(bean.getId() == entity.getId())
				{
					result = convertEntityToBean(entity);
					employeeDAO.delete(entity);
					break;
				}
			}
		} catch(Exception ex) {
			throw ex;
		}
		return result;
	}
	
	public EmployeeBean updateEmployee(EmployeeBean bean) throws Exception
	{
		EmployeeBean result = null;
		try {
			List<EmployeeEntity> EmployeeEntityList = (List<EmployeeEntity>) employeeDAO.findAll();
			for(EmployeeEntity entity : EmployeeEntityList)
			{
				if(bean.getId() == entity.getId())
				{
					entity.setDepartment(bean.getDepartment());
					entity.setName(bean.getName());
					entity.setSalary(bean.getSalary());
					employeeDAO.save(entity);
					result = convertEntityToBean(entity);
					break;
				}
			}
		} catch(Exception ex) {
			throw ex;
		}
		return result;
	}
	
	public List<EmployeeBean> getAllEmployee() throws Exception
	{
		List<EmployeeBean> EmployeeBeanList = new ArrayList<EmployeeBean>();
		try {
			List<EmployeeEntity> EmployeeEntityList = (List<EmployeeEntity>) employeeDAO.findAll();
			for(EmployeeEntity entity : EmployeeEntityList)
			{
				EmployeeBean bean = new EmployeeBean();
				bean = convertEntityToBean(entity);
				EmployeeBeanList.add(bean);
			}
		} catch(Exception ex) {
			throw ex;
		}
		return EmployeeBeanList;
	}
	
	
	public EmployeeEntity convertBeanToEntity(EmployeeBean bean) 
	{
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
	public EmployeeBean convertEntityToBean(EmployeeEntity entity) 
	{
		EmployeeBean bean = new EmployeeBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
}
