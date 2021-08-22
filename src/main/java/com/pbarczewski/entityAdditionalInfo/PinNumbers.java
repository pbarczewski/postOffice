package com.pbarczewski.entityAdditionalInfo;

public enum PinNumbers {
	VIP_PIN("9999"), 
	SPECIAL_PIN("0000");

	private PinNumbers(String pin) {
		this.pin = pin;
	}

	private String pin;

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
}
