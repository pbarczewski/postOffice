package com.pbarczewski.input;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import com.pbarczewski.entity.Customer;

public class TicketGenerator {
	private static final Set<Integer> tickets = new HashSet<>();
	
	public static void generateTicket(Customer customer) {
		boolean isAvailable = true;
		while(isAvailable) {
		Integer ticket = ThreadLocalRandom.current().nextInt(100, 900);
		if(!tickets.contains(ticket)) {
			tickets.add(ticket);
			customer.generateTicket(ticket);
			isAvailable = false;
			}
		}
	}
}
