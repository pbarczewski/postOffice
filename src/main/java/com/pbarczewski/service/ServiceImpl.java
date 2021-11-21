package com.pbarczewski.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pbarczewski.entity.Customer;
import com.pbarczewski.input.Input;
import com.pbarczewski.input.TicketGenerator;
import com.pbarczewski.repository.CustomerRepository;
import com.pbarczewski.userFactory.CustomerFactory;


@Service
public class ServiceImpl implements CustomerService {
	private final CustomerRepository repository;
	private final CustomerServiceImpl customerService;
	
	@Autowired
	public ServiceImpl(CustomerRepository repository, CustomerServiceImpl customerService) {
		this.repository = repository;
		this.customerService = customerService;
	}

	@Override
	public List<Customer> allCustomers() {
		return repository.findAllByOrderByType();
	}
	
	@Override
	public void saveCustomer(Input input) throws Exception {
		Customer customer = CustomerFactory.getInstance(input.getNickname(), input.getPin());
		TicketGenerator.generateTicket(customer);
		repository.save(customer);
	}

	@Override
	public List<Customer> remainingUsers(String parameter) throws Exception {
		return customerService.remainingUsers(parameter);
	}
}
