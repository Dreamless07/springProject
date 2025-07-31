//main application where we can insert if required, we have connected this to repository layer
package com.group1.springProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjectApplication implements CommandLineRunner{//inbuilt functional interface which has run as default method, we can insert values from here also
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Autowired
	private empdetailsRepository empdetailsRepository;//has all methods

	@Override
	public void run(String... args) throws Exception {
		employeeClass emp1=new employeeClass();
		emp1.setName("Ajay");//inbuilt method from repository layer
		emp1.setAddress("Bangalore");
		empdetailsRepository.save(emp1);//inbuilt method from repository layer(for insert)
	}

}
