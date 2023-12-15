package com.moretolearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.moretolearn.model.Employee;
import com.moretolearn.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee getEmployeeById(String empId) {
		return employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found :" + empId));
	}

	public Employee updateEmployee(String empId, Employee employee) {
		employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found" + empId));
		employee.setEmpId(empId);
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(String empId) {
		employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found :" + empId));
		employeeRepository.deleteById(empId);
	}
}
