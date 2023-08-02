package customerDetails.customer.service;

import java.util.List;

import customerDetails.customer.entity.Customer;

public interface customerService {
	
	List<Customer> getAllCustomers();
	
	Customer saveCustomer(Customer customer);
	
	Customer getCustomerById(int id);
	
	Customer updateCustomer(Customer existingStudent);
	
	void deleteCustomerById(int id);

}
