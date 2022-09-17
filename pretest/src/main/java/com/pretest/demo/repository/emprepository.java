package com.pretest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pretest.demo.model.Employee;

public interface emprepository extends JpaRepository<Employee, Long> {

}
