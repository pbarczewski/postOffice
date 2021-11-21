package com.pbarczewski.entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@DiscriminatorValue("1")
public class UniqueCustomer extends Customer {	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private final Integer time = 60;
	
	private UniqueCustomer() {
		
	}
	
	public UniqueCustomer(String nickname) {
		super(nickname);
	}

	public Integer getTime() {
		return time;
	}
}
