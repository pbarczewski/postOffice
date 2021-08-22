package com.pbarczewski.service;

import java.util.List;
import com.pbarczewski.entity.User;

public interface UserService {
	public List<User> allUsers();
	public void saveUser(User user);
	public List<User> usersInQueue(List<User> users, Object queryParam);
}
