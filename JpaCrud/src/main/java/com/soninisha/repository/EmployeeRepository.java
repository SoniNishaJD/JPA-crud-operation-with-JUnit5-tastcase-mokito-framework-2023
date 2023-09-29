package com.soninisha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soninisha.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
