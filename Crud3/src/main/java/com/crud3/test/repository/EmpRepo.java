package com.crud3.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud3.test.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{
		List<Employee> findByName(String name);
}
