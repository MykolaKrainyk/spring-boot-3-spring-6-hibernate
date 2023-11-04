package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") //instead of "/employees" the "/members" will be used
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
