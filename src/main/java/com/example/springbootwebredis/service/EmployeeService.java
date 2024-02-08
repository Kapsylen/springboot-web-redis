package com.example.springbootwebredis.service;

import com.example.springbootwebredis.model.Employee;

public interface EmployeeService {

  Employee save(Employee emp);

  Employee findById(Long id);
}
