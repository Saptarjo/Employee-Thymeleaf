package com.springbootthymeleaf.service;

import java.util.List;

import com.springbootthymeleaf.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee addEmployee(Employee emp);

	public Employee getEmployee(Long id);

	public void deleteEmployee(Long employeeId);

	

}
