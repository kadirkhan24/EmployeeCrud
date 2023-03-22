package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.engine.AttributeName;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller 
@RequestMapping("/employees")
public class EmployeeController {

	
	@Autowired
	EmployeeService employeeService;
	
	

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> empList = employeeService.findAll();
		
		theModel.addAttribute("employees", empList);

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		//get the employee from the service
		Employee theEmployee = employeeService.findById(theId);
		
		//set employee in the model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);
		
		//send over to our form
		
		return "employees/employee-form";
		
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee")Employee theEmployee) {
		
		//save the employee
		employeeService.save(theEmployee);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	  
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		//delete the employee
		employeeService.deleteById(theId);
		//redirect to the /employees/list
		
		return "redirect:/employees/list";
		
		
	}
}









