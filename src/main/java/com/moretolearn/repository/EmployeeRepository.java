package com.moretolearn.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moretolearn.model.Employee;

@Repository
@EnableScan
public interface EmployeeRepository extends CrudRepository<Employee, String>{

}
