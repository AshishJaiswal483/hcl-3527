package com.abes.springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(SpringJdbcApplication.class, args);

		DoctorRepository repo = context.getBean(DoctorRepository.class);


		String name = repo.getStudentName(1);
		System.out.println("Name: " + name);


		List<Doctors> d= repo.getAllDoctors();
		d.forEach(System.out::println);

//		int row=repo.addDoctor(6,"Ashish Jaiswal",23);
//		System.out.println("row effected:"+row);

		int row1=repo.updateDoctor(6,"Sushil Jaiswal",28);
		System.out.println("row effected:"+row1);

		int row2=repo.deleteDoctor(6);
		System.out.println("row deleted:"+row1);

	}

}
