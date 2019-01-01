package com.rsystem.Day1.Employee;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rsystem.Day1.Employee.Exception.EmployeeNotFoundException;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//import com.rsystem.Day1.Employee.Exception.EmployeeNotFoundException;



@RestController
public class EmployeeController implements CommandLineRunner{
	
	/*@Autowired
	private EmployeDaoService service;*/
	
	@Autowired
	EmployeeRepository repository;
	
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		 return repository.findAll();
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Employee ID supplied"),
			@ApiResponse(code = 404, message = "Employee not found"),
			@ApiResponse(code = 100, message = "Channel not found") 
			})
	@GetMapping("/employee/id/{id}")
	public Employee getEmployee(@PathVariable int id) {
		
		Employee emp = repository.findById(id);
		if (emp==null)
			throw new EmployeeNotFoundException("Employee not found with Emp ID "+id);
	
		return emp;
	}

	@Override
	public void run(String... args) throws Exception {
		/*Employee emp = repository.findById(10);
		System.out.println(emp);*/
		
	}
	
	
	
	@PostMapping("/employee")
	public Employee saveEmployee(@Valid @RequestBody Employee emp) {
			return repository.save(emp);
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		 return repository.save(emp);
	}
	
	@DeleteMapping("/employee/{id}")
	public void removeEmployee(@PathVariable int id) {
		  repository.deleteById(id);
	}
	

}
