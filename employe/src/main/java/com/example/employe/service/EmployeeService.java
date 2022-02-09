package com.example.employe.service;

import com.example.employe.exception.UserNotFoundException;
import com.example.employe.model.Employee;
import com.example.employe.repository.EmployeeRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Transactional
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        Hibernate.initialize(employee);
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return  employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return  employeeRepo.save(employee);
    }


    public void deleteEmployee(Long id){
       employeeRepo.deteleEmployeeById(id);
    }

    // we used optional because there is a situation where I may have not an employee selected by id
    // we used java 8 : orElseThrow : try to find employee, so if there is an employe by id it return employe
    // however , it returns the message exception
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow( ()-> new UserNotFoundException("User by id " + id + "is not found"));
    }


}
