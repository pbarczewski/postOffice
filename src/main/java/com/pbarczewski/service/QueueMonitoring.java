package com.pbarczewski.service;

import java.util.List;

import com.pbarczewski.entity.User;

public interface QueueMonitoring {
	List<User> otherUsersInQueue(List<User> users, Object queryParam);
}
