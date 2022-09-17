package com.pretest.demo.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pretest.demo.model.Employee;
import com.pretest.demo.service.empservice;

@RestController
@RequestMapping("/employee")
public class Empcontroller {

	Logger logger=LoggerFactory.getLogger(Empcontroller.class);
	
	  @Autowired
	  empservice empService;
	
	 
		@GetMapping("/allEmployees")
	    public List<Employee> getAllEmployees() {
	    logger.info("Getting all Employee Details");
	    List<Employee> emp= empService.getAllEmployee();
		return emp;		
		}
	    

	    
		@GetMapping("/getEmployee/{id}")
		public ResponseEntity<?> getEmployee(@PathVariable Long id) {
	    	logger.info("Getting Employee Details By employee Id");
	    	ResponseEntity<?> responseEntity = null;
	    	Optional<Employee> booking  = empService.getEmployee(id);
	    	responseEntity = new ResponseEntity<>(booking, HttpStatus.OK);
	    	logger.info("Successfull search of Employee details by Id");
			return responseEntity;
		}
	    

	   
	    @PostMapping("/addEmployee")
	    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
	        logger.info("Creating a New Booking");
	        Employee newEmployee = empService.addEmployee(emp);
	        ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(newEmployee, HttpStatus.ACCEPTED);
	        logger.info("Created a new Employee");
	        return responseEntity;
	    }
	    
	   
		@PutMapping("/updateEmployee/{id}")
		public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp, @PathVariable Long id) {
	    	logger.info("Updating Employee details by id");
	    	ResponseEntity<Object> responseEntity = null;
	    	empService.updateEmployee(emp, id);
	    	responseEntity = new ResponseEntity<Object>("Employee Updated successfully", HttpStatus.OK);
			logger.info(" Employee Updated Successfully");
	    	return responseEntity;
		}
		
	   
		@DeleteMapping("/deleteEmployee/{id}")
		public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
	    	logger.info("Deleting Employee details by Id");
	    	ResponseEntity<Object> responseEntity = null;
	    	empService.deleteEmployee(id);
	    	logger.info("Deleted Successfully");
	    	responseEntity = new ResponseEntity<Object>(" Deleted successfully", HttpStatus.OK);
			return responseEntity;
			
		}
	  
}
