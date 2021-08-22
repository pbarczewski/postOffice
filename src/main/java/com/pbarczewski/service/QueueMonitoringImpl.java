package com.pbarczewski.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.pbarczewski.entity.User;

@Component
public class QueueMonitoringImpl implements QueueMonitoring {
	@Override
	public List<User> otherUsersInQueue(List<User> users, Object queryParam) {
		User user = users.stream().filter(i -> i.getNick().equals(queryParam) || i.getTicket().equals(queryParam))
				.findFirst().get();
		if (user != null) {
			List<User> usersInQueue = users.subList(0, users.indexOf(user));
			Integer remainingTime = countWaitingTime(usersInQueue);
			this.setWaitingInfo(user, remainingTime);
			return users.subList(0, users.indexOf(user) + 1);
		} else {
			return null;
		}
	}

	private Integer countWaitingTime(List<User> users) {
		Integer remainingTime = null;
		if (users.size() == 0) {
			remainingTime = 0;
			return remainingTime;
		} else {
			remainingTime = users.stream().map(user -> user.getService_timeout()).reduce(0, Integer::sum);
			return remainingTime;
		}
	}

	private User setWaitingInfo(User user, Integer remainingTime) {
		if (user != null) {
			user.setNick(null);
			user.setTicket(null);
			user.setWaitingTime(remainingTime);
		}
		return user;
	}
}
