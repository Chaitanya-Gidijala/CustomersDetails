package customerDetails.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import customerDetails.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findById(int id);

}