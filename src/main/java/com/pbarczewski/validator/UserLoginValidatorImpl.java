package com.pbarczewski.validator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.pbarczewski.entity.User;

import com.pbarczewski.entityAdditionalInfo.PinNumbers;
import com.pbarczewski.entityAdditionalInfo.UserStatus;

@Component
public class UserLoginValidatorImpl implements UserLoginValidator {
	private static Map<UserStatus, String> passwords;

	static {
		passwords = new HashMap<>();
		passwords.put(UserStatus.SPECIAL, PinNumbers.SPECIAL_PIN.getPin());
		passwords.put(UserStatus.VIP, PinNumbers.VIP_PIN.getPin());
	}

	@Override
	public boolean checkLoginAndPassword(User user) {
		if (user.getStatus() == UserStatus.NORMAL && user.getPin() == "") {
			return true;
		}
		if (passwords.containsKey(user.getStatus()) && passwords.get(user.getStatus()).equals(user.getPin())) {
			return true;
		}
		return false;
	}
}
