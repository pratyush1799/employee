package com.employee.dao;

import org.springframework.data.repository.CrudRepository;

import com.employee.entity.*;

public interface EmployeeDAO extends CrudRepository<EmployeeEntity, Integer>{

}
