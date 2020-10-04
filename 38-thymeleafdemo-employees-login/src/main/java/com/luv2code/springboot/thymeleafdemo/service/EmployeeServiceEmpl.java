package com.luv2code.springboot.thymeleafdemo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceEmpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceEmpl (EmployeeRepository theEmployeeRepository){
		employeeRepository = theEmployeeRepository;
	}

	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()){
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException ("Did not find the employee id - " + theId);
		}
		return theEmployee;
	}

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
