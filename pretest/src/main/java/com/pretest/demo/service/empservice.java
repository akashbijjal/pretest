package com.pretest.demo.service;

import java.util.Optional;

import com.pretest.demo.model.Employee;

import java.util.List;

public interface empservice {

	public Employee addEmployee(Employee employee);
	
	public String deleteEmployee(Long id);
	
    public Optional<Employee> getEmployee(Long id);
	
	public List<Employee> getAllEmployee();
	
	public String updateEmployee(Employee employee, Long id);
}
