package com.springbootthymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbootthymeleaf.entity.Employee;
import com.springbootthymeleaf.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/showEmployees")
	public ModelAndView showEmployees() {

		ModelAndView mv = new ModelAndView("list-employees");

		List<Employee> li = new ArrayList<Employee>();

		li = employeeService.getEmployees();

		mv.addObject("employees", li);

		return mv;

	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/showEmployees";
	}
	
	@GetMapping("/home")
	public String home1() {
		return "redirect:/showEmployees";
	}
	
	
	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mv=new ModelAndView("add-employee-form");
		Employee e=new Employee();
		mv.addObject("employee",e);
		return mv;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee emp) {
		Employee e=employeeService.addEmployee(emp);
		
		
		return "redirect:/showEmployees";
		
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long employeeId) {
		
		ModelAndView mv=new ModelAndView("update-employee-form");
		Employee emp=employeeService.getEmployee(employeeId);
		mv.addObject("employee",emp);
		return mv;
		
		
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Long employeeId) {
		
		Employee emp=employeeService.getEmployee(employeeId);
		employeeService.deleteEmployee(employeeId);
		
		return "redirect:/showEmployees";
	}
}
