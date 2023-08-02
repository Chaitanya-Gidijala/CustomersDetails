package customerDetails.customer.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import customerDetails.customer.entity.Customer;
import customerDetails.customer.service.customerService;

@Controller
public class CustomerController {
	
	private customerService customerService;

	public CustomerController(customerService customerService)
	{
		super(); 
		this.customerService = customerService;
	}
	
	
	// handler method to handle list customer and return mode and view
	@GetMapping("/customers")
	public String listCustomers(Model model) 
	{
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "customers";
	}
	
	//Go to add customer form when click Add button
	@GetMapping("/customers/new")
	public String createCustomerForm(Model model)
	{
		// create customer object to hold customer form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "create_customer";	
	}
	//save/insert customer into database
	@PostMapping("/customers")
	public String saveCustomer(Customer customer)
	{ 
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}	
	//get details for update Customer
	@GetMapping("/customers/edit/{id}")
	public String editCustomerForm(@PathVariable int id, Model model)
	{
		Customer result =  customerService.getCustomerById(id);
		model.addAttribute("customer",result);
		return "edit_customer";
	}

	//update Customer and redirect to customers list..
	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable int id,
			@ModelAttribute("customer") Customer customer,
			Model model)
	{		
		// get customer from database by id
		Customer existingCustomer = customerService.getCustomerById(id);
		existingCustomer.setId(id);
		existingCustomer.setFirst_name(customer.getFirst_name());
		existingCustomer.setLast_name(customer.getLast_name());
		existingCustomer.setEmail(customer.getEmail());
		
		// save updated customer object
		customerService.updateCustomer(existingCustomer);
		return "redirect:/customers";		
	}
	
	// handler method to handle delete customer request
	@GetMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id)
	{
		customerService.deleteCustomerById(id);
		return "redirect:/customers";
	}	
	
	//logout 
	@GetMapping("/logout")
	public String logout()
	{
		return "logout";
	}
	
	
}