package com.pbarczewski.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pbarczewski.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select new com.pbarczewski.entity.User(ticket, nick, service_timeout) from User " + "ORDER BY "
			+ "CASE  " + "WHEN status='SPECIAL' THEN 1 " + "WHEN status='VIP' THEN 2 " + "else 3 " + "end, "
			+ "status, " + "id")
	public List<User> allUsers();
}
