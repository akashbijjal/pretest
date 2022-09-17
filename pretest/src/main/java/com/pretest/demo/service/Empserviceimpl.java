package com.pretest.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretest.demo.exception.NotFoundException;
import com.pretest.demo.model.Employee;
import com.pretest.demo.repository.emprepository;

@Service
public class Empserviceimpl implements empservice {
	
	
	Logger logger = LoggerFactory.getLogger(Empserviceimpl.class);

	@Autowired
	emprepository empRepository;
	
	public List<Employee> getAllEmployee() {

		logger.info("Getting all employee details");
		List<Employee> allEmployeeList = empRepository.findAll();
		if (allEmployeeList.isEmpty()) {
			throw new NotFoundException("No Employee available");
		}
		return allEmployeeList;

	}
	public String deleteEmployee(Long id) {

		logger.info("Deleting employee by id");
		if (empRepository.existsById(id)) {
			empRepository.deleteById(id);
			logger.info("Employee Deleted");
			return "Employee Deleted with Employee Id : " + id;
			
		} else {
			throw new NotFoundException("Employee with Id " + id + " not exist");
		}

	}
	public String updateEmployee(Employee employee, Long id ) {
		logger.info("Updating Employee details");

		Optional<Employee> list = empRepository.findById(id);
		System.out.println(list);
		if (!list.isPresent())
			throw new NotFoundException("Employee with the id " + id + "not exist");
		empRepository.deleteById(id);
		empRepository.save(employee);
		logger.info("Updated Successfully");
		return "Employee Updated with: " + employee.getId();

	}
	
	
	public Optional<Employee> getEmployee(Long id) {

		logger.info("Getting Employee by id");
		Optional<Employee> emp = empRepository.findById(id);
		if (!emp.isPresent()) {
			throw new NotFoundException("No EMployee available with id : " + id);
		}
		logger.info("Successful search of Booking by id");
		return emp;

	}
	
	
	public Employee addEmployee(Employee emp) throws NotFoundException {
		logger.info("Adding a new Employee");
		if (empRepository.existsById(emp.getId()))
            throw new NotFoundException();
        else {
            Employee newEmp = empRepository.save(emp);
            logger.info("Added Employee");
            return newEmp;
		}
	}
	
	
	
}
