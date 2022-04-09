package com.crud3.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud3.test.entity.Employee;
import com.crud3.test.repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	private EmpRepo emprepo;
	
	public Employee saveEmp(Employee emp)
	{
		return emprepo.save(emp);
	}
	public List<Employee> saveEmps(List<Employee> emp)
	{
		return emprepo.saveAll(emp);
	}
	public List<Employee> getEmps()
	{
		return emprepo.findAll();
	}
	public Employee getById(int id)
	{
		return emprepo.findById(id).orElse(null);
	}
	@SuppressWarnings("unchecked")
	public List<Employee> getByName(String name)
	{
		return (List<Employee>)emprepo.findByName(name);
	}
	public String delete(int id)
	{
		emprepo.deleteById(id);
		return "deleted successfully";
	}
	public Employee update(Employee emp)
	{
		Employee existEmp=emprepo.findById(emp.getEmpid()).orElse(null);
		existEmp.setEmpid(emp.getEmpid());
		existEmp.setName(emp.getName());
		return emprepo.save(existEmp);
	}
}
