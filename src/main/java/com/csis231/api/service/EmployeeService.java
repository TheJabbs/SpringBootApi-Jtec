package com.csis231.api.service;

import com.csis231.api.DTO.EmployeeDTO;
import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Employee;
import com.csis231.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee authenticate(EmployeeDTO employeeDTO) {
        Employee e = employeeRepository.getEmployeeByEmployeeUsernameAndEmployeePassword(employeeDTO.getEmployeeUsername(), employeeDTO.getEmployeePassword());
        return e;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));

        employee = employeeDetails.clone();

        return employeeRepository.save(employee);
    }

    public Map<String, Boolean> deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id : " + id));

        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}