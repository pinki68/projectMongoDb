package com.example.demoMongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demoMongodb.model.Employee;
import com.example.demoMongodb.service.EmployeeService;

@Controller
public class EmployeeController {

	
	 @Autowired
	   private EmployeeService employeeService;
	   // Display form and employees list
	   @GetMapping("/")
	   public String showEmployeeForm(Model model) {
	       model.addAttribute("employee", new Employee());
	       model.addAttribute("employees", employeeService.getAllEmployees());
	       return "index";
	   }
	   // Save Employee
	   @PostMapping("/add")
	   public String saveEmployee(@ModelAttribute Employee employee) {
	       employeeService.saveEmployee(employee);
	       return "redirect:/";
	   }
	   // Display single Employee details
	   @GetMapping("/display/{id}")
	   public String displayEmployee(@PathVariable String id, Model model) {
	       Employee employee = employeeService.getEmployeeById(id).orElse(null);
	       model.addAttribute("employeeDetail", employee);
	       return "employee_detail";
	   }

}
