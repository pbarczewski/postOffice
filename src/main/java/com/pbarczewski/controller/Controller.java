package com.pbarczewski.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pbarczewski.entity.User;
import com.pbarczewski.exceptions.CustomizeException;
import com.pbarczewski.service.UserService;

@RestController()
@RequestMapping("/api")
public class Controller {
	private UserService userService;

	@Autowired
	public Controller(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> getAllUsers(@RequestParam(required = false) String nick,
			@RequestParam(required = false) Integer ticket) {
		Object queryParam = null;
		if (nick == null && ticket == null) {
			return userService.allUsers();
		}
		if (nick != null && ticket != null) {
			throw new CustomizeException("You can use only one parameter");
		} else if (nick == null) {
			queryParam = ticket;
		} else {
			queryParam = nick;
		}
		return userService.usersInQueue(userService.allUsers(), queryParam);
	}

	@PostMapping("/users")
	public void saveUser(@RequestBody User user) {
		userService.saveUser(user);
	}
}
