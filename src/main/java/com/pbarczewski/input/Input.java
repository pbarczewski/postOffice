package com.pbarczewski.input;

public class Input {
	private String nickname;
	private String pin;
	
	public Input(String nickname, String pin) {
		if(nickname == null || pin == null) 
			throw new NullPointerException("Nickname and pin can't be null");
			
		this.nickname = nickname;
		this.pin = pin;
		
		if(!this.nickname.matches("[a-zA-Z0-9]{3,10}")) {
			throw new IllegalArgumentException("Nickname is too long");
		} 
		if(!this.pin.matches("[0-9]{4}") && !this.pin.equals("") ) {
			System.out.print(pin);
			throw new IllegalArgumentException("Pin is not correct");
		}
	}

	public String getNickname() {
		return nickname;
	}

	public String getPin() {
		return pin;
	}
}
