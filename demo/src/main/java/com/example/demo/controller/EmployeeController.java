package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins ="*", maxAge = 3600)
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee emp = empService.addEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.CREATED);

	}

	@PostMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {

		Employee emp = empService.updateEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Long> deleteEmployee(@PathVariable("id") Long id) {

		empService.deleteEmployee(id);
		return new ResponseEntity<>(id, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> fetchAllEmployee() {

		List<Employee> listEmployee = empService.findAllEmployee();
		return new ResponseEntity<>(listEmployee, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> fetchEmployee(@PathVariable("id") Long id) {

		Employee employee = empService.FindEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

}
