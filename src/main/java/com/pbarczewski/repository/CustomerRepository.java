package com.pbarczewski.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pbarczewski.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public List<Customer> findAllByOrderByType();
	public Customer findByTicket(Integer ticket);
	public Customer findByNickname(String nickname);
}
