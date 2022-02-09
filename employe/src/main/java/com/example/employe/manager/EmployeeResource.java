package com.example.employe.manager;


import com.example.employe.model.Employee;
import com.example.employe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplopyee")
public class EmployeeResource {

    @Autowired
    private  EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeS){
        this.employeeService = employeeS;
    }

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ResponseEntity is a generic method
    // it returns an http reponse and in the body of http reponse there is the list of employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@Param("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

