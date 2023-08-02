package customerDetails.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import customerDetails.customer.repository.CustomerRepository;

@SpringBootApplication

public class CustomerDetailsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDetailsProjectApplication.class, args);
	}
}