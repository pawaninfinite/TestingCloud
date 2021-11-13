package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	public Employee addEmployee(Employee employee) {

		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	public Employee updateEmployee(Employee employee) {

		return employeeRepo.save(employee);
	}

	public List<Employee> findAllEmployee() {

		return employeeRepo.findAll();
	}

	public Employee FindEmployeeById(Long id) {

		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by Id " + id + " was not found"));
	}

}
