package com.example.employe;

import com.example.employe.model.Employee;
import com.example.employe.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// remplir la base de donnée
		employeeRepository.save((new Employee(2L,"khadija","khadija@sysmart.com","directeur","0798878912","", "C1")));
		employeeRepository.save((new Employee(3L,"sawsan","sawsan@sysmart.com","commercial","0798878999","", "C10")));
		employeeRepository.save((new Employee(4L,"daniel","daniel@sysmart.com","rh","0797678999","", "C11")));
		employeeRepository.findAll().forEach( e -> {
			System.out.println( e.getName());
		});
	}
}
