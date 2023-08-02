package customerDetails.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import customerDetails.customer.entity.Customer;
import customerDetails.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements customerService {

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(int id) {
		customerRepository.deleteById(id);	
	}
}
