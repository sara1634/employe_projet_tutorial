package com.example.employe.repository;

import com.example.employe.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        @Modifying
        @Query("DELETE FROM Employee a WHERE a.id = :id")
         void deteleEmployeeById(Long id);

         // return an optional of employee
         Optional<Employee> findEmployeeById(Long id);
}
