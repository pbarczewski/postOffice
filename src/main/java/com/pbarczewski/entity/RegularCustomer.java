package com.pbarczewski.entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@DiscriminatorValue("3")
public class RegularCustomer extends Customer {
	
	private RegularCustomer() {
		
	}
	
	public RegularCustomer(String nickname) {
		super(nickname);
	}
}
