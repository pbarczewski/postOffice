package com.pbarczewski.service;
import java.util.List;



import com.pbarczewski.entity.Customer;
import com.pbarczewski.input.Input;

public interface CustomerService {
	List<Customer> allCustomers();
	List<Customer> remainingUsers(String parameter) throws Exception;
	public void saveCustomer(Input input) throws Exception;
}
