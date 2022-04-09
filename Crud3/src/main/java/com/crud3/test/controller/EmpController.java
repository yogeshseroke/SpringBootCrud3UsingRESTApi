package com.crud3.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud3.test.entity.Employee;
import com.crud3.test.service.EmpService;

@RestController
public class EmpController {
	@Autowired
	private EmpService empser;
	
	@PostMapping("/add")
	public Employee addemp(@RequestBody Employee emp)
	{
		return empser.saveEmp(emp);
	}
	
	@PostMapping("/add1")
	public List<Employee> addemp1(@RequestBody List<Employee> emp)
	{
		return empser.saveEmps(emp);
	}
	
	@GetMapping("/get")
	public List<Employee> findAllEmp()
	{
		return empser.getEmps();
	}
	
	@GetMapping("/getbyid/{empid}")
	public Employee findAllEmpByID(@PathVariable int empid)
	{
		return empser.getById(empid);
	}
	
	@GetMapping("/getbyname/{name}")
	public List<Employee> findAllEmpByName(@PathVariable String name)
	{
		return empser.getByName(name);
	}
	
	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee emp)
	{
		return empser.update(emp);
	}
	
	@DeleteMapping("/delete/{empid}")
	public String deleteEmp(@RequestBody int empid)
	{
		return empser.delete(empid);
	}
}
