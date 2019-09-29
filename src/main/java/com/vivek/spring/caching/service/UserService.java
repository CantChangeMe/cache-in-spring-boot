package com.vivek.spring.caching.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vivek.spring.caching.model.User;

@Service
@CacheConfig(cacheNames = "user")// tells Spring where to store cache for this class
public class UserService {
	List<User> userlist = new ArrayList<>();

	@Autowired
	public UserService() {
	}

	@PostConstruct
	private void fillUsers() {
		
		userlist.add(User.builder().username("user_1").age(20).build());
		userlist.add(User.builder().username("user_2").age(76).build());
		userlist.add(User.builder().username("user_3").age(54).build());
		userlist.add(User.builder().username("user_4").age(30).build());
	}

	@Cacheable // caches the result of findAll() method
	public List<User> findAll() {
		simulateSlowService();
		return userlist;
	}

	private void simulateSlowService() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@CachePut
	public User updateUser(User user) {
	    this.userlist.set(0, user);
	    return this.userlist.get(0);
	}

}
