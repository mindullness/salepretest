package com.aptech.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aptech.api.models.Customer;
import com.aptech.api.repositories.CustomerRepository;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(ApiApplication.class, args);

		CustomerRepository customerRepo = context.getBean(CustomerRepository.class);

		for(int i=1; i<=5; i++){
			Customer customer = new Customer("Cus"+i,
			"Customer Name "+i, "Phone "+i, null);

			customerRepo.save(customer);
		}
	}

}
