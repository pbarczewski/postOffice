package com.pbarczewski.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pbarczewski.entity.Customer;
import com.pbarczewski.repository.CustomerRepository;


@Component
public final class CustomerServiceImpl  {
	private CustomerRepository customerRepository;
	private List<Customer> customers = new ArrayList<>();
	private Customer customer;	
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customer> remainingUsers(String parameter) throws Exception {			
		customers = customerRepository.findAllByOrderByType();
		if(isNumeric(parameter)) {
			customer = customerRepository.findByTicket(Integer.valueOf(parameter));
		} else {
			customer = customerRepository.findByNickname(parameter);
		}
		int index = findIndex(customer);
		
		return findMembers(index);
	}


	private int findIndex(Customer customer) throws Exception {
		int index;
		if(customers.contains(customer)) {
			index = customers.indexOf(customer);
		} else {
			throw new Exception("There is no user in database");
		}
		return index;
	}
	
	private boolean isNumeric(String parameter) {
		return parameter.chars().allMatch(Character::isDigit);
	}
	
	private List<Customer> findMembers(int index) {
		Integer waitingTime = 0;
		List<Customer> remainingMembers = new ArrayList<>();
		for(int i = 0 ; i <= index; i++) {
			remainingMembers.add(customers.get(i));
			waitingTime += customers.get(i).getTime();
		}
		waitingTime -= remainingMembers.get(index).getTime();
		customer.setWaitingTime(waitingTime);
		return remainingMembers;
	}
}
