package com.pbarczewski.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pbarczewski.entity.User;
import com.pbarczewski.entityAdditionalInfo.UserStatus;
import com.pbarczewski.exceptions.CustomizeException;
import com.pbarczewski.repository.UserRepository;
import com.pbarczewski.validator.UserLoginValidator;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	private UserLoginValidator userValidator;
	private QueueMonitoring userDetailedInformation;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserLoginValidator userValidator,
			QueueMonitoring userDetailedInformation) {
		this.userRepository = userRepository;
		this.userValidator = userValidator;
		this.userDetailedInformation = userDetailedInformation;
	}

	@Override
	public void saveUser(User user) {
		boolean canBeSaved = userValidator.checkLoginAndPassword(user);
		if (canBeSaved) {
			this.setServiceTimeout(user);
			userRepository.save(user);
		} else {
			throw new CustomizeException("User can't be saved");
		}
	}

	@Override
	public List<User> allUsers() {
		List<User> allUsers = userRepository.allUsers();
		return allUsers;
	}

	@Override
	public List<User> usersInQueue(List<User> users, Object queryParam) {
		List<User> usersInQueue = userDetailedInformation.otherUsersInQueue(users, queryParam);
		return usersInQueue;
	}

	private void setServiceTimeout(User user) {
		if (user.getStatus() == UserStatus.SPECIAL) {
			user.setService_timeout(60);
		}
	}
}
