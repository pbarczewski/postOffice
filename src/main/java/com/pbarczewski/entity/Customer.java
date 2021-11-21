package com.pbarczewski.entity;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Customer")
@JsonInclude(Include.NON_NULL)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",discriminatorType = DiscriminatorType.INTEGER)
public abstract class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer ticket;
	private String nickname;
	private Integer waitingTime;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private final Integer time = 20;
	@Column(name= "TYPE", insertable=false, updatable=false)
	private int type;
	
	protected Customer() {
		
	}
	
	protected Customer(String nickname) {
		this.nickname = new String(nickname);
	}
	
	public void generateTicket(Integer ticket) {
		this.ticket = new Integer(ticket);
	}
	
	public Integer getTicket() {
		return ticket;
	}

	public String getNickname() {
		return nickname;
	}

	public Integer getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(Integer waitingTime) {
		this.waitingTime = waitingTime;
	}

	public Integer getTime() {
		return time;
	}
}
