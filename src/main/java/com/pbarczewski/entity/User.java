package com.pbarczewski.entity;

import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pbarczewski.entityAdditionalInfo.UserStatus;

@Entity
@Table(name = "User")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer ticket;

	@Column(nullable = false, unique = true)
	private String nick;

	@Enumerated(EnumType.STRING)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private UserStatus status = UserStatus.NORMAL;

	@Transient
	private String pin;
	
	@JsonIgnore
	private Integer service_timeout = 20;

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer waitingTime;

	public User() {}

	public User(Integer waitingTime) {
		this.waitingTime = waitingTime;
	}

	public User(Integer ticket, String nick) {
		this.ticket = ticket;
		this.nick = nick;
	}

	public User(Integer ticket, String nick, Integer service_timeout) {
		this.ticket = ticket;
		this.nick = nick;
		this.service_timeout = service_timeout;
	}

	@PrePersist
	private void generateUniqueTicket() {
		this.ticket = new Random().nextInt(5000) + 1000;
	}

	public Integer getTicket() {
		return ticket;
	}

	public void setTicket(Integer ticket) {
		this.ticket = ticket;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Integer getService_timeout() {
		return service_timeout;
	}

	public void setService_timeout(Integer service_timeout) {
		this.service_timeout = service_timeout;
	}

	public Integer getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(Integer waitingTime) {
		this.waitingTime = waitingTime;
	}
}
