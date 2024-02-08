package com.example.springbootwebredis.api;

import com.example.springbootwebredis.model.Employee;
import com.example.springbootwebredis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @GetMapping(path = "{id}")
  @Cacheable(value = "Employee", key = "#id")
  public Employee getEmployee(@PathVariable("id") final Long id) {
    return employeeService.findById(id);
  }

  @PostMapping
  public Employee saveEmployee(@RequestBody Employee emp) {
    return employeeService.save(emp);
  }

}