package com.moretolearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moretolearn.model.Employee;
import com.moretolearn.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee Employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(Employee));
	}

	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployeeByempId(@PathVariable String empId) {
		return ResponseEntity.ok(employeeService.getEmployeeById(empId));
	}

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployeeList() {
		return ResponseEntity.ok(employeeService.getEmployees());
	}

	@PutMapping("/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String empId, @RequestBody Employee Employee) {
		return ResponseEntity.ok(employeeService.updateEmployee(empId, Employee));
	}

	@DeleteMapping("/{empId}")
	public void deleteEmployeeByempId(@PathVariable String empId) {
		employeeService.deleteEmployee(empId);
	}
}
