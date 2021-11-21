package com.pbarczewski.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@DiscriminatorValue("2")
public class VipCustomer extends Customer {
	
	private VipCustomer() {
		
	}
	
	public VipCustomer(String nickname) {
		super(nickname);
	}
}
