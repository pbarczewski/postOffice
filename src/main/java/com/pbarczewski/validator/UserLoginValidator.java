package com.pbarczewski.validator;

import com.pbarczewski.entity.User;

public interface UserLoginValidator {
	boolean checkLoginAndPassword(User user);
}
